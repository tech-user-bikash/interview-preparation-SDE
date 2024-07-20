package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> Q = new LinkedList<>();

    public void push(int data){
        Q.add(data);
        for(int i = 0; i<Q.size()-1; i++){
            Q.add(Q.poll());
        }
    }

    public void pop(){
        Q.poll();
    }

    private void display() {
        if(Q.isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        Q.forEach(e->System.out.print(e+" "));
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingQueue st = new StackUsingQueue();
        st.push(8);
        st.push(5);
        st.push(15);
        st.push(25);
        st.push(35);
        st.push(55);

        st.display();


    }


}
