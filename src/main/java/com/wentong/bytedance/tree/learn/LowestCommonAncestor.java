package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.*;

public class LowestCommonAncestor {

    // 聪明的做法，利用递归。
    // 定义当前节点为 X，分情况讨论：
    // ① 如果 X 是 p 或 q 或 null，则返回当前节点。
    // ② 如果 X 的左右子树都为空，则返回 null。
    // ③ 如果 X 的左子树或右子树是 p 或 q，那么返回 X.left 或者 x.right。
    // ④ 如果 X 的左右子树就是 p 和 q，那么返回 X
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 步骤 ①
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 步骤 ④
        if (left != null && right != null) {
            return root;
        }
        // 步骤 ② 和 ③
        // ② 此处如果 left 和 right 都为空，则返回 right，也就是 null。
        // ③ 如果 left 和 right 有一个为空，则返回其中不为空的那个。
        return left != null ? left : right;

    }

    // 暴力解法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> map = getNodeParentReleation(root);
        TreeNode pParent = map.get(p.val);
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        set.add(pParent);
        while (true) {
            TreeNode parent = map.get(pParent.val);
            if (parent != pParent) {
                set.add(parent);
                pParent = parent;
            } else {
                break;
            }
        }
        if (set.contains(q)) {
            return q;
        }

        while (true) {
            TreeNode qParent = map.get(q.val);
            if (set.contains(qParent)) {
                return qParent;
            } else {
                q = qParent;
            }
        }

    }

    private Map<Integer, TreeNode> getNodeParentReleation(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root.val, root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left.val, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right.val, node);
            }
        }
        return map;
    }

}
