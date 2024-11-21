package com.dsa.tree;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

// https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=30
// https://www.youtube.com/watch?v=1PMjfQl_UVQ
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class NodeAtDistanceK {
    /*
             1
            / \
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        NodeAtDistanceK distance = new NodeAtDistanceK();
        var ans = distance.distanceK(root, new TreeNode(2), 2);
        System.out.println(ans);

    }

    Map<Integer, TreeNode> parentMap = new HashMap<>();

    // O(N)
    private void storeParent(TreeNode root){
        if(root == null) {
            return;
        }

        if(root.left != null){
            parentMap.put(root.left.data, root);
        }
        storeParent(root.left);

        if(root.right != null){
            parentMap.put(root.right.data, root);
        }
        storeParent(root.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if(root == null){
            return new ArrayList<>();
        }

        storeParent(root);

        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        // O(N)
        while(!Q.isEmpty()){
            int size = Q.size();

            if( k == 0)
                break;

            while(size-- > 0){
                TreeNode node = Q.poll();
                assert node != null;
                if(node.left != null && !visited.contains(node.left)){
                    Q.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    Q.offer(node.right);
                }
                if(parentMap.containsKey(node.data) && !visited.contains(parentMap.get(node.data))){
                    Q.offer(parentMap.get(node.data));
                }
            }
            k--;
        }

        return Q.stream().map(t->t.data).toList();
    }
}
