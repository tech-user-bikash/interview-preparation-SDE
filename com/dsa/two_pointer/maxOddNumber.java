package com.dsa.two_pointer;

public class maxOddNumber {
    public static void main(String[] args) {
        int[] A = {2,3,3,2,9,2,5};
        int K = 4;
        int n = -81 % 2;
        System.out.println(n);
        var ans = maxOddinKSizeWindow(A, K);
        System.out.println(ans);
    }

    public static int maxOddinKSizeWindow(int[] nums, int k) {
        int oddCount = 0, maxCount = 0;
        int n = nums.length;

        if(n == 0) return 0;
        for(int i = 0; i<k; i++){
            if(nums[i] % 2 == 1){
                oddCount++;
            }
        }
        maxCount = oddCount;

        for(int i = k; i<n; i++){
            // front window element if odd , reduce the count
            if(nums[i-k] % 2 == 1){
                oddCount--;
            }
            if(nums[i] % 2 == 1){
                oddCount++;
            }
            maxCount = Math.max(maxCount, oddCount);
        }
        return maxCount;

    }
}
