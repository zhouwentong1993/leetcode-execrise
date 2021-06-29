package com.wentong.bytedance.tree.learn;

import com.wentong.bytedance.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeInPost {

    public TreeNode buildTreeInPost(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return inPostToTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode inPostToTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map) {
        if (ps > pe) {
            return null;
        }
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.left = inPostToTree(inorder, is, rootIndex - 1, postorder, ps, ps + rootIndex - 1 - is, map);
        root.right = inPostToTree(inorder, rootIndex + 1, ie, postorder, ps + rootIndex - is, pe - 1, map);
        return root;
    }
}
