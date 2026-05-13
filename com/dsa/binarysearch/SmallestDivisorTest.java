package com.dsa.binarysearch;

public class SmallestDivisorTest {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        var ans = smallestDivisor(A, 8);
        System.out.println(ans);

    }
    public static int smallestDivisor(int[] nums, int limit) {
        if (nums.length > limit) return -1;

        // get max value from array
        int maxValue = Integer.MIN_VALUE;
        for (int i : nums) {
            maxValue = Math.max(maxValue, i);
        }

        int low = 1, high = maxValue, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (getSum(mid, nums) <= limit) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low +" -- "+high);
        return ans;
    }

    private static int getSum(int mid, int[] A) {
        int sum = 0;
        for (int n : A) {
            // sum+= Math.ceil((double)n/mid);
            sum += Math.ceil((double) n / (double) mid);
        }
        return sum;
    }
}
