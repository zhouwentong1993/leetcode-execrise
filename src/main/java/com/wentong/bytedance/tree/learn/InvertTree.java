package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;


// https://leetcode-cn.com/problems/invert-binary-tree/
public class InvertTree {

    // 二叉树翻转
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
