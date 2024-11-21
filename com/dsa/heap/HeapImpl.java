package com.dsa.heap;

public class HeapImpl {
    public final int[] arr;
    private int SIZE;

    public HeapImpl(int size) {
        this.arr = new int[size];
    }

    public int getMax(int[] A) {
        return A[0];
    }

    // TC: O(log N) - always one side is required to compare for the tree
    public void insert(int val) {
        // add into array's last index
        arr[SIZE] = val;
        // assign a temp variable with last inserted index
        int index = SIZE;
        // get the parent of last index
        int parent = (index - 1) / 2;

        // traverse all the node and check heap property, if current value is greater than parent the swap
        while (parent >= 0 && arr[parent] < arr[index]) {
            // swap parent and current index node
            int temp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = temp;

            // check currently swapped value, and it's parent if heap property maintained
            index = parent;
            parent = (parent - 1) / 2;
        }
        SIZE++;
    }


    // TC: O(log N)
    public void removeMax(int[] A){
        // get the max value from top
        int maxValue = A[0];
        this.SIZE = A.length;
        // replace the last node with top
        A[0] = A[SIZE - 1];
        // reduce size
        SIZE--;
        // maintain the heap property from root
        maxHeapify(0, A);
    }

    // TC: O(log N)
    private void maxHeapify(int index, int[] A) {
        // calculate left & right index
        int left_idx = 2*index + 1;
        int right_idx = 2*index + 2;

        // get the largest value index
        int large_idx = index;
        // check left & right node if greater than root node
        if(left_idx < A.length && A[left_idx] > A[large_idx]){
            large_idx = left_idx;
        }
        if(right_idx < A.length && A[right_idx] > A[large_idx]){
            large_idx = right_idx;
        }
        // if large index value changed, then greater value is present compared to root
        if(large_idx != index){
            // swap
            int temp = A[large_idx];
            A[large_idx] = A[index];
            A[index] = temp;
            // recursively check if tree is maintaining the heap property
            maxHeapify(large_idx, A);
        }
    }

    public int[] buildMaxHeap(int[] arr){
        int N = arr.length;
        for(int i = N/2-1; i>=0; i--){
            maxHeapify(i, arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        HeapImpl heap = new HeapImpl(20);
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};

        var ans = heap.buildMaxHeap(arr);
        System.out.println(heap.getMax(ans));

        heap.removeMax(ans);

        System.out.println(heap.getMax(ans));

//        heap.insert(arr[0]);
//        heap.insert(arr[1]);
//        heap.insert(arr[2]);
//        System.out.println(heap.getMax());
//
//        heap.insert(arr[3]);
//        heap.insert(arr[4]);
//        heap.insert(arr[5]);
//        heap.insert(arr[6]);
//        heap.insert(arr[7]);
//        System.out.println(heap.getMax());
    }

}
