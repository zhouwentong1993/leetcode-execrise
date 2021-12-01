package com.wentong.bytedance.offer;

import com.wentong.bytedance.tree.TreeNode;

//https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
public class IsSubStructure {

    /*
    B 树是否为 A 树的子结构。
    如果 B 树是 A 树的子结构，代表 A 的某个子树和 B 完全一致。
    问题就变成了找到和 B 完全一致的开头位置，然后递归 A 子树的左节点和 B 的左节点 && A 子树的右节点和 B 的右节点。
    终止值：
    - 当 B 为空时，代表扫描结束了，返回 TRUE。
    - 当 A 为空时，代表没有扫描到结果，返回 FALSE。
    - 当 两个结点的值不相等时，返回 FALSE。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return rec(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean rec(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return rec(a.left, b.left) && rec(a.right, b.right);
    }

}
