package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;


// https://leetcode-cn.com/problems/successor-lcci/
public class GetNextNode2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.right != null) {
            return findMostLeft(p.right);
        } else {
            return findByRoot(root, p);
        }
    }

    private TreeNode findMostLeft(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode findByRoot(TreeNode root, TreeNode target) {
        List<TreeNode> nodes = new ArrayList<>();
        addNodesWithMid(root, nodes);
        int index = nodes.indexOf(target);
        return index == nodes.size() - 1 ? null : nodes.get(index + 1);
    }

    private void addNodesWithMid(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        addNodesWithMid(node.left, list);
        list.add(node);
        addNodesWithMid(node.right, list);
    }
}
