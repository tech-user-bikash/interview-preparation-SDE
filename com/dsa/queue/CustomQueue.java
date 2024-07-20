package com.dsa.queue;

import java.util.Arrays;

public class CustomQueue {
    int[] A;
    int SIZE;
    int start;
    int end;
    int curr_size;
    public CustomQueue(int size){
        A = new int[size];
        Arrays.fill(A, -1);
        this.SIZE = size;
        start = -1;
        end = -1;
        curr_size = 0;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Queue is full !! No more push allowed.");
            System.exit(-1);
            return;
        }
        // first time insert
//        if(start == -1 && end == -1){
        if(curr_size == 0){
            start = 0;
            end = 0;
        } else {
            end = (end+1) % SIZE;
        }
        A[end] = data;
        curr_size++;
    }

    public int peek(){
        if(isQueueEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return A[start];
    }

    private boolean isQueueEmpty() {
//        return start == -1 && end == -1;
        return curr_size == 0;
    }

    public int poll(){
        if(isQueueEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int deleted_data = A[start];
        A[start] = -1;
        curr_size--;
        start = (start+1) % SIZE;
        return deleted_data;
    }

    private boolean isFull() {
//        return start == 0 && end == SIZE - 1;
        return curr_size == SIZE;
    }

    public void display(int[] A){
        System.out.println(Arrays.toString(A));
    }
    public static void main(String[] args) {
        CustomQueue Q = new CustomQueue(5);
        Q.push(2);
        Q.push(3);
        Q.push(4);
        Q.push(6);

        Q.display(Q.A);

        Q.poll();
        Q.poll();
        Q.push(10);
        Q.push(11);
        Q.push(12);
        Q.push(14);
        Q.display(Q.A);
    }
}
