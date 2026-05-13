package com.dsa.binarysearch;

import java.util.Arrays;

public class AggressiveCowTest {
    public static void main(String[] args) {
        AggressiveCowTest cow = new AggressiveCowTest();
        int[] A = {0, 3, 4, 7, 10, 9};
        int K = 4;
        var ans = cow.aggressiveCows(A, K);
        System.out.println(ans);
    }

    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 1, high = nums[n - 1] - nums[0];
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlaceCow(nums, mid, k)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean canWePlaceCow(int[] A, int distance, int totalCow) {
        int countCount = 1;
        // will update the last place towards end
        int lastPosition = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] - lastPosition >= distance) {
                countCount++;
                lastPosition = A[i];
            }
            if (countCount >= totalCow) {
                return true;
            }
        }
        return false;
    }
}
