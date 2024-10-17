package com.dsa.stack;

public class StackMainClass {
    public static void main(String[] args) {
        StackOperations stOps = new StackOperations();
//        var isBalanced = stOps.isBalanced("]()");
//        System.out.println(isBalanced);

//        int[] A = {2,10,12,1,11};
//        int[] nextGreaterEleArr = stOps.findNextGreaterElement(A, false);
//        System.out.println(Arrays.toString(nextGreaterEleArr));

//        LRUCache cache = new LRUCache(3);
//        cache.put(1, 10);
//        cache.put(3, 15);
//        cache.put(2, 12);
//        cache.deque.forEach(e->{
//            System.out.print("{"+e.key+":"+e.value+"}");
//        });
//        System.out.println();
//        System.out.println(cache.get(3));
//
//        cache.deque.forEach(e->{
//            System.out.print("{"+e.key+":"+e.value+"}");
//        });
//        System.out.println();
//        cache.put(4, 20);
//        cache.deque.forEach(e->{
//            System.out.print("{"+e.key+":"+e.value+"}");
//        });
//
//        System.out.println();
//        System.out.println(cache.get(2));
//        cache.deque.forEach(e->{
//            System.out.print("{"+e.key+":"+e.value+"}");
//        });
//        System.out.println();
//
//        cache.put(4, 200);
//        cache.deque.forEach(e->{
//            System.out.print("{"+e.key+":"+e.value+"}");
//        });

        // TODO: need to re-explore
//        LFUCache cache = new LFUCache(3);
//        cache.putItem(1, 15);
//        cache.putItem(2, 25);
//        cache.putItem(3, 35);
//
//        cache.cacheMap.forEach((k,v)->{
//            System.out.println(v);
//        });
//
//        System.out.println(cache.getItem(2).key);
//
//        cache.cacheMap.forEach((k,v)->{
//            System.out.println(v);
//        });

        // Histogram area
        // A[i] * width(RightSmall - LeftSmall + 1)
//        int[] A = {2, 1, 5, 6, 2, 3, 1};
//        int[] A = {3, 1, 5, 6, 2, 3};
        // it is for 2 pass
//        int maxArea = stOps.getLargestAreaOfHistogram(A);
//        System.out.println(maxArea);
        // optimal with one pass
//        int optimalMaxArea = stOps.getLargestAreaOfHistogramUsingOnePass(A);
//        System.out.println(optimalMaxArea);


        // maximum sum of k size sub-array
//        int[] A = {1, 4, 2, 10, 2, 3, 1, 0, 20};
//        int max = stOps.maxSumKSizeWindow(A, 4);
//        System.out.println(max);

        // find maximum of each sub array of size K window
        // https://leetcode.com/problems/sliding-window-maximum/
        // https://www.youtube.com/watch?v=CZQGRp93K4k&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=13
//        int[] maxArr = stOps.maxSlidingWindow(A, 3);
//        System.out.println(Arrays.toString(maxArr));


        // Trapping Rain Water
        // https://www.youtube.com/watch?v=1_5VuquLbXg&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=8
        /**
         * Sum(1-N)-->Min(leftMax, rightMax) - A[i]
         */
        int[] A = {2,1,0,5,3};
//        int ans = stOps.findTotalWaterConsumption(A);
        // we may need Min(rightMax or leftMax), no need both of them at same time.
        // need to traverse from both direction as we don't know both for single iteration
        int ans = stOps.findTotalWaterConsumptionOptimization(A);
        System.out.println(ans);
    }



}
