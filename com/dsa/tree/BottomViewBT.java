package com.dsa.tree;

import java.util.*;

// https://www.youtube.com/watch?v=0FtVY6I4pB8&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=23
// https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomViewBT {
    static class Node {
        int data; //data of the node
        int hd; //horizontal distance of the node
        Node left, right; //left and right references

        // Constructor of tree node
        public Node(int key) {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        root.right = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        var ans = bottomView(root);
        System.out.println(ans);
    }

    // TC: O(N), SC: O(N)
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> Q = new LinkedList<>();
        root.hd = 0;
        Q.add(root);

        while (!Q.isEmpty()) {
            Node node = Q.poll();
            int hd = node.hd;

            // only last node add into map. Here each time added into map
            // because map will replace the next occurrence value for same key.
            map.put(hd, node.data);

            if (node.left != null) {
                node.left.hd = hd - 1;
                Q.offer(node.left);
            }

            if (node.right != null) {
                node.right.hd = hd + 1;
                Q.offer(node.right);
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}
