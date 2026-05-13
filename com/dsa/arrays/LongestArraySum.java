package com.dsa.arrays;

public class LongestArraySum {
    public static void main(String[] args) {

        String S = "3443";
        System.out.println(S.charAt(3)-'0');

        int[] A = {10, 5, 2, 7, 1, 9};
        int K = 15;
        var ans = longestSubarray(A, K);
        System.out.println(ans);
    }

    public static int longestSubarray(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;
        int max = 0;
        int sum = nums[i];
        while (j < n) {
            if (sum == k) {
                int len = j - i + 1;
                max = Math.max(max, len);
                i++;
//                j++;
                sum = nums[i];
            }
            while (j < n && sum < k) {
                sum += nums[++j];
//                j++;
            }
            while (i <= j && sum > k) {
                sum -= nums[i];
                i++;
            }
        }
        return max;
    }
}
