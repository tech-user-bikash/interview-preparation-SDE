package com.dsa.tree;

public class DepthTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        int ans = getDepth(root);
        System.out.println(ans);
    }

    // TC: O(N), SC: O(N)
    private static int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        // 1 = root node + left & right max
        return 1 + Math.max(left, right);
    }
}
