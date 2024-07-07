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
//        node3 = stringLL.insertForGivenNodeAtEnd(null, "A");
//        node3 = stringLL.insertForGivenNodeAtEnd(node3, "B");
//        node3 = stringLL.insertForGivenNodeAtEnd(node3, "C");
//        node3 = stringLL.insertForGivenNodeAtEnd(node3, "E");
//        node3 = stringLL.insertForGivenNodeAtEnd(node3, "G");
//        stringLL.print(node3);
//        var reverse = stringLL.reverseLinkedList(node3);
//        stringLL.print(reverse);

        // remove duplicate from sorted list
//        Node<Integer> node = null;
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        var freshNodeList = ll.removeDuplicatesSortedList(node);
//        ll.print(freshNodeList);

        // rotate clockwise k nodes
//        Node<Integer> node = null;
//        node = ll.insertForGivenNodeAtEnd(node, 1);
//        node = ll.insertForGivenNodeAtEnd(node, 2);
//        node = ll.insertForGivenNodeAtEnd(node, 3);
//        node = ll.insertForGivenNodeAtEnd(node, 4);
//        node = ll.insertForGivenNodeAtEnd(node, 5);
//        node = ll.insertForGivenNodeAtEnd(node, 6);
//        node = ll.insertForGivenNodeAtEnd(node, 7);
//        node = ll.insertForGivenNodeAtEnd(node, 8);
//        node = ll.insertForGivenNodeAtEnd(node, 9);
//        var rotatedNode = ll.rotateKNodes(node, 2);
//        var rotatedNode = ll.rotateKNodes2ndApproach(node, 2);
//        ll.print(rotatedNode);

        // Loop detection
//        Node<Integer> node = null;
//        node = ll.insertForGivenNodeAtEnd(node,20);
//        node = ll.insertForGivenNodeAtEnd(node,4);
//        node = ll.insertForGivenNodeAtEnd(node,15);
//        node = ll.insertForGivenNodeAtEnd(node,10);
//
//        /*Create loop for testing */
//        node.next.next.next.next = node;
//        var isLoopExists = ll.detectLoop(node);
//        System.out.println(isLoopExists);

        // Delete N nodes after M nodes of a linked list
//        Node<Integer> node = null;
//        node = ll.insertForGivenNodeAtEnd(node,1);
//        node = ll.insertForGivenNodeAtEnd(node,2);
//        node = ll.insertForGivenNodeAtEnd(node,3);
//        node = ll.insertForGivenNodeAtEnd(node,4);
//        node = ll.insertForGivenNodeAtEnd(node,5);
//        node = ll.insertForGivenNodeAtEnd(node,6);
//        node = ll.insertForGivenNodeAtEnd(node,7);
//        node = ll.insertForGivenNodeAtEnd(node,8);
//        node = ll.insertForGivenNodeAtEnd(node,9);
//        int M = 2, N = 4;
//        var newNode = ll.skipMdeleteN(node, M, N);
//        ll.print(newNode);

        // swap pair wise & reverse k group elements
//        Node<Integer> node = null;
//        node = ll.insertForGivenNodeAtEnd(node,1);
//        node = ll.insertForGivenNodeAtEnd(node,2);
//        node = ll.insertForGivenNodeAtEnd(node,3);
//        node = ll.insertForGivenNodeAtEnd(node,4);
//        node = ll.insertForGivenNodeAtEnd(node,5);
//        ll.swapPairWise(node);
//        node = ll.reverseKGroup(node, 3);
//        ll.print(node);

        // sort LL which has 0's, 1's, 2's
//        Node<Integer> node = null;
//        node = ll.insertForGivenNodeAtEnd(null,0);
//        node = ll.insertForGivenNodeAtEnd(node,2);
//        node = ll.insertForGivenNodeAtEnd(node,1);
//        node = ll.insertForGivenNodeAtEnd(node,0);
//        node = ll.insertForGivenNodeAtEnd(node,2);
//        node = ll.sort0s1s2s(node);
//        ll.print(node);

//        Node<Integer> node1 = new Node<>(3);
//        node1.next = new Node<>(6);
//        node1.next.next = new Node<>(9);
//        node1.next.next.next = new Node<>(15);
//        node1.next.next.next.next = new Node<>(30);
//
//        // creating second linked list
//        Node<Integer> node2 = new Node<>(10);
//        node2.next = new Node<>(15);
//        node2.next.next = node1.next.next;
////
//        Node<Integer> newNode = ll.getIntersectionNode(node1, node2);
//        System.out.println(newNode == null ? "No intersection found" : "intersection data:"+newNode.data);

        // clone of a random pointer linked list
        // Creating a linked list with random pointer
//        Node<Integer> head = new Node<>(1);
//        head.next = new Node<>(2);
//        head.next.next = new Node<>(3);
//        head.next.next.next = new Node<>(4);
//        head.next.next.next.next = new Node<>(5);
//        head.random = head.next.next;
//        head.next.random = head;
//        head.next.next.random = head.next.next.next.next;
//        head.next.next.next.random = head.next.next;
//        head.next.next.next.next.random = head.next;
//
//        System.out.print("Original LL :: ");
//        ll.print(head);
//        Node<Integer> head1 = ll.cloneLL(head);
//        System.out.print("Cloned   LL :: ");
//        ll.print(head1);

        // Add two number
//        Node<Integer> node1 = new Node<>(5);
//        node1.next = new Node<>(6);
//        node1.next.next = new Node<>(3);
//        ll.print(node1);
//        Node<Integer> node2 = new Node<>(8);
//        node2.next = new Node<>(4);
//        node2.next.next = new Node<>(6);
//        ll.print(node2);
//        Node<Integer> additionNode = ll.addTwoNumbers(node1, node2);
//        ll.print(additionNode);

        // Odd-Even Node list
//        Node<Integer> node = new Node<>(5);
//        node.next = new Node<>(6);
//        node.next.next = new Node<>(3);
//        node.next.next.next = new Node<>(9);
//        node.next.next.next.next = new Node<>(19);
//        ll.print(node);
//        Node<Integer> oddEvenList = ll.oddEvenList(node);
//        ll.print(oddEvenList);

        // Palindrome test
//        SinglyLLOperation<String> ll2 = new SinglyLLOperation<>();
//        Node<String> node = new Node<>("M");
//        node.next = new Node<>("A");
//        node.next.next = new Node<>("D");
//        node.next.next.next = new Node<>("A");
//        node.next.next.next.next = new Node<>("M");
//        ll2.print(node);
//        var ans = ll2.isPalindrome(node);
//        System.out.println(ans ? "Yes, it is Palindrome" : "Sorry, it is not palindrome");

        // Add 1 to given Node
//        Node<Integer> node = new Node<>(8);
//        node.next = new Node<>(9);
//        System.out.print("LL : ");
//        ll.print(node);
//        node = ll.addOne(node);
//        System.out.print("After adding 1 to LL : ");
//        ll.print(node);

        // Flatten LinkedList
        Node<Integer> head = new Node<>(5);
        Node<Integer> temp = head;
        Node<Integer> bt = head;

        bt.child = new Node<>(7);
        bt.child.child = new Node<>(8);
        bt.child.child.child = new Node<>(30);

        temp.next = new Node<>(10);
        temp = temp.next;

        bt = temp;
        bt.child = new Node<>(20);

        temp.next = new Node<>(19);
        temp = temp.next;

        bt = temp;
        bt.child = new Node<>(22);
        bt.child.child = new Node<>(50);

        temp.next = new Node<>(28);
        temp = temp.next;

        bt = temp;
        bt.child = new Node<>(35);
        bt.child.child = new Node<>(40);
        bt.child.child.child = new Node<>(45);

        Node<Integer> newNode = ll.flattenLinkedList(head);
        ll.printChild(newNode);

    }
}
