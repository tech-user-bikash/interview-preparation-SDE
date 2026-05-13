package com.dsa.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NGECircular {
    public static void main(String[] args) {
        int[] A = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        var ans = nextGreaterElements(A);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int max = arr[n-1];
        int lastEle = max;
        // st.push(max);
        for(int i = n-1; i>=0; i--){
            if(arr[i] > max) max = arr[i];
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                arr[i] = -1;
            } else {
                arr[i] = st.peek();
            }
            st.push(arr[i]);
        }
        if(max == lastEle){
            arr[n-1] = -1;
        } else {
            arr[n-1] = max;
        }
        return arr;
    }
}
