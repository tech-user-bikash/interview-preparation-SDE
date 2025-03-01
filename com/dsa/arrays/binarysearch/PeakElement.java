package com.dsa.arrays.binarysearch;

import java.util.ArrayList;

public class PeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        var ans= findPeakElement(list);
        System.out.println(ans);
    }

    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        int low = 1;
        int high = n-2;

        // check for boundary condition.
        // always arr[-1] & arr[n] considered as -infinity.
        // Hence, only comparison is required for 1st and n-2th index.
        if(arr.get(0) > arr.get(1)){
            return arr.get(0);
        }
        if(arr.get(n-1) > arr.get(n-2)){
            return arr.get(n-1);
        }

        while(low <= high){
            int mid= (low+high)/2;

            // check if current is peak element
            // current element should be greater than both left and right
            if(arr.get(mid) > arr.get(mid-1) && arr.get(mid) > arr.get(mid+1)){
                return mid;
            }

            // check if decreasing or increasing side of peak
            // increasing order of peak
            if(arr.get(mid) > arr.get(mid-1)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
