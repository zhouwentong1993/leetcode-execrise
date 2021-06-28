package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

    // 求二叉树的最大宽度，题目中的还要包含空节点，先把不包含空节点的记录下来。
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        int queueSize = 1;
        for (int i = 0; i < queueSize; i++) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (i == queueSize - 1) {
                queueSize = queue.size();
                max = Math.max(queueSize, max);
            }
        }
        return max;
    }
}
