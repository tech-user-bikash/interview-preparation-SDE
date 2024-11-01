package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
//        String[] dict = {"dhhid", "dahi", "cedg", "fg", "gdah", "i", "gbdei", "hbgf", "e", "ddde"};
        var dict = new String[]{"baa", "abcd", "abca", "cab", "cad" };
        AlienDictionary dictionary = new AlienDictionary();
        var ans = dictionary.findOrder(dict,dict.length, dict.length-1);
        System.out.println(ans);
    }
    public String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }

        // traverse all the string and compare
        for(int i = 0; i<n-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            // calculate the min length between string strings and compare
            int minLen = Math.min(s1.length(), s2.length());
            for(int j = 0; j<minLen; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    // create edge between s1 and s2 char
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topoList = topoSort(k, adj);
        // if cycle is there, return empty string
         if(topoList.size() != k) return "";

        StringBuilder ans = new StringBuilder();
        for(int i : topoList){
            ans.append((char) (i + (int) 'a'));
        }
        return ans.toString();
    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj){
        List<Integer> topoList = new ArrayList<>();
        int[] inDegree = new int[V];
        // calculate in-degree for each node
        for(int i = 0; i<V; i++){
            // visit neighbours
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        // insert 0 in-degree into Q
        for(int i=0; i<V; i++){
            if(inDegree[i]==0){
                Q.add(i);
            }
        }

        // traverse the Q until it will be empty
        while(!Q.isEmpty()){
            int node = Q.poll();
            topoList.add(node);

            // visit neighbours
            for(int it : adj.get(node)){
                // reduce the in-degree value
                inDegree[it]--;
                if(inDegree[it] == 0){
                    Q.add(it);
                }
            }
        }
        return topoList;
    }
}
