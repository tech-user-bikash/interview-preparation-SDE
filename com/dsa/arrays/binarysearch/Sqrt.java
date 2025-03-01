package com.dsa.arrays.binarysearch;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrtN(24));
    }

    public static int sqrtN(long N) {
        // if(N == 1) return 1;
        long low = 1;
        long high = N;
        // keep track of ans till find the exact ans
        // int ans = 1;

        while(low <= high){
            long mid = (high+low)/2;
            // check the ans & eliminate the left half
            if(mid * mid <= N){
                // ans = (int)mid;
                low = mid+1;
            } else {
                high = mid-1;
            }

        }
        // return ans;
        return (int)high;
    }
}
