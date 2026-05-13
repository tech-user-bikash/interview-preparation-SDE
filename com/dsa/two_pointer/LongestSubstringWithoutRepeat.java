package com.dsa.two_pointer;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        var ans = longestNonRepeatingSubstring("abcddabac");
        System.out.println(ans);
    }
    public static int longestNonRepeatingSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();

        int res = 0;
        boolean[] vis = new boolean[26];

        // left and right pointer of sliding window0
        int left = 0, right = 0;
        while (right < s.length()) {

            // If character is repeated, move left pointer marking
            // visited characters as false until the repeating
            // character is no longer part of the current window
            var charIdx = s.charAt(right) - 'a';
            while (vis[charIdx]) {
                vis[s.charAt(left) - 'a'] = false;
                left++;
            }

            vis[charIdx] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly.
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }
}
