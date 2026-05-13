package com.dsa.binarysearch;

import java.util.Arrays;

public class MedianTest {
    public static void main(String[] args) {
        int[] A2 = {-988}, A1 = {-249,-131,839};
        System.out.println(median(A1, A2));
    }
    public static double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int a1_Idx = 0, a2_Idx = 0;
        int[] arr3 = new int[n1+n2];
        int a3_idx = 0;
        while(a1_Idx < n1 && a2_Idx < n2){
            if(arr1[a1_Idx] <= arr2[a2_Idx]){
                arr3[a3_idx++] = arr1[a1_Idx++];
            } else {
                arr3[a3_idx++] = arr2[a2_Idx++];
            }
        }
        // check if any one is left
        if(a1_Idx < n1){
            arr3[a3_idx++] = arr1[a1_Idx++];
        }
        if(a2_Idx < n2){
            arr3[a3_idx++] = arr2[a2_Idx++];
        }
        System.out.print(Arrays.toString(arr3));
        int n = n1+n2;
        // if odd
        if(n % 2 == 1) {
            return (double)arr3[n/2];
        }

        return (double)(((double) arr3[n/2] + (double)arr3[n/2-1]) / 2.0);
    }
}
