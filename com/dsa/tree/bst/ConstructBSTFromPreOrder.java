package com.dsa.tree.bst;

import com.dsa.tree.TreeNode;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

/**
 * It can be done using 3 approaches.
 * 1. check every element from preorder array and compare with current node,
 *    root.val > val = left, else right
 *    TC: O(N X N)
 * 2. every BST inorder is sorted in manner.
 *    by sorting the preorder array, create inorder
 *    by using preorder and inorder array, construct BST.
 *    TC: O(N log N) + O(N)
 * 3. Check below code for most optimized one.
 */
public class ConstructBSTFromPreOrder {

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        var ans = bstFromPreorder(preorder);
        System.out.println(ans);
    }

    // TC: O(3N) ~ O(N)
    public static TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private static TreeNode constructBST(int[] preorder, int upperBound, int[] index){
        // boundary check
        if(preorder.length == index[0] || preorder[index[0]] > upperBound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]++]);
        // for left node, upperbound will be the current root value
        root.left = constructBST(preorder, root.data, index);
        root.right = constructBST(preorder, upperBound, index);
        return root;
    }
}
