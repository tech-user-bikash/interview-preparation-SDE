package com.dsa.stack;

public class StackUsingLL {
    Node top = null;
    int size;
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
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
        st.push(3);
        st.push(2);
        st.push(7);
        st.display(st.top);
        st.pop();
        st.pop();
//        st.pop();
        st.display(st.top);
//        System.out.println(st.top.data);
    }


}
