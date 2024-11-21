package com.dsa.tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostOrderTraversal {
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

        preInPostOrderTraversal(root);
    }

    static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode _node, int _num) {
            this.node = _node;
            this.num = _num;
        }
    }

    private static void preInPostOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<Pair> st = new Stack<>();
        // 1 = pre order, 2 = In order, 3 = Post Order
        st.push(new Pair(root, 1));
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        while (!st.isEmpty()) {
            Pair p = st.pop();
            // this part is for pre-order, increment num 1 to 2 and push the left side of the tree
            if (p.num == 1) {
                preOrder.add(p.node.data);
                p.num++;
                st.push(p);
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 1));
                }
            } else if (p.num == 2) {
                inOrder.add(p.node.data);
                p.num++;
                st.push(p);
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 1));
                }
            } else {
                postOrder.add(p.node.data);
            }
        }
        System.out.println("Pre Order :" + preOrder);
        System.out.println("In Order :" + inOrder);
        System.out.println("Post Order :" + postOrder);
    }
}
