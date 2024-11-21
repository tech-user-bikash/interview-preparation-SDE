package com.dsa.tree;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
// https://www.youtube.com/watch?v=WszrfSwMz58&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=17
public class MaxPathSum {
    int max_path_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return max_path_sum;
    }

    private int getMaxPathSum(TreeNode root){
        if(root == null) return 0;

//        int leftNodeSum = getMaxPathSum(root.left);
//        // don't consider -ve sum for max sum calculation
//        if(leftNodeSum < 0) leftNodeSum = 0;
//
//        int rightNodeSum = getMaxPathSum(root.right);
//        // don't consider -ve sum for max sum calculation
//        if(rightNodeSum < 0) rightNodeSum = 0;

        // don't consider -ve sum for max sum calculation
        int leftNodeSum = Math.max(0, getMaxPathSum(root.left));
        int rightNodeSum = Math.max(0, getMaxPathSum(root.right));

        // for each node calculate the max sum
        max_path_sum = Math.max(max_path_sum, (root.data + leftNodeSum + rightNodeSum));

        return root.data + Math.max(leftNodeSum, rightNodeSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(-30);
        root.right.right = new TreeNode(-15);

        MaxPathSum pathSum = new MaxPathSum();
        var ans = pathSum.maxPathSum(root);
        System.out.println(ans);

    }
}
