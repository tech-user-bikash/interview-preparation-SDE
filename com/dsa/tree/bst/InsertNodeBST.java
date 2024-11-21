package com.dsa.tree.bst;

import com.dsa.tree.TreeNode;

public class InsertNodeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        var ans = insertIntoBST(root,5);
        System.out.println(ans);

    }

    // TC: O(log N)
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        while(true){
            // go right side
            if(val > curr.data){
                if(curr.right != null){
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            // go left
            else {
                if(curr.left != null){
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
