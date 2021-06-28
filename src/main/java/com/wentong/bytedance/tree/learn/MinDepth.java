package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depth(root, 1);
    }

    // 什么是最小深度，最小深度就等于左子树的最小深度和右子树的最小深度中间最小的那个。
    // 递归出口是当遇到叶子节点，返回。递归循环条件是，每当向下走一层时，深度 + 1
    private int depth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            return depth;
        }
        int ans = Integer.MAX_VALUE;
        if (node.left != null) {
            ans = Math.min(depth(node.left, depth + 1), ans);
        }
        if (node.right != null) {
            ans = Math.min(depth(node.right, depth + 1), ans);
        }

        return ans;
    }

}
