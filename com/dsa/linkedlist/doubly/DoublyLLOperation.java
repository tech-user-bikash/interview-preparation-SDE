package com.dsa.linkedlist.doubly;

public class DoublyLLOperation {
    public Node pushAtFirst(Node head, int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        return head;
    }

    public void display(Node head) {
        if (head == null) {
            System.out.println("Empty List !");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node pushAtLast(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.prev = temp;
        temp.next = newNode;
        return head;
    }

    public Node pushAtKPosition(Node head, int data, int K) {
        Node newNode = new Node(data);
        if (head == null) {
            if (K == 1) {
                head = newNode;
                return head;
            } else {
                System.out.println("Technically not possible to add as K>1 for null node");
                return null;
            }
        }
        if (K == 1) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return head;
        }
        int count = 1;
        Node temp = head;
        while (temp != null) {
            if (count + 1 == K) {
                newNode.prev = temp;
                temp.next = newNode;
            } else if (count == K - 1) {
                newNode.prev = temp;
                newNode.next = temp.next;
                temp.next.prev = newNode;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }

    public Node reverseDLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node last = null;
        while (curr != null) {
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            curr = curr.prev;
        }
        return last.prev;
    }


}
