package com.dsa.stack;

import java.util.Arrays;

public class StackMainClass {
    public static void main(String[] args) {
        StackOperations stOps = new StackOperations();
//        var isBalanced = stOps.isBalanced("]()");
//        System.out.println(isBalanced);

//        int[] A = {2,10,12,1,11};
//        int[] nextGreaterEleArr = stOps.findNextGreaterElement(A, false);
//        System.out.println(Arrays.toString(nextGreaterEleArr));

        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(3, 15);
        cache.put(2, 12);
        cache.deque.forEach(e->{
            System.out.print("{"+e.key+":"+e.value+"}");
        });
        System.out.println();
        System.out.println(cache.get(3));

        cache.deque.forEach(e->{
            System.out.print("{"+e.key+":"+e.value+"}");
        });
        System.out.println();
        cache.put(4, 20);
        cache.deque.forEach(e->{
            System.out.print("{"+e.key+":"+e.value+"}");
        });

        System.out.println();
        System.out.println(cache.get(2));
        cache.deque.forEach(e->{
            System.out.print("{"+e.key+":"+e.value+"}");
        });
        System.out.println();

        cache.put(4, 200);
        cache.deque.forEach(e->{
            System.out.print("{"+e.key+":"+e.value+"}");
        });
    }
}
