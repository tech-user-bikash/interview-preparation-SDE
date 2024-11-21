package com.dsa.tree;

// https://www.geeksforgeeks.org/problems/symmetric-tree/1
// https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=25
public class SymmetricTree {
    // return true/false denoting whether the tree is Symmetric or not
    // TC: O(N) , SC: O(N)
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode node_1, TreeNode node_2){
        if(node_1 == null || node_2 == null){
            return node_1 == node_2;
        }

        return (node_1.data == node_2.data) &&
                isSymmetricHelper(node_1.left, node_2.right) &&
                isSymmetricHelper(node_1.right, node_2.left);

    }
}
