package com.dsa.linkedlist.singly;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> random;
    Node<T> child;

    // default constructor
    Node(){}
    Node(T data){
        this.data = data;
        this.next = null;
        this.random = null;
        this.child = null;
    }

}
