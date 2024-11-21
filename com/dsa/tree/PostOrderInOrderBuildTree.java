package com.dsa.tree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//
public class PostOrderInOrderBuildTree {
    private final Map<Integer, Integer> inOrderMap = new HashMap<>();
    private int postIdx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        postIdx = n-1;
        for(int i = 0; i<n; i++){
            inOrderMap.put(inorder[i], i);
        }
        return solve(postorder, 0, n-1);
    }

    private TreeNode solve(int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;

        int rootVal = postorder[postIdx];
        int inIdx = inOrderMap.get(rootVal);

        // increase preorder index
        postIdx--;

        // create Root
        TreeNode root = new TreeNode(rootVal);

        root.right = solve(postorder, inIdx + 1, inEnd);
        root.left = solve(postorder, inStart, inIdx - 1);

        return root;
    }
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};

        PostOrderInOrderBuildTree build = new PostOrderInOrderBuildTree();
        var ans = build.buildTree(inorder, postorder);
        System.out.println(ans);
    }

}
