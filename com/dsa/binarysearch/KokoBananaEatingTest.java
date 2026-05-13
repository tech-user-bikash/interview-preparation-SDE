package com.dsa.binarysearch;

public class KokoBananaEatingTest {
    public static void main(String[] args) {
        int[] A = {238,838,453,264};
        var ans = minimumRateToEatBananas(A, 8);
        System.out.println(ans);
    }
    public static int minimumRateToEatBananas(int[] nums, int h) {
        int maxi = Integer.MIN_VALUE;
        for(int i : nums){
            maxi = Math.max(maxi, i);
        }

        int low = 1, high = maxi, ans = 1;
        while(low <= high){
            int mid = (low+high)/2;
            var sum = getSum(mid, nums);
            if(sum <= h){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low +" -- "+high);
        return ans;
    }
    private static int getSum(int mid, int[] A){
        int sum = 0;
        for(int i : A){
            sum+= Math.ceil((double)i/(double)mid);
        }
        return sum;
    }
}
