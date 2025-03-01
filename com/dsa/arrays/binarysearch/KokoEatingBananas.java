package com.dsa.arrays.binarysearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] A = {7, 15, 6, 3};
        int h = 8;
        System.out.println(minimumRateToEatBananas(A, h));
    }

    public static int minimumRateToEatBananas(int []v, int h) {
        int N = v.length;
        // get max element from array
        int maxValue = Integer.MIN_VALUE;
        for(int i : v){
            maxValue = Math.max(maxValue, i);
        }

        int low = 1, high = maxValue;

        while(low <= high){
            int mid = (low+high)/2;
            int totalHours = getTotalHours(mid, v);
            if(totalHours <= h){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    private static int getTotalHours(int hourly, int[] v){
        int totalHours = 0;
        for(int i : v){
            totalHours+= Math.ceil((double)i/(double)hourly);
        }
        return totalHours;
    }
}
