package com.dsa.tree;

public class CheckSameBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode root_2 = new TreeNode(3);
        root_2.left = new TreeNode(9);
        root_2.right = new TreeNode(20);
        root_2.right.left = new TreeNode(15);
        root_2.right.right = new TreeNode(14);
        CheckSameBT check = new CheckSameBT();
        var ans = check.isSame(root, root_2);
        System.out.println(ans);
    }

    private boolean isSame(TreeNode root_1, TreeNode root_2) {
        if(root_1 == null || root_2 == null){
            return root_1 == root_2;
        }

        return (root_1.data == root_2.data) &&
                isSame(root_1.left, root_2.left) &&
                isSame(root_1.right, root_2.right);
    }
}
