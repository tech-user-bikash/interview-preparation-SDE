package com.dsa.tree.bst;

import com.dsa.tree.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/?envType=problem-list-v2&envId=binary-search-tree
public class DeleteNodeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        DeleteNodeBST deleteNode = new DeleteNodeBST();
        var ans = deleteNode.deleteNode(root,3);
        System.out.println(ans);

    }

    // TC : O(Height of Tree ~ log N)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // delete root node. join left and right of deleted node
        if (root.data == key) {
            return joinLeftRight(root);
        }
        // search the node
        TreeNode curr = root;
        while (curr != null) {
            // go right
            if (key > curr.data) {
                if (curr.right != null && curr.right.data == key) {
                    curr.right = joinLeftRight(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            } else {
                if (curr.left != null && curr.left.data == key) {
                    curr.left = joinLeftRight(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return root;
    }


    // join the left & right node
    private TreeNode joinLeftRight(TreeNode node) {
        // for only right node
        if (node.left == null) {
            return node.right;
        }
        // for only left node
        else if (node.right == null) {
            return node.left;
        }
        // if left & right exists, then join right node with left node's right most node
        else {
            // hold right node
            TreeNode rightNode = node.right;
            // get right most node from left
            TreeNode lastRightNode = findLastRightNode(node.left);
            // join left right most node with right node
            lastRightNode.right = rightNode;
            // return left node
            return node.left;
        }
    }

    private TreeNode findLastRightNode(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findLastRightNode(node.right);
    }
}
