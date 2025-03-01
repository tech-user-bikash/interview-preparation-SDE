package com.dsa.two_pointer;

public class MaxSumOfSizeK {
    public static void main(String[] args) {
        int[] A = {-1,2,3,4,5,-2}; int K = 4;

        int ans = findMaxSum(A, K);
        System.out.println(ans);
    }

    private static int findMaxSum(int[] A, int K) {
        int maxSum;
        int left = 0, right = K - 1, N = A.length;
        int sum = 0;
        for(int i=left; i<=right; i++ ){
            sum+=A[i];
        }
        maxSum = sum;
        while(right < N-1){
            sum-= A[left++];
            sum+= A[++right];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
