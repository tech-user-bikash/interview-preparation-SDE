package com.dsa.arrays;

class InversionCount {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};
        InversionCount inversion = new InversionCount();
        var ans = inversion.numberOfInversions(nums);
        System.out.println(ans);
    }
    public int numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] A, int start, int end) {
        int count = 0;
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        count += mergeSort(A, start, mid);
        count += mergeSort(A, mid + 1, end);
        count += merge(A, start, mid, end);
        return count;
    }

    private int merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int idx = 0;
        int count = 0;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                temp[idx++] = A[left++];
            } else {
                temp[idx++] = A[right++];
                count += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[idx++] = A[left++];
        }
        while (right <= end) {
            temp[idx++] = A[right++];
        }

         System.arraycopy(temp, 0, A, start, end - start + 1);
        return count;
    }
}

