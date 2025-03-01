package com.dsa.two_pointer;

// Longest SubArray Sum at Most K
public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1, -8, -9, 0};
        int k = 4;
        int ans = countSubArray(arr, k);
        System.out.println(ans);
    }

    private static int countSubArray(int[] arr, int k) {
        int sum = arr[0];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < arr.length) {
            sum = sum + arr[right];
            if (left <= right && sum > k) {
                sum = sum - arr[left];
                left++;
            }
            if (sum <= k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }
            right++;
        }
        return maxLen;
    }
}
