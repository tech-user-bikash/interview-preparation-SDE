package com.dsa.tree.bst;

import com.dsa.tree.TreeNode;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=problem-list-v2&envId=binary-search-tree
public class FIndKthSmallestNodeBST {
    int count = 0, ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }
        inorder(root.right, k);
    }
}
