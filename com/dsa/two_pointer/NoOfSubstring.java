package com.dsa.two_pointer;

public class NoOfSubstring {
    public static void main(String[] args) {
        String S = "abccba";
        var ans = numberOfSubstrings(S);
        System.out.println(ans);
    }
    public static int numberOfSubstrings(String s) {
        int[] lastSeen = {-1,-1,-1};
        int n = s.length(), count = 0;

        for(int i = 0; i<n; i++) {
            var idx = s.charAt(i) - 'a';
            lastSeen[idx] = i;
            count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]),
                    Math.min(lastSeen[1], lastSeen[2]));
        }
        return count;
    }
}
