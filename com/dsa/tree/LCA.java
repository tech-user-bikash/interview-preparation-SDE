package com.dsa.tree;

// https://www.youtube.com/watch?v=_-QHfMDde90&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=27
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solutions/65226/my-java-solution-which-is-easy-to-understand/
public class LCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        var p = new TreeNode(4);
        var q = new TreeNode(7);

        LCA lca = new LCA();
        var ans = lca.lowestCommonAncestor(root, p, q);
        System.out.println(ans);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // Post Order Traversal
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // check left & right of root
        // if any side is null consider other side
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        // if both side is nonnull then root is the LCA
        else {
            return root;
        }
    }
}
