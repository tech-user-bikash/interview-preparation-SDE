package com.dsa.tree;

import java.util.Stack;

public class PreOrderTraversal {

    // Root->Left->Right
    // TC: O(N), SC: O(N)
    private static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // TC: O(N), SC: O(N)
    private static void iterativePreOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);

        while(!st.isEmpty()){
            for(int i=0; i< st.size(); i++){
                TreeNode node = st.pop();
                System.out.print(node.data+" ");
                if(node.right != null){
                    st.push(node.right);
                }
                if(node.left != null){
                    st.push(node.left);
                }
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

        preOrder(root);
        System.out.println();
        iterativePreOrder(root);
    }


}
