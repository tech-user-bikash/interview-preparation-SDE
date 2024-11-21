package com.dsa.tree;

// https://www.youtube.com/watch?v=fnmisPM6cVo&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=29
// https://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property-set-2/
public class ChildrenSumBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(30);
        
        convertTree(root);
        
        printConvertedTree(root);
    }

    private static void printConvertedTree(TreeNode root) {
        if (root == null)
            return;

        // Recursive call to left child
        printConvertedTree(root.left);

        // Printing the node's data
        System.out.print(root.data+ " ");

        // Recursive call to right child
        printConvertedTree(root.right);
    }

    // Convert the tree such that it holds children sum property
    // TC: O(N), SC: O(N)
    static void convertTree(TreeNode root) {
        if (root == null) return;

        // Calculating the sum
        // of left and right child
        int childSum = 0;
        if (root.left != null) childSum += root.left.data;
        if (root.right != null) childSum += root.right.data;

        // If sum of child is greater than change the node's data else change the data
        // of left and right child to make sure they will get the maximum possible value
        if (childSum >= root.data) {
            root.data = childSum;
        } else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        // Recursive call for left child
        convertTree(root.left);

        // Recursive call for right child
        convertTree(root.right);

        // Overwriting the parent's data
        int totalSumToChangeParent = 0;
        if (root.left != null) totalSumToChangeParent += root.left.data;
        if (root.right != null) totalSumToChangeParent += root.right.data;
        if (root.left != null || root.right != null) root.data = totalSumToChangeParent;
    }
}
