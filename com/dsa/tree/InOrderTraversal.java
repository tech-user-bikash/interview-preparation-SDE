package com.dsa.tree;

import java.util.Stack;

public class InOrderTraversal {

    // Left->Root->Right
    // TC: O(N), SC: O(N)
    private static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    private static void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode tempNode = root;
        while(true){
            if(tempNode != null){
                st.push(tempNode);
                tempNode = tempNode.left;
            } else {
                if(st.isEmpty()) break;
                tempNode = st.pop();
                System.out.print(tempNode.data+" ");
                tempNode = tempNode.right;
            }
        }
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

        inOrder(root);
        System.out.println();
        iterativeInOrder(root);
    }
}
