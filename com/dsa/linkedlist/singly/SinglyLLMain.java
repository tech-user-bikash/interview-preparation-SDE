package com.dsa.linkedlist.singly;

public class SinglyLLMain {
    public static void main(String[] args) {
        SinglyLLOperation<Integer> ll = new SinglyLLOperation<>();
//        ll.addNodeAtEnd(1);
//        ll.addNodeAtEnd(2);
//        ll.addNodeAtEnd(3);
//        ll.addNodeAtStart(5);
//        ll.insert(4);
//        ll.addNodeAtEnd(6);
//        ll.addNodeAtGivenIndex(7, 5);
//        ll.print(ll.head);
//        System.out.println("total size : "+ll.getSize(ll.head));
//        ll.deleteForGivenData(4);
//        ll.print(ll.head);
//        ll.deleteAtGivenIndex(61);
//        var item = ll.getMiddleElement(ll.head);
//        System.out.println("Middle Item :"+item);
//        ll.print(ll.head);

//        Node<Integer> node1 = null;
//        node1 = ll.insertForGivenNodeAtEnd(node1, 1);
//        node1 = ll.insertForGivenNodeAtEnd(node1, 4);
//        node1 = ll.insertForGivenNodeAtEnd(node1, 5);
//        ll.print(node1);
//        Node<Integer> node2 = null;
//        node2 = ll.insertForGivenNodeAtEnd(node2, 2);
//        node2 = ll.insertForGivenNodeAtEnd(node2, 3);
//        node2 = ll.insertForGivenNodeAtEnd(node2, 6);
//        ll.print(node2);
//        var mergedNode = ll.mergeTwoSortedList(node1, node2);
//        ll.print(mergedNode);

//        SinglyLLOperation<String> stringLL = new SinglyLLOperation<>();
//        Node<String> node3 = null;
//        node3 = stringLL.insertForGivenNodeAtEnd(node3, "A");
//        node3 = stringLL.insertForGivenNodeAtEnd(node3, "B");
//        node3 = stringLL.insertForGivenNodeAtEnd(node3, "C");
//        stringLL.print(node3);
//        var reverse = stringLL.reverseLinkedList(node3);
//        stringLL.print(reverse);

        // remove duplicate from sorted list
//        Node<Integer> node = null;
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        node = ll.insertForGivenNodeAtEnd(node, 2);
//        node = ll.insertForGivenNodeAtEnd(node, 2);
//        node = ll.insertForGivenNodeAtEnd(node, 2);
//        var freshNodeList = ll.removeDuplicatesSortedList(node);
//        ll.print(freshNodeList);

        // rotate clockwise k nodes
        Node<Integer> node = null;
        node = ll.insertForGivenNodeAtEnd(node, 1);
        node = ll.insertForGivenNodeAtEnd(node, 2);
        node = ll.insertForGivenNodeAtEnd(node, 3);
        node = ll.insertForGivenNodeAtEnd(node, 4);
        node = ll.insertForGivenNodeAtEnd(node, 5);
        node = ll.insertForGivenNodeAtEnd(node, 6);
        node = ll.insertForGivenNodeAtEnd(node, 7);
        node = ll.insertForGivenNodeAtEnd(node, 8);
        node = ll.insertForGivenNodeAtEnd(node, 9);
        var rotatedNode = ll.rotateKNodes(node, 1);
        ll.print(rotatedNode);
    }
}
