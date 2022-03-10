package com.wentong.leetcode.tree;

public class IsValidBST {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }


}
