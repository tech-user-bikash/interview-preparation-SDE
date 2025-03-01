package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] A = {2,32,4,2,54,3,-1};
        var ans = leaders(A);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] leaders(int[] nums) {
        int N = nums.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[N-1]);
        int max = nums[N-1];
        for(int i = N-2; i>=0; i--){
            if(nums[i] > max){
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(a->a).toArray();
    }

}
