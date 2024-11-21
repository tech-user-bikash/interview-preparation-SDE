package com.dsa.tree;

import java.util.Stack;

public class PostOrderTraversal {

    // Left->Right->Root
    // TC: O(N), SC: O(N)
    private static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private static void iterativePostOrderUsing2Stack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st_1 = new Stack<>();
        Stack<TreeNode> st_2 = new Stack<>();
        st_1.push(root);

        while (!st_1.isEmpty()) {
            root = st_1.pop();
            st_2.add(root);
            if (root.left != null) {
                st_1.push(root.left);
            }
            if (root.right != null) {
                st_1.push(root.right);
            }
        }

        while (!st_2.isEmpty()) {
            System.out.print(st_2.pop().data + " ");
        }
    }

    // https://www.youtube.com/watch?v=NzIGLLwZBS8&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=12
    // TC: O(2N)
    private static void iterativePostOrderUsing1Stack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    System.out.print(temp.data + " ");
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    curr = temp;
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

        postOrder(root);
        System.out.println();
        iterativePostOrderUsing2Stack(root);
        System.out.println();
        iterativePostOrderUsing1Stack(root);
    }


}
