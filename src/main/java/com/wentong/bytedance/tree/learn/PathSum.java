package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


// 深度优先遍历
// https://leetcode-cn.com/problems/path-sum-ii/

public class PathSum {

    private List<List<Integer>> result = new LinkedList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path(root, targetSum);
        return result;
    }

    private void path(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && targetSum - node.val == 0) {
            result.add(new LinkedList<>(path));
        }

        path(node.left, targetSum - node.val);
        path(node.right, targetSum - node.val);
        path.pollLast();
    }
}
