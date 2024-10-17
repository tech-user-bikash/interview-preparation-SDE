package com.dsa.stack;

import java.util.Stack;

public class StackUsingLL {
    Node top = null;
    int size;

    Stack<Pair> stack = new Stack<>();

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        size++;
    }

    public void pop(){
        if(isStackEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        top = top.next;
    }

    private boolean isStackEmpty() {
        return top == null;
    }

    private void display(Node node) {
        if(node == null){
            System.out.println("Stack is empty");
            return;
        }
        Node temp = node;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLL st = new StackUsingLL();
//        st.push(3);
//        st.push(2);
//        st.push(7);
//        st.display(st.top);
//        st.pop();
//        st.pop();
//        st.pop();
//        st.display(st.top);

        // Design Min Stack
        st.pushPairElement(2);
        st.pushPairElement(8);
        st.pushPairElement(1);
        st.pushPairElement(4);
        st.printPairElements();
        st.getMin();
        st.popPairElement();
        st.printPairElements();
//        System.out.println(st.top.data);
    }

    private void popPairElement() {
        stack.pop();
    }

    private void printPairElements() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty !!");
            return;
        }
        stack.forEach(System.out::println);
    }

    private void pushPairElement(int data) {
        if (stack.isEmpty()) {
            stack.push(new Pair(data, data));
        } else {
            stack.push(new Pair(data, Math.min(data, stack.peek().min)));
        }
    }

    static class Pair {
        int data;
        int min;

        public Pair(int data, int min) {
            this.data = data;
            this.min = min;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "data=" + data +
                    ", min=" + min +
                    '}';
        }
    }

    private void getMin() {
        int min = stack.peek().min;
        System.out.println(min);
    }


}
