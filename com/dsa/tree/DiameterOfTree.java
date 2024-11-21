package com.dsa.tree;

/**
 * Diameter :
 *  - longest path between any 2 node.
 *  - path doesn't need to pass via root.
 *
 */
public class DiameterOfTree {
    int max=0;

    // TC: O(N X N)
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);

        max = Math.max(max, left + right);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return max;
    }
    private int getTreeHeight(TreeNode node) {
        if(node == null) return 0;
        int left = getTreeHeight(node.left);
        int right = getTreeHeight(node.right);
        return 1 + Math.max(left, right);
    }

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

        DiameterOfTree diameter = new DiameterOfTree();
        int ans = diameter.diameterOfBinaryTree(root);
        System.out.println(ans);
        diameter.max = 0;
        diameter.findDiameter(root);
        System.out.println(diameter.max);
    }

    // TC: O(N)
    private int findDiameter(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = findDiameter(root.left);
        int rightHeight = findDiameter(root.right);

        max = Math.max(max, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
