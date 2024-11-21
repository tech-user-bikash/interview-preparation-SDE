package com.dsa.tree.bst;

import com.dsa.tree.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/?envType=problem-list-v2&envId=binary-search-tree
public class LCA_BST {
    // TC: O(log N), Sc: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.data > p.data && root.data > q.data){
            return lowestCommonAncestor(root.left, p, q);
        }

        if(root.data < p.data && root.data < q.data){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
