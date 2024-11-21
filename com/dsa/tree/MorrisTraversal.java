package com.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=39
public class MorrisTraversal {
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

        MorrisTraversal morris = new MorrisTraversal();

        var ans = morris.preorderTraversal(root);
        System.out.println(ans);
        ans = morris.inorderTraversal(root);
        System.out.println(ans);
        ans = morris.postorderTraversal(root);
        System.out.println(ans);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        if(root == null){
            return preorderList;
        }
        TreeNode curr = root;
        while(curr != null){
            // case-I: if no left node is there, print root(current) node and move right.
            if(curr.left == null){
                preorderList.add(curr.data);
                curr = curr.right;
            } else {
                // case-II: move left subtree and make a link between right most node with root
                TreeNode prev = curr.left;
                // Keep moving right node till end and link shouldn't present.
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                // case - III: after reaching last right node, there will be 2 cases.
                // 1. right may be null
                // 2. right may be linked with parent.
                if(prev.right == null){
                    //link with parent
                    prev.right = curr;
                    preorderList.add(curr.data);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }

            }
        }
        return preorderList;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        if(root == null){
            return inorderList;
        }
        TreeNode curr = root;
        while(curr != null){
            // case-I: if no left node is there, print root(current) node and move right.
            if(curr.left == null){
                inorderList.add(curr.data);
                curr = curr.right;
            } else {
                // case-II: move left subtree and make a link between right most node with root
                TreeNode prev = curr.left;
                // Keep moving right node till end and link shouldn't present.
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                // case - III: after reaching last right node, there will be 2 cases.
                // 1. right may be null
                // 2. right may be linked with parent.
                if(prev.right == null){
                    //link with parent
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorderList.add(curr.data);
                    curr = curr.right;
                }

            }
        }
        return inorderList;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // Morris Traversal
        List<Integer> postorderList = new ArrayList<>();
        if(root == null){
            return postorderList;
        }
        TreeNode curr = root;
        while(curr != null){
            // If right child is null,  put the current node data in res. Move to left child.
            if(curr.right == null){
                postorderList.add(curr.data);
                curr = curr.left;
            } else {
                TreeNode prev = curr.right;
                while(prev.left != null && prev.left != curr){
                    prev = prev.left;
                }

                // If left child doesn't point to this node, then put in res
                // this node and make left child point to this node
                if(prev.left == null){
                    postorderList.add(curr.data);
                    //link with parent
                    prev.left = curr;
                    curr = curr.right;
                }
                // If the left child of inorder predecessor already points to this node
                else {
                    prev.left = null;
                    curr = curr.left;
                }

            }
        }
        // reverse the res
        Collections.reverse(postorderList);
        return postorderList;
    }
}
