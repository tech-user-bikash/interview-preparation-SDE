package com.dsa.tree.bst;

import com.dsa.tree.TreeNode;

public class ValidateBST {

    // TC: O(N), SC: O(N)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue){
        if(root == null) return true;
        if(root.data >= maxValue || root.data <= minValue){
            return false;
        }
        return isValidBST(root.left, minValue, root.data) &&
                isValidBST(root.right, root.data, maxValue);
    }
}
