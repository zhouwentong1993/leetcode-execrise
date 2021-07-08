package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

public class MaxDistance {

    public int maxDistance(TreeNode root) {
        return process(root).distance;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info leftData = process(node.left);
        Info rightData = process(node.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int distance = Math.max(Math.max(leftData.distance, rightData.distance), leftData.height + rightData.height + 1);
        return new Info(height, distance);
    }

    static class Info {
        int height;
        int distance;

        public Info(int height, int distance) {
            this.height = height;
            this.distance = distance;
        }
    }

}
