package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {

    // 递归解法，判断当前结点的和们是否为 targetSum。很简单，就是当前结点及其子结点的和是否为 targetSum，也就是说，子树的和为 targetSum - node.val 就行。
    // 对于子树来说，也是如此。
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // 利用两个队列来保存数据，一是保存结点，二是保存结果。
    // 利用广度遍历，判断。
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int sum = sumQueue.poll();
            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(sum + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(sum + node.right.val);
            }
        }
        return false;
    }
}
