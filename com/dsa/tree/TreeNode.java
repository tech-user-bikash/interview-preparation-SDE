package com.dsa.tree;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int _data){
        this.data = _data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
