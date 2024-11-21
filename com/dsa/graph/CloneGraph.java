package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/clone-graph/solutions/1793436/java-simple-code-with-heavy-comments/?envType=problem-list-v2&envId=graph
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {

    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node[] visited = new Node[101];
        return DFS(node, visited);
    }

    private Node DFS(Node node, Node[] visited){
        if(visited[node.val] != null){
            return visited[node.val];
        }
        visited[node.val] = new Node(node.val);
        for(Node n : node.neighbors){
            visited[node.val].neighbors.add(DFS(n, visited));
        }
        return visited[node.val];
    }
}
