package com.dsa.linkedlist.singly;

public class SinglyLLOperation<T> {
    Node<T> head;

    public void addNodeAtStart(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void insert(T data) {
        addNodeAtStart(data);
    }

    public Node<T> insertForGivenNodeAtEnd(Node<T> node, T data) {
        Node<T> newNode = new Node<>(data);
        if (node == null) {
            node = newNode;
        } else {
            Node<T> temp = node;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return node;
    }

    public void addNodeAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int getSize(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int count = 1;
        Node<T> temp = node;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void addNodeAtGivenIndex(T data, int index) {
        if (index < 0) {
            System.out.println("-ve index not allowed !!");
            return;
        } else if (index == 0) {
            addNodeAtStart(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("out of bound index range");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print(Node<T> node) {
        if (node == null) {
            System.out.println("LinkedList is Empty !!");
            return;
        }
        Node<T> temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node<T> reverseLinkedList(Node<T> node) {
        Node<T> prev = null;
        Node<T> curr = node;
        Node<T> next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public void deleteForGivenData(T data) {
        Node<T> temp = this.head;
        Node<T> prev = null;
        boolean isFound = false;
        while (temp != null) {
            if (temp.data == data) {
                isFound = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (isFound) {
            // prev null means, delete from front
            if (prev == null) {
                head = temp.next;
            } else {
                prev.next = temp.next;
            }
        }
        if (temp == null) {
            System.out.println("given data not found in LinkedList");
            return;
        }


    }

    public void deleteAtGivenIndex(int index) {
        if (index < 0) {
            System.out.println("index is -ve");
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<T> temp = this.head;
        // traverse until last node. hence temp != null check given
        for (int i = 0; i < index - 1 && temp != null; i++) {
            temp = temp.next;
        }
        // out of node length
        if (temp == null || temp.next == null) {
            System.out.println("Index not in range");
            return;
        }
        temp.next = temp.next.next;
    }

    public T getMiddleElement(Node<T> node) {
//        List<T> nodeV = new Vector<>();
//        Node<T> temp = node;
//        while(temp != null){
//            nodeV.add(temp.data);
//            temp = temp.next;
//        }
//        int middleIndex = nodeV.size()/2;
//        return nodeV.get(middleIndex);

        // using fast & slow pointer
        if (node == null) {
            System.out.println("node is null");
            System.exit(-1);
        }
        Node<T> slow = node;
        Node<T> fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        return slow.data;
    }

    public Node<T> mergeTwoSortedList(Node<T> node1, Node<T> node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 != null && node2 == null) {
            return node1;
        }
        if (node1 == null) {
            return node2;
        }
        // take a dummy node and start traverse from there.
        Node<T> dummyNode = new Node<>();
        Node<T> currNode = dummyNode;
        // traverse until any node becomes null
        while (node1 != null && node2 != null) {
            if ((int) node1.data <= (int) node2.data) {
                currNode.next = node1;
                node1 = node1.next;
            } else {
                currNode.next = node2;
                node2 = node2.next;
            }
            currNode = currNode.next;
        }
        // non-null node should attach with current node as remaining items
        currNode.next = (node1 == null) ? node2 : node1;
        return dummyNode.next;
    }


    public Node<T> removeDuplicatesSortedList(Node<T> node) {
        if(node == null || node.next == null){
            return node;
        }
        Node<T> prev = node;
        Node<T> next = node.next;
        Node<T> curr = node;
        while(next != null){
            if(prev.data != next.data){
                curr.next = next;
                curr = next;
            } else {
                // if duplicates found make current node next address null
                curr.next = null;
            }
            prev = next;
            next = next.next;
        }
        return node;
    }

    public Node<T> rotateKNodes(Node<T> node, T noOfRotate) {
        // 1 2 3 4 5 6 , k = 4
        // 1. do partition of node (till kth rotation, remaining nodes)
        Node<T> temp = node;
        for(int i=1; i<(int)noOfRotate & temp != null; i++){
            temp = temp.next;
        }
        assert temp != null;
        Node<T> partitionNode = temp.next;
        // to separate both the node list
        temp.next = null;
        // 2. remove last node from partitionNode and attach to front of main node,
        // repeat till partitionNode is not null
        return mergeTwoNode(node, partitionNode);
    }

    private Node<T> mergeTwoNode(Node<T> node, Node<T> partitionNode) {
        while(partitionNode != null) {
            // get last node from partitionNode
            Node<T> temp = partitionNode;
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next;
            }
            // if single node left
            Node<T> lastNode = null;
            if(temp.next == null){
                lastNode = temp;
                partitionNode = null;
                temp = null;
            } else {
                lastNode = temp.next;
                // detach the last node from partitionNode
                temp.next = null;
            }
            // attach to main node
            lastNode.next = node;
            node = lastNode;
        }
        return node;
    }

}
