package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {

    // TC: O(N), SC: O(N)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();

            if (node == null) {
                sb.append("#,");
                continue;
            }
            sb.append(node.data).append(",");
            Q.add(node.left);
            Q.add(node.right);
        }
        return sb.toString();

    }

    // TC: O(N), SC: O(N)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        String[] dataArr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        // len - 1 = last index ignore as it has comma
        for (int i = 1; i < dataArr.length - 1; i++) {
            TreeNode parent = Q.poll();
            assert parent != null;
            if (!dataArr[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(dataArr[i]));
                parent.left = leftNode;
                Q.add(leftNode);
            }
            if (!dataArr[++i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(dataArr[i]));
                parent.right = rightNode;
                Q.add(rightNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeDeserializeBT serializeDeserializeBT = new SerializeDeserializeBT();
        var ans = serializeDeserializeBT.deserialize(serializeDeserializeBT.serialize(root));
        System.out.println(ans);
    }
}
