package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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
        // Find NGE in forward direction with circular way
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
            // find NGE in backward direction
            // TC: O(N) + O(N)
            for (int i = N - 1; i >= 0; i--) {
                // TC: O(N)
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

    // https://www.youtube.com/watch?v=X0X6G-eWgQ8&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=13
    // TC = N + N , SC = 3N
    // why +1 left small or -1 for right small?
    // Ans: Till the boundary reached, we should consider the just before or after the value. not that boundary
    // because boundary is violating the rule.
    public int getLargestAreaOfHistogram(int[] A) {
        int N = A.length - 1;
        int[] leftSmall = new int[N + 1];
        int[] rightSmall = new int[N + 1];
        // store index of the array
        Stack<Integer> st = new Stack<>();

        // compute left small array
        // O(N)->traversal of array + O(N)->stack
        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;

            st.push(i);
        }
        // make empty to re-use the stack for rightSmall computation
        st.clear();
        System.out.println(Arrays.toString(leftSmall));
        // compute right small array
        // O(N)->traversal of array + O(N)->stack
        for (int i = N; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (st.isEmpty()) rightSmall[i] = N;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }
        System.out.println(Arrays.toString(rightSmall));
        // compute maximum area of histogram
        // O(N)
        int maxA = 0;
        for (int i = 0; i < N; i++) {
            maxA = Math.max(maxA, A[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }

    // https://www.youtube.com/watch?v=jC_cWLy7jSI&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=12
    // TC=O(N)--full iteration + O(N)-> stack operation
    // SC = O(N)

    /**
     * 1. loop through the array
     * 2. if stack is empty, push the index into stack.
     * 3. if not, consider that element as height
     * 4. after removing if anytime stack got empty, consider current index as left small value.
     * 5. if not, after pooping the value from stack, the new top element will be the right small value.
     */
    public int getLargestAreaOfHistogramUsingOnePass(int[] A) {
        int maxA = 0;
        int N = A.length;
        Stack<Integer> st = new Stack<>();
        // <=N for i = N is referred to do an iteration for remaining elements in stack.
        for(int i = 0; i<=N; i++) {
            while(!st.isEmpty() && (i == N || A[st.peek()] >= A[i])){
                int height = A[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                } else {
                    // after popped out the new top element will be the right small index.
                    width = i - st.peek() - 1;
                }
                maxA = Math.max(maxA,(height * width));
            }
            st.push(i);
        }
        return maxA;
    }

    // TC = O(N)
    public int maxSumKSizeWindow(int[] nums, int k) {
        int currSum = 0;
        int N = nums.length;
        int max = Integer.MIN_VALUE;
        int counter = 0;
        // calculate sum for first K elements
        for(int i = 0; i<k; i++) {
            currSum += nums[i];
        }

        // traverse remaining elements
        // for each iteration remove first element from sum and add last element
        // which is newly added into the window.
        for(int i = k; i<N; i++) {
            // i - k will give start element of window
            currSum += nums[i] - nums[i-k];
            max = Math.max(max, currSum);
        }
        return max;
    }

    // TC : O(N), SC : O(K)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] maxArr = new int[N-k+1];
        Deque<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            // remove numbers out of range k
            while(!Q.isEmpty() && Q.peek() == i - k) {
                Q.poll();
            }
            // compare from last and check if incoming element is greater than existing Queue's last element
            // remove if yes.
            while(!Q.isEmpty() && nums[i] > nums[Q.peekLast()]){
                Q.pollLast();
            }

            // add the current element into Queue
            Q.offer(i);

            // from (K-1)th elements onwards we need to calculate max of each subarray and store in maxArr
            if(i >= k - 1){
                maxArr[i-k+1] = nums[Q.peek()];
            }
        }
        return maxArr;
    }

    // TC: O(N+N+N) ~ O(3N), SC: O(2N)
    public int findTotalWaterConsumption(int[] A) {
        int N = A.length;

        // calculate prefix left max array
        int[] pfLeftMax = new int[N];
        pfLeftMax[0] = A[0];
        for(int i = 1; i<N; i++){
            pfLeftMax[i] = Math.max(pfLeftMax[i-1], pfLeftMax[i]);
        }

        // calculate prefix right max array
        int[] pfRightMax = new int[N];
        pfRightMax[N-1] = A[N-1];
        for(int i = N-2; i>=0; i--){
            pfRightMax[i] = Math.max(pfRightMax[i+1], pfRightMax[i]);
        }

        int totalWater = 0;
        // calculate total water is trapped between two building
        for(int i = 0; i<N; i++){
            // current element should be smaller than both sides of building, then exclude the current element from
            // answer as it occupied some space.
            if(A[i] < pfLeftMax[i] && A[i] < pfRightMax[i]){
                totalWater+=Math.min(pfLeftMax[i], pfRightMax[i]) - A[i];
            }
        }
        return totalWater;
    }

    // TC: O(N), SC:O(1)
    public int findTotalWaterConsumptionOptimization(int[] A) {
        int N = A.length;
        int left = 0, right = N-1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while(left < right){
            // deal with smaller one
            if(A[left] <= A[right]) {
                // current element should be smaller than leftMax, then total will calculate
                // else update the leftMax value
                if(A[left] < leftMax){
                    totalWater+= leftMax - A[left];
                } else {
                    leftMax = A[left];
                }
                left++;
            }
            // deal with bigger one
            else {
                if(A[right] < rightMax){
                    totalWater+= rightMax - A[right];
                } else {
                    rightMax = A[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
