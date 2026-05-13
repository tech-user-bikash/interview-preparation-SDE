package com.dsa.binarysearch;

public class ShipCapacityTest {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        var ans = shipWithinDays(A, days);
        System.out.println(ans);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE, totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int low = maxWeight, high = totalWeight, ans = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            int totalDays = getDays(weights, mid);
            if (totalDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int getDays(int[] A, int capacity) {
        int dayCnt = 0, totalLoad = 0;
        for (int w : A) {
            totalLoad += w;
            if (totalLoad > capacity) {
                dayCnt++;
                totalLoad = 0;
            }
        }
        return dayCnt;
    }
}
