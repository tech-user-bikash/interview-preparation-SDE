package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-width-of-binary-tree/
// https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=29
public class MaximumWidthBT {
    static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode _node, int _num) {
            this.node = _node;
            this.num = _num;
        }
    }

    // TC: O(N), SC: O(N)
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(root, 0));

        int ans = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            int first = 0, last = 0;
            // to make id starting from zero
            int n_min = Q.peek().num;

            for (int i = 0; i < size; i++) {
                Pair p = Q.poll();
                assert p != null;
                // TODO: need to understand
                int curr_id = p.num - n_min;
                if (i == 0) {
                    first = curr_id;
                }
                if (i == size - 1) {
                    last = curr_id;
                }
                if (p.node.left != null) {
                    Q.offer(new Pair(p.node.left, 2 * curr_id + 1));
                }
                if (p.node.right != null) {
                    Q.offer(new Pair(p.node.right, 2 * curr_id + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
