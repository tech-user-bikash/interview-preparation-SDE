package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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

        levelOrderTraversal(root);
    }

    // TC: O(N), SC: O(N)
    private static void levelOrderTraversal(TreeNode node) {
        if(node == null){
            System.out.println("No node found to traverse");
            return;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(node);
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i = 0; i<size; i++){
                TreeNode treeNode = Q.poll();
                assert treeNode != null;
                System.out.print(treeNode.data+" ");
                if(treeNode.left != null) Q.add(treeNode.left);
                if(treeNode.right != null) Q.add(treeNode.right);
            }
            System.out.println();
        }

    }
}
