package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 2};
        var ans = totalFruits(A);
        System.out.println(ans);
    }

    public static int totalFruits(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            // check map contains within 2 elements
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
            else if (left < fruits.length) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }
        }
        return maxLen;
    }

}
