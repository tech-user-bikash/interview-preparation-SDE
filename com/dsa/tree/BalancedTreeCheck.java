package com.dsa.tree;

// https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=15
/**
 * Balance BT = for every node, height(left) - height(right) <= 1
 */
public class BalancedTreeCheck {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BalancedTreeCheck check = new BalancedTreeCheck();
        var ans = check.isBalanced(root);
        System.out.println(ans);

        ans = check.isBalancedBruteForce(root);
        System.out.println(ans);
    }

    // TC: O(N X N)
    // for each node height will be calculated.
    private boolean isBalancedBruteForce(TreeNode root) {
        if(root == null){
            return true;
        }
        // O(N)
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) return false;

        boolean leftTree = isBalancedBruteForce(root.left);
        boolean rightTree = isBalancedBruteForce(root.right);

        return leftTree && rightTree;
    }

    private int getTreeHeight(TreeNode node) {
        if(node == null) return 0;
        int left = getTreeHeight(node.left);
        int right = getTreeHeight(node.right);
        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        int ans = checkBalancedTree(root);
        return ans != -1;
    }

    // TC: O(N)
    private int checkBalancedTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = checkBalancedTree(root.left);
        if(left == -1) return -1;

        int right = checkBalancedTree(root.right);
        if(right == -1) return -1;

        if( Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}
