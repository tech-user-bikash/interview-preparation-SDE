package com.dsa.tree;

import java.util.*;

// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/submissions/1447201422/
// https://www.youtube.com/watch?v=-Qs1T_xfzLo&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E
public class BurnBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
//        root.left = new TreeNode(5);
//        root.left.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(9);
//        root.left.right.right = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(6);

        BurnBT burn = new BurnBT();
        int ans = burn.amountOfTime(root,2);
        System.out.println(ans);
    }

    TreeNode startAddress = null;
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;

        // Optimize Code with height calculation
        getMinTimeToBurn(root, start);
        System.out.println(maxi);

        // Parent wise calculation
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        createParentAndGetStartNodeAddress(root,  start, parentMap);
        System.out.println(startAddress);
        System.out.println(parentMap);
        int ans = findMinTime(parentMap, startAddress);
        return ans;
    }

    /**
     * 1. From Root, calculate Left & right height.
     * 2. To know which side of Root start is present, return -1 to root.
     * 3. keep on increase the distance till reach root from start.
     *      get min(left, right) - 1. always be -ve. hence  -ve - 1 = increase the distance
     * 4. other side of root, start should not present, hence return height of that side.
     */
    int maxi = Integer.MAX_VALUE;
    private int getMinTimeToBurn(TreeNode root, int start) {
        if(root == null) return 0;

        int leftHeight = getMinTimeToBurn(root.left, start);
        int rightHeight = getMinTimeToBurn(root.right, start);

        // case-1: if found start, return -1 to root and calculate the max height from it's left & right
        if(root.data == start){
            maxi = Math.max(leftHeight,rightHeight);
            // indicator to parent. this is start node.
            return -1;
        }
        // case-2: start not found, return max height
        else if(leftHeight >= 0 && rightHeight >=0){
            return 1 + Math.max(leftHeight,rightHeight);
        }
        // case-3: from start when coming back to root, get the height from start to root.
        else {
            // calculate
            int distance = Math.abs(leftHeight) + Math.abs(rightHeight);
            maxi=Math.max(maxi, distance);
            // returning to root with increased distance.
            // -1-1 = -2
            return Math.min(leftHeight, rightHeight) - 1;
        }

    }

    private void createParentAndGetStartNodeAddress(
            TreeNode root,
            int start,
            Map<Integer, TreeNode> parentMap){

        if (root == null) return;

        if(root.data == start){
            startAddress = root;
        }

        if(root.left != null){
            parentMap.put(root.left.data, root);
        }
        createParentAndGetStartNodeAddress(root.left, start, parentMap);
        if(root.right != null){
            parentMap.put(root.right.data, root);
        }
        createParentAndGetStartNodeAddress(root.right, start, parentMap);
    }

    private int findMinTime(Map<Integer, TreeNode> parentMap, TreeNode target){
        if(target == null){
            return 0;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(target);

        Set<Integer> visitedSet = new HashSet<>();
        visitedSet.add(target.data);

        int time = 0;

        while(!Q.isEmpty()){
            int size = Q.size();
            boolean isAnySingleNodeBurnt = false;

            for(int i = 0; i<size; i++){
                TreeNode node = Q.poll();

                //left
                if(node.left != null && !visitedSet.contains(node.left.data)){
                    Q.offer(node.left);
                    visitedSet.add(node.left.data);
                    isAnySingleNodeBurnt = true;
                }
                //right
                if(node.right != null && !visitedSet.contains(node.right.data)){
                    Q.offer(node.right);
                    visitedSet.add(node.right.data);
                    isAnySingleNodeBurnt = true;
                }
                // parent
                TreeNode parentNode = parentMap.get(node.data);
                if(parentNode != null && !visitedSet.contains(parentNode.data)){
                    Q.offer(parentNode);
                    visitedSet.add(parentNode.data);
                    isAnySingleNodeBurnt = true;
                }

            }
            if (isAnySingleNodeBurnt) {
                time++;
            }
        }
        return time;
    }
}
