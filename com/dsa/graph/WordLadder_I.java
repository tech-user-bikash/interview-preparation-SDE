package com.dsa.graph;

import java.util.*;
// https://www.geeksforgeeks.org/problems/word-ladder/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=word-ladder
// https://www.youtube.com/watch?v=tRPda0rcf8E&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=31
public class WordLadder_I {
    static class Pair {
        String word;
        int seq;

        Pair(String _word, int _seq) {
            this.word = _word;
            this.seq = _seq;
        }
    }

    public static void main(String[] args) {
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord = "der", targetWord= "dfs";
        WordLadder_I wordLadder = new WordLadder_I();
        var ans = wordLadder.wordLadderLength(startWord, targetWord, wordList);
        System.out.println(ans);
    }

    // TC : (N(until find the target word it will push and traverse the Q) * word.length * 26 * logN -- for hashSet)
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> Q = new LinkedList<>();
        // add source word with it's seq as 1
        Q.add(new Pair(startWord, 1));
        Set<String> set = new HashSet<>(Arrays.asList(wordList));


        // after adding to Q, remove from Set
        set.remove(startWord);

        while (!Q.isEmpty()) {
            Pair p = Q.poll();
            String word = p.word;
            int seq = p.seq;

            // if endWord encounter then return the seq
            if (word.equals(targetWord)) return seq;

            // traverse till word len and replace the char one by one
            for (int i = 0; i < word.length(); i++) {
                char[] wordArr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArr[i] = ch;
                    String replacedWord = String.valueOf(wordArr);
                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        Q.add(new Pair(replacedWord, seq + 1));
                    }
                }

            }
        }
        return 0;
    }
}
