package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DepthTraversal {

    public List<Integer> depthTraversal(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        return null;
    }

}
