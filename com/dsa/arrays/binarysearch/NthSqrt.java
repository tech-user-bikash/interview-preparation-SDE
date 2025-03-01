package com.dsa.arrays.binarysearch;

public class NthSqrt {
    public static void main(String[] args) {
        System.out.println(NthRoot(9, 1953125));
    }

    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midProd = func(mid, n, m);

            if (midProd == 0) {
                return mid;
            } else if (midProd == m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int func(int mid, int n, int m) {
        int prod = 1;
        for(int i = 1;  i<=n; i++){
            prod *=mid;
            if(prod > m){
                return 2;
            }
        }

        if(prod == m) return 0;

        return 1;
    }
}
