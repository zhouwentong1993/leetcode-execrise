package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric {

    // 判断是否是对称的，在做递归相关的问题，要想问题的最小可解决范围是什么？
    // 像这道题，如何判断两个结点对称，很简单，如果都不为空 && 值相等就是对称的了，那么如果有子树怎么办呢？
    // 很简单，子树也用这种方法判断不就行了！于是递归就出现了。我就管着定义规则，具体执行让递归去做就行了。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }


    // 非递归做法，核心步骤其实和递归一致。类似的问题都是借助于队列完成。
    // 首先要明确题意，什么是镜像，简单来说就是当前节点们（A、B）一致，A.left == B.right; A.right == B.left;
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null) {
                return false;
            }
            if (first.val != second.val) {
                return false;
            }
            queue.add(first.left);
            queue.add(second.right);
            queue.add(first.right);
            queue.add(second.left);
        }
        return true;
    }


}
