package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/

/**
 * 二叉树的 Z 形遍历，也称为锯齿形遍历
 * 因为顺序不一致，所以不能单纯地依赖单一出口的数据结构，这里我们通过 LinkedList 来实现。
 * 奇数层和偶数层的数据的读取和存入的方式不一样，画图举例子就能看出来了。
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int level = 0;
        LinkedList<TreeNode> container = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        container.add(root);

        while (!container.isEmpty()) {
            int size = container.size();
            List<Integer> list = new ArrayList<>(container.size());
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    TreeNode node = container.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        container.addLast(node.left);
                    }
                    if (node.right != null) {
                        container.addLast(node.right);
                    }
                } else {
                    TreeNode node = container.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        container.addFirst(node.right);
                    }
                    if (node.left != null) {
                        container.addFirst(node.left);
                    }
                }
            }
            level = level + 1;
            result.add(list);
        }
        return result;

    }

}
