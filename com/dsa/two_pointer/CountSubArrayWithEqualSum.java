package com.dsa.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithEqualSum {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//to deal with the cases where x-k==0

        for (int i = 0; i < n; i++) {
            presum += nums[i];

            int remove = presum - k;//as we will remove upto this sum to find our desired subarray
            //look for occurence times of this remove as no(x-k)==no(k) right,which we are searching for
            count += map.getOrDefault(remove, 0);//0 as if remove not found let it be 0
            //frequency of presum to look for x-k
            map.put(presum, map.getOrDefault(presum, 0) + 1);


        }

        return count;

    }

    public int subArraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
                if (sum > k) {
                    break;
                }
            }
        }
        return count;
    }


}
