package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.LinkedList;

// https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
public class WidthOfBinaryTree2 {

    /**
     * 求二叉树的最大宽度，包含空节点。注意，最右侧的节点为空不用计算。
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     */
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        int maxWidth = 0;
        root.val = 1;
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            int leftVal = 0;
            int rightVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                if (i == 0) {
                    leftVal = node.val;
                }
                if (i == size - 1) {
                    rightVal = node.val;
                }
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    list.addLast(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    list.addLast(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, rightVal - leftVal + 1);
        }
        return maxWidth;
    }

}
