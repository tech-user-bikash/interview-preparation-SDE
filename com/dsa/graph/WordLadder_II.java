package com.dsa.graph;

import java.util.*;

public class WordLadder_II {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        Queue<ArrayList<String>> Q = new LinkedList<>();
        // add startword into Q
        ArrayList<String> list = new ArrayList<>();
        list.add(startWord);
        Q.add(list);

        // level wise word put into list
        ArrayList<String> usedLevleList = new ArrayList<>();
        usedLevleList.add(startWord);
        int level = 0;

        ArrayList<ArrayList<String>> ansList = new ArrayList<>();

        while (!Q.isEmpty()) {
            ArrayList<String> popedList = Q.poll();
            // erase all words that has been used in last level transformation
            if (popedList.size() > level) {
                level++;
                popedList.forEach(set::remove);
            }
            // pick the last word from the list
            String word = popedList.get(popedList.size() - 1);
            if (word.equals(targetWord)) {
                // first time
                if (ansList.isEmpty()) {
                    ansList.add(popedList);
                } else if (ansList.get(0).size() == popedList.size()) {
                    ansList.add(popedList);
                }
            }

            // traverse till word len and replace the char one by one
            for (int i = 0; i < word.length(); i++) {
                char[] wordArr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArr[i] = ch;
                    String replacedWord = String.valueOf(wordArr);
                    if (set.contains(replacedWord)) {
                        popedList.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(popedList);
                        Q.add(temp);
                        usedLevleList.add(replacedWord);
                        popedList.remove(popedList.size() - 1);
                    }
                }

            }
        }
        return ansList;
    }
}
