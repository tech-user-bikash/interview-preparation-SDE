package com.dsa.tree;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/path-to-given-node/
// https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=28
public class PathFromRootToGivenNode {

    // TC: O(N), SC: O(Height)
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(-30);
        root.right.right = new TreeNode(-15);
        var ans = getPath(root, -15);
        System.out.println(ans);
    }
    public static ArrayList<Integer> getPath(TreeNode A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null) return res;
        getPath(A, B, res);
        return res;
    }

    private static boolean getPath(TreeNode root, int B, ArrayList<Integer> res){
        if(root == null){
            return false;
        }
        res.add(root.data);
        if(root.data == B){
            return true;
        }
        if(getPath(root.left, B, res) || getPath(root.right, B, res)){
            return true;
        }
        res.remove(res.size()-1);
        return false;
    }
}
