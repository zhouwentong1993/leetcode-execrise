package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreIn {

    // 通过前序和中序配合，还原一棵树
    public TreeNode BuildTreePreIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(((int) (inorder.length / 0.75)) + 1);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return tree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode tree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (pe > is) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = map.get(preorder[ps]);
        root.left = tree(preorder, ps + 1, rootIndex + ps - is, inorder, is, rootIndex - 1, map);
        root.right = tree(preorder, rootIndex + ps - is + 1, pe, inorder, rootIndex + 1, ie, map);
        return root;
    }

}
