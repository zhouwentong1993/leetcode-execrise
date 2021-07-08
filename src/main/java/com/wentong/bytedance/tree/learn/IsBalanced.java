package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

// 判断一棵二叉树是否是平衡树
// 明确题意，什么是平衡树。
// 从左右子树里面获取想要的信息，即高度与是否平衡。
// 为什么需要这些信息呢？因为这些信息是判断是否是平衡树的必要条件。
// 也就是说，拥有了这些条件，我就可以做判断了。
// https://leetcode-cn.com/problems/balanced-binary-tree/
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return getInfo(root).isBalanced;
    }

    private Info getInfo(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = getInfo(node.left);
        Info rightInfo = getInfo(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        if (leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) <= 1) {
            return new Info(true, height);
        } else {
            return new Info(false, height);
        }
    }

    static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
