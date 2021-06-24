package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric {

    // 层次遍历不行。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                TreeNode node = queue.poll();
                if (node.left == null) {
                    return true;
                }
                if (node.left.val != node.right.val) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            } else {
                TreeNode first = queue.poll();
                TreeNode second = queue.poll();

            }

        }
        return false;
    }

}
