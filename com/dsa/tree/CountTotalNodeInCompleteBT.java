package com.dsa.tree;

// https://www.youtube.com/watch?v=2XTXL7a6ItI
// https://leetcode.com/problems/count-complete-tree-nodes/
public class CountTotalNodeInCompleteBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        int ans = countNodes(root);
        System.out.println(ans);
    }

    // O(log N) ^ 2
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        // get left height
        int leftHeight = getLeftHeight(root);
        // get right height
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            return (2<<leftHeight)-1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    private static int getRightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

}
