package com.dsa.tree;

import java.util.*;

// https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=22
// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewBT {
    static class Pair {
        TreeNode node;
        int vertical; // horizontal distance

        Pair(TreeNode _n, int _v) {
            this.node = _n;
            this.vertical = _v;
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

        var ans = topView(root);
        System.out.println(ans);
    }
    // TC: O(N), SC: O(N)
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(root, 0));

        while (!Q.isEmpty()) {
            Pair p = Q.poll();
            TreeNode node = p.node;
            int vertical = p.vertical;

            // only first node add into map
            map.putIfAbsent(vertical, node.data);

            if (node.left != null) {
                Q.offer(new Pair(node.left, vertical - 1));
            }

            if (node.right != null) {
                Q.offer(new Pair(node.right, vertical + 1));
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}
