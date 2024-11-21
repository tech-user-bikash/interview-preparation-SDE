package com.dsa.tree.bst;

import com.dsa.tree.BottomViewBT;
import com.dsa.tree.TreeNode;

public class SearchNodeBST {

    // TC: O(log N)
    public static TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.data != val){
            root = root.data > val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);

        var ans = searchBST(root,2);
        System.out.println(ans);
    }
}
