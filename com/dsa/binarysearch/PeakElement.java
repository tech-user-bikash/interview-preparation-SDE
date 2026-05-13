package com.dsa.binarysearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] A = {-2, -1, 3, 4, 5};
        System.out.println(findPeakElement(A));
    }
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n == 1 || arr[0] > arr[1]) return 1;
        if(arr[n-1] > arr[n-2]) return 1;
        for(int i = 1; i<n-1; i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                return 1;
            }
        }
        return 0;
    }
}
