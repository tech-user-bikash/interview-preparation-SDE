package com.dsa.tree;

// https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=39
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class FlattenBTLinkedList {

    // Queue<TreeNode> queue = new LinkedList<>();
    // public void addToQueue(TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     queue.add(root);
    //     addToQueue(root.left);
    //     addToQueue(root.right);
    // }
    // public void flatten(TreeNode root) {
    //     addToQueue(root);
    //     while(!queue.isEmpty()){
    //         TreeNode temp = queue.poll();
    //         temp.right = queue.peek();
    //         temp.left = null;
    //     }
    // }

    static TreeNode prev=null;
    // TC: O(N), SC: O(N)
    public static void flatten(TreeNode root) {
        if(root==null)return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        flatten(root);
        System.out.println(root);
    }
}
