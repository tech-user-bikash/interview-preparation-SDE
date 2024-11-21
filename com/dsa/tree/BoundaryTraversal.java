package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=21
// https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
public class BoundaryTraversal {
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

        BoundaryTraversal traversal = new BoundaryTraversal();
        var ans = traversal.boundary(root);
        System.out.println(ans);
    }

    // TC: O(N)
    ArrayList<Integer> boundary(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeafNode(node)) {
            ans.add(node.data);
        }
        addLeftBoundary(node, ans);
        ans.add(-1);
        addLeafNode(node, ans);
        ans.add(-1);
        addRightBoundary(node, ans);
        return ans;
    }

    private void addLeftBoundary(TreeNode node, ArrayList<Integer> ans) {
        TreeNode curr = node.left;
        while (curr != null) {
            if (!isLeafNode(curr)) {
                ans.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeafNode(TreeNode node, ArrayList<Integer> ans) {
        if (isLeafNode(node)) {
            ans.add(node.data);
            return;
        }

        if (node.left != null) {
            addLeafNode(node.left, ans);
        }
        if (node.right != null) {
            addLeafNode(node.right, ans);
        }
    }

    private void addRightBoundary(TreeNode node, ArrayList<Integer> ans) {
        TreeNode curr = node.right;
        // store node's to reverse at the end
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeafNode(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return node != null &&
                node.left == null &&
                node.right == null;
    }
}
