package com.dsa.stack;

import java.util.Stack;

public class StackOperations {

    public boolean isBalanced(String parenthesisString) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < parenthesisString.length() - 1; i++) {
            if (parenthesisString.charAt(i) == '['
                    || parenthesisString.charAt(i) == '{'
                    || parenthesisString.charAt(i) == '(') {
                st.push(parenthesisString.charAt(i));
            } else if (parenthesisString.charAt(i) == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            } else if (parenthesisString.charAt(i) == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            } else if (parenthesisString.charAt(i) == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }

    // https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=6
    public int[] findNextGreaterElement(int[] arr, boolean isCircular) {
        int N = arr.length;
        int[] res = new int[N];
        Stack<Integer> st = new Stack<>();
        if (isCircular) {
            for (int i = 0; i < (2 * N) - 1; i++) {
                while (!st.isEmpty() && arr[i % N] >= st.peek()) {
                    st.pop();
                }
                if (i < N) {
                    if (!st.isEmpty()) {
                        res[i] = st.peek();
                    } else {
                        res[i] = -1;
                    }
                }
                st.push(arr[i % N]);
            }
        } else {
            for (int i = N - 1; i >= 0; i--) {
                while (!st.isEmpty() && arr[i] >= st.peek()) {
                    st.pop();
                }
                if (!st.isEmpty()) {
                    res[i] = st.peek();
                } else {
                    res[i] = -1;
                }
                st.push(arr[i]);
            }
        }
        return res;
    }
}
