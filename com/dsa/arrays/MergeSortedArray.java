package com.dsa.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] A1 = {-5,-2,4,5};
        int[] A2 = {-3,1,8};
        merge(A1, A1.length, A2, A2.length);
        System.out.println(Arrays.toString(A1));
        System.out.println(Arrays.toString(A2));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1, right = 0;

        while(left >= 0 && right <= n){
            if(nums1[left] > nums2[right]){
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}
