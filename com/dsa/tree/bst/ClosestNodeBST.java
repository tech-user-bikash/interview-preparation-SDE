package com.dsa.tree.bst;

import com.dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/
public class ClosestNodeBST {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        // List<List<Integer>> ans = new ArrayList<>();
        // for(int Q : queries){
        //     List<Integer> qList = new ArrayList<>();
        //     // // get min val
        //     // int minVal = getMinVal(root, Q);
        //     // // get max val
        //     // int maxVal = getMaxVal(root, Q);
        //     // qList.add(minVal);
        //     // qList.add(maxVal);

        //     int[] arr=getFlor(root,Q);
        //     qList.add(arr[0]);
        //     qList.add(arr[1]);
        //     ans.add(qList);
        // }
        // return ans;


        List<List<Integer>> send = new ArrayList<>();
        TreeNode backup = root;
        for (int q : queries) {
            root = backup;
            List<Integer> lls = new ArrayList<>();
            int max = -1, min = -1;
            while (root != null) {
                if (root.data == q) {
                    min = q;
                    max = q;
                    break;
                } else if (root.data > q) { // changing the max until we get the root value equal to queries value if root value does not exist it will result in closest bigger value to queries value
                    max = root.data;
                    root = root.left;
                } else {   // changing the min until we get the root value equal to queries value if root value does not exist it will result in closest smaller value to queries value
                    min = root.data;
                    root = root.right;
                }
            }
            lls.add(min);
            lls.add(max);
            send.add(new ArrayList<>(lls));
        }
        return send;
    }

    public int[] getFlor(TreeNode root, int v) {
        int[] arr = new int[2];
        Arrays.fill(arr, -1);
        while (root != null) {
            if (root.data == v) {
                arr[0] = root.data;
                arr[1] = root.data;
                return arr;
            }
            if (v > root.data) {
                arr[0] = root.data;
                root = root.right;
            } else {
                arr[1] = root.data;
                root = root.left;
            }
        }
        return arr;
    }

    private int getMinVal(TreeNode root, int val) {
        int minVal = -1;
        while (root != null) {
            if (root.data == val) {
                minVal = val;
                return minVal;
            }

            if (root.data > val) {
                root = root.left;
            } else {
                minVal = root.data;
                root = root.right;
            }
        }
        return minVal;
    }

    private int getMaxVal(TreeNode root, int val) {
        int maxVal = -1;
        while (root != null) {
            if (root.data == val) {
                maxVal = val;
                return maxVal;
            }

            if (root.data < val) {
                root = root.right;
            } else {
                maxVal = root.data;
                root = root.left;
            }
        }
        return maxVal;
    }
}
