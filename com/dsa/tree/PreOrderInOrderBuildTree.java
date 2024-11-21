package com.dsa.tree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/1447469691/
// https://www.youtube.com/watch?v=G5c1wM3Kpuw&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=3
public class PreOrderInOrderBuildTree {
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     Map<Integer, Integer> inOrderMap = new HashMap<>();
    //     for(int i = 0; i<inorder.length; i++){
    //         inOrderMap.put(inorder[i], i);
    //     }
    //     return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
    // }

    // private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
    //                             int[] inorder, int inStart, int inEnd,
    //                             Map<Integer, Integer> inOrderMap) {

    //     // check preorder and inorde array in range
    //     if(preStart > preEnd || inStart > inEnd){
    //         return null;
    //     }

    //     // create Root Node
    //     TreeNode root = new TreeNode(preorder[preStart]);

    //     int inRootIdx = inOrderMap.get(root.val);
    //     int numsLeftInOrderFromRoot = inRootIdx - inStart;

    //     root.left = buildTree(preorder, preStart + 1, preStart + numsLeftInOrderFromRoot,
    //                         inorder, inStart, inRootIdx -1, inOrderMap);
    //     root.right =  buildTree(preorder, preStart + numsLeftInOrderFromRoot + 1, preEnd,
    //                         inorder, inRootIdx + 1, inEnd, inOrderMap);
    //     return root;

    // }
    // private int i = 0;
    // private int p = 0;

    private final Map<Integer, Integer> inOrderMap = new HashMap<>();
    private int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // return build(preorder, inorder, Integer.MIN_VALUE);

        int n = preorder.length;
        // Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i<n; i++){
            inOrderMap.put(inorder[i], i);
        }
        return solve(preorder, 0, n-1);

    }

    private TreeNode solve(int[] preorder, int inStart, int inEnd){
        if(inStart > inEnd) return null;

        int rootVal = preorder[preIdx];
        int inIdx = inOrderMap.get(rootVal);

        // increase preorder index
        preIdx++;

        // create Root
        TreeNode root = new TreeNode(rootVal);

        root.left = solve(preorder, inStart, inIdx - 1);
        root.right = solve(preorder, inIdx + 1, inEnd);

        return root;
    }
    // private TreeNode build(int[] preorder, int[] inorder, int stop) {
    //     if (p >= preorder.length) {
    //         return null;
    //     }
    //     if (inorder[i] == stop) {
    //         ++i;
    //         return null;
    //     }

    //     TreeNode node = new TreeNode(preorder[p++]);
    //     node.left = build(preorder, inorder, node.val);
    //     node.right = build(preorder, inorder, stop);
    //     return node;
    // }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};

        PreOrderInOrderBuildTree build = new PreOrderInOrderBuildTree();
        var ans = build.buildTree(preorder, inorder);
        System.out.println(ans);
    }

}
