package com.dsa.tree;

import java.util.*;
import java.util.stream.Collectors;

//https://www.youtube.com/watch?v=q_a6lpbKJdw&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=21
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalTraversal {
    static class Tuple {
        TreeNode node;
        int level;
        int vertical;
        Tuple(TreeNode _n, int _v, int _l){
            this.node = _n;
            this.level = _l;
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

        VerticalTraversal vertical = new VerticalTraversal();
        var ans = vertical.verticalTraversal(root);
        System.out.println(ans);
    }

    // TC: N Log N where N == general traversal for all node , logN=(Priority Queue)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> Q = new LinkedList<>();
        // level = 0 and vertical = 0
        Q.add(new Tuple(root, 0, 0));

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!Q.isEmpty()) {
            Tuple t = Q.poll();
            TreeNode node = t.node;
            int level = t.level;
            int vertical = t.vertical;

            // create space if it doesn't exist for level & vertical
            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }

            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).add(node.data);

            // check both left & right and put into Queue
            if(node.left != null){
                Q.add(new Tuple(node.left, vertical - 1, level + 1));
            }
            if(node.right != null){
                Q.add(new Tuple(node.right, vertical + 1, level + 1));
            }
        }

//        return map.values().stream()
//                .map(x -> x.values().stream()
//                        .flatMap(Collection::stream)
//                        .collect(Collectors.toList()))
//                .toList();


        List<List<Integer>> res = new ArrayList<>();
        for(Map<Integer, PriorityQueue<Integer>> X : map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> PQ : X.values()){
                while(!PQ.isEmpty()){
                    res.get(res.size() - 1).add(PQ.poll());
                }
            }
        }
        return res;
    }
}
