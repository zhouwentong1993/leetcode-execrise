package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;
import sun.tools.jconsole.MaximizableInternalFrame;

import java.util.*;

public class Traversal {


    // 使用递归，先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        traversal(node.left, list);
        traversal(node.right, list);
    }

    // 使用循环，先序遍历
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            list.add(head.val);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        return list;
    }


    // 递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversalInorder(root, list);
        return list;
    }

    private void traversalInorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }


    // 递归中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    // 二叉树的层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> single = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                single.add(node.val);
            }
            result.add(single);
        }
        return result;
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), null)), new TreeNode(3, null, new TreeNode(6)));
        traversal.depth(node, 1);
        System.out.println(traversal.max);
        int i = traversal.maxDepth(node);
        System.out.println(i);
    }

    int max = 0;

    private void depth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            max = Math.max(depth, max);
        }
        depth(node.left, depth + 1);
        depth(node.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
