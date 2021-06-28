package com.wentong.bytedance.linkedlist.learn;

import com.wentong.bytedance.tree.TreeNode;

public class PrintTreeNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(7, new TreeNode(Integer.MIN_VALUE), new TreeNode(899999999)), new TreeNode(222, null, new TreeNode(777771117)));
        printTreeNode(root);
    }

    public static void printTreeNode(TreeNode root) {
        printRecursive(root, 0, "H", 17);
    }

    private static void printRecursive(TreeNode node, int height, String to, int digit) {
        if (node == null) {
            return;
        }
        printRecursive(node.right, height + 1, "^", 17);
        String val = to + node.val + to;
        int leftSpaceCount = digit - val.length() / 2;
        int rightSpaceCount = digit - val.length() - leftSpaceCount;
        String strVal = getSpace(leftSpaceCount) + val + getSpace(rightSpaceCount);
        String blanks = getSpace(digit * height);
        System.out.println(blanks + strVal);
        printRecursive(node.left, height + 1, "v", 17);
    }

    private static String getSpace(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

}
