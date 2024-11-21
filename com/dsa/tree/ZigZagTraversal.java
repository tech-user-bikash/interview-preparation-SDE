package com.dsa.tree;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=19
public class ZigZagTraversal {
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

        var ans = zigzagLevelOrder(root);
        for(List<Integer> L : ans){
            System.out.println(L);
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagOrderList = new ArrayList<>();
        if(root == null) return zigzagOrderList;

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        boolean isLeftToRight = true;

        while(!Q.isEmpty()){
            int size = Q.size();
            List<Integer> zigzag = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = Q.poll();
                assert node != null;
                // find position
//                 int idx = (isLeftToRight) ? i : (size - i - 1);
//                 zigzag.add(idx, node.data);

                if (isLeftToRight) {
                    zigzag.add(node.data);
                } else {
                    zigzag.add(0, node.data);
                }

                if(node.left != null){
                    Q.add(node.left);
                }
                if(node.right != null){
                    Q.add(node.right);
                }
            }
            isLeftToRight = !isLeftToRight;
            zigzagOrderList.add(zigzag);
        }
        return zigzagOrderList;
    }
}
