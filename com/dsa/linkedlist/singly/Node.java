package com.dsa.linkedlist.singly;

public class Node<T> {
    T data;
    Node<T> next;

    // default constructor
    Node(){}
    Node(T data){
        this.data = data;
        this.next = null;
    }
}
