package com.dsa.linkedlist.singly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
            while (temp.next != null) {
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
        if(node == null || node.next == null){
            return node;
        }
//        Node<T> prev = null;
//        Node<T> curr = node;
//        while (curr != null) {
//            Node<T> next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;

        // recursive
        Node<T> newHead = reverseLinkedList(node.next);
        Node<T> next = node.next;
        next.next = node;
        node.next = null;
        return newHead;
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
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> prev = node;
        Node<T> next = node.next;
        Node<T> curr = node;
        while (next != null) {
            if (prev.data != next.data) {
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

    public Node<T> rotateKNodes(Node<T> node, int noOfRotate) {
        // 1 2 3 4 5 6 , k = 4
        // 1. do partition of node (till kth rotation, remaining nodes)
        Node<T> temp = node;
        int count = 1;
        while(count < noOfRotate && temp.next != null){
            count++;
            temp = temp.next;
        }
        Node<T> partitionNode = temp.next;
        // to separate both the node list
        temp.next = null;
        // 2. remove last node from partitionNode and attach to front of main node,
        // repeat till partitionNode is not null
        return mergeTwoNode(node, partitionNode);
    }

    private Node<T> mergeTwoNode(Node<T> node, Node<T> partitionNode) {
        while (partitionNode != null) {
            // get last node from partitionNode
            Node<T> temp = partitionNode;
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next;
            }
            // if single node left
            Node<T> lastNode = null;
            if (temp.next == null) {
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

    public Node<T> rotateKNodes2ndApproach(Node<T> node, int noOfRotation) {
        if (node == null) {
            return null;
        }
        Node<T> lastNode = node;
        Node<T> temp = node;

        // get lastNode
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        // detach one node each time from front and attach to last node
        while (noOfRotation > 0) {
            // move the head to one node
            node = node.next;
            // get node from front
            temp.next = null;

            // front to node attach to last node
            lastNode.next = temp;
            lastNode = temp;

            // reassign temp with new  head node
            temp = node;
            noOfRotation--;
        }
        return node;
    }

    public boolean detectLoop(Node<T> node) {
        if (node == null) return false;
        // Floyd’s Cycle-Finding Algorithm
        Node<T> slow = node;
        Node<T> fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node<T> skipMdeleteN(Node<T> node, int m, int n) {
        if (node == null) return null;
        Node<T> curr = node;
        Node<T> temp;
        // traverse whole list
        // 1->2->3->4->5->6->7->8
        while (curr != null) {
            // skip M nodes
            for(int i = 1; i<m & curr != null; i++){
                curr = curr.next;
            }
            // if last node reached with M skip, then no node to delete
            if(curr == null) return node;
            // assign start node to head for delete the N nodes
            temp = curr.next;
            // delete N nodes, keep next node of last deleted node as temp
            for(int i = 1; i<=n & temp != null; i++){
                temp = temp.next;
            }
            // assign last node of temp with current node
            curr.next = temp;
            // update the current node.
            curr = temp;
        }
        return node;
    }

    public void swapPairWise(Node<T> node) {
        Node<T> temp = node;
        while(temp != null && temp.next != null){
            T tData = temp.data;
            temp.data = temp.next.data;
            temp.next.data = tData;
            temp = temp.next.next;
        }
    }

    /**
     * It performs 3 step
     * 1. Detach RHS and LHS of current node
     * 2. Reverse the current node
     * 3. Attach LHS and RHS to current node
     */
    public Node<T> reverseKGroup(Node<T> node, int K) {
        // hold previous list last node
        Node<T> preTail = null;
        // Hold current list head node
        Node<T> currHead = node;
        // Hold current list last node
        Node<T> currTail = node;
        // Hold current list next node
        Node<T> nextHead = null;

        // traverse the LL till current head node becomes null
        while(currHead != null) {
            int count = 1;
            // traverse till k no. of nodes and check given K not exceeds total LL size
            while(currTail.next != null && count < K){
                currTail = currTail.next;
                count++;
            }

            // if K exceeds total length of LL (count), then break the loop.
            if( count != K) {
                break;
            }

            // assign the nextHead
            nextHead = currTail.next;

            // Detach RHS of current Node
            currTail.next = null;
            // detach LHS of current node
            if(preTail != null){
                preTail.next = null;
            }

            // reverse the current node
            /* after reversing current tail will become new current list head and
            currHead will become new current list tail i.e. currHead = currTail and currTail = currHead*/
            currTail = this.reverseLinkedList(currHead);

            // attach LHS
            if(preTail != null){
                preTail.next = currTail;
            } else {
                // for first k size list previous will be null, hence update head node.
                node = currTail;
            }

            // attach RHS
            currHead.next = nextHead;

            // update the pointers
            preTail = currHead;
            currHead = nextHead;
            currTail = nextHead;

        }
        return node;
    }

    public Node<Integer> sort0s1s2s(Node<Integer> node) {
        if(node == null) return null;
        int[] counter= {0,0,0};
        Node<Integer> curr = node;
        while(curr != null){
            counter[curr.data]++;
            curr = curr.next;
        }
        System.out.println(Arrays.toString(counter));
        curr = node;
        int i = 0;
        while(curr != null){
            if(counter[i] == 0){
                i++;
            } else {
                curr.data = i;
                counter[curr.data]--;
                curr = curr.next;
            }

        }
        return node;
    }

    public Node<T> getIntersectionNode(Node<T> node1, Node<T> node2) {

        Node<T> t1 = node1;
        Node<T> t2 = node2;

        // check if both node are not null
        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == t2){
                return t1;
            }
            // if any one node is null, reassign it to other node
            if(t1 == null){
                t1 = node2;
            }
            if(t2 == null){
                t2 = node1;
            }
        }
        return null;


        // O(N1) + O(N2) + O(N2-N1) + O(N1) = O(N1+2N2)
        /*int N1_size = getSize(node1); // O(N1)
        int N2_size = getSize(node2); // O(N2)
        int diff = 0;
        int count = 0;
        Node<T> temp;
        if(N1_size > N2_size) {
            diff = N1_size - N2_size;
            return getNode(diff, node1, node2);
        } else {
            diff = N2_size - N1_size;
            return getNode(diff, node2, node1);
        }*/
    }

    private Node<T> getNode(int diff, Node<T> node1, Node<T> node2) {
        Node<T> curr1 = node1;
        Node<T> curr2 = node2;
        int count = 0;
        // O(N2 -N1)
        while(count++ < diff){
            if(curr1 == null) return null;
            curr1 = curr1.next;
        }
        // O(N1)
        while(curr1 != null && curr2 != null){
            if(curr1.data == curr2.data){
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    /**
     * it can be divided into 3 parts.
     * 1. create copy node for each node and place next to it.
     * 2. map the random pointers of copy node.
     * 3. map the next node of original node's of LL.
     */
    public Node<T> cloneLL(Node<T> node) {
        if(node == null ) return null;
        // 1. create copy node for each node and place next to it.
        constructCopyNode(node);
        // 2. map the random pointers of copy node.
        mapRandomPointersOfCopiedNode(node);
        // 3. map the next node of original node's of LL.
        return separateCopyNodeFromOriginalNode(node);
    }

    private Node<T> separateCopyNodeFromOriginalNode(Node<T> node) {
        Node<T> dummyNode = new Node<>();
        Node<T> result = dummyNode;
        Node<T> temp = node;
        while(temp != null){
            result.next = temp.next;
            result = result.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }

    private void mapRandomPointersOfCopiedNode(Node<T> node) {
        Node<T> temp = node;
        while(temp != null){
            Node<T> copyNode = temp.next;
            // random node's copy node
            if(temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

    private void constructCopyNode(Node<T> node) {
        Node<T> temp = node;
        while(temp != null){
            Node<T> copyNode = new Node<>(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }

    public Node<Integer> addTwoNumbers(Node<T> head1, Node<T> head2) {

        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> res = dummy;
        Node<T> curr1 = head1;
        Node<T> curr2 = head2;
        int carry = 0;

        while(curr1 != null || curr2 != null){
            int sum = carry;
            if(curr1 != null){
                sum+=(int)curr1.data;
                curr1 = curr1.next;
            }
            if(curr2 != null){
                sum+=(int)curr2.data;
                curr2 = curr2.next;
            }
            carry = sum / 10;
            res.next = new Node<>(sum % 10);
            res = res.next;
        }
        if(carry > 0){
            res.next = new Node<>(carry);
        }
//        Node<Integer> newNode;
//        while(curr1 != null && curr2 != null){
//            int sum = carry + (int)curr1.data + (int)curr2.data;
//            newNode = new Node<>(sum % 10);
//            carry = sum / 10;
//            dummy.next = newNode;
//            dummy = dummy.next;
//            curr1 = curr1.next;
//            curr2 = curr2.next;
//        }
//
//        while(curr1 != null){
//            int sum = carry + (int)curr1.data;
//            newNode = new Node<>(sum % 10);
//            carry = sum / 10;
//            dummy.next = newNode;
//            dummy = dummy.next;
//            curr1 = curr1.next;
//        }
//        while(curr2 != null) {
//            int sum = carry +(int) curr2.data;
//            newNode = new Node<>(sum % 10);
//            carry = sum / 10;
//            dummy.next = newNode;
//            dummy = dummy.next;
//            curr2 = curr2.next;
//        }
//
//        if(carry > 0) {
//            dummy.next = new Node<>(carry);
//            dummy = dummy.next;
//        }
        return dummy.next;

    }

    // https://www.youtube.com/watch?v=qf6qp7GzD5Q&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=7
    public Node<T> oddEvenList(Node<T> head) {
        if(head == null || head.next == null){
            return head;
        }
        Node<T> odd = head;
        Node<T> even = head.next;
        Node<T> evenHead = head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        // connect odd with even head
        odd.next = evenHead;
        return head;
    }

    // https://www.youtube.com/watch?v=lRY_G-u_8jk&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=11
    public boolean isPalindrome(Node<T> head) {
        if(head == null || head.next == null) {
            return true;
        }

        // 1. get the middle element
        Node<T> slow = head;
        Node<T> fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse the 2nd half of list
        Node<T> secondHalfHead = this.reverseLinkedList(slow.next);

        // 3. compare first and second half list
        Node<T> first_node = head;
        Node<T> second_node = secondHalfHead;
        while(second_node != null){
            // any time data mismatch causes not palindrome
            if(first_node.data != second_node.data){
                // before returning rearrange the list to it's original
                this.reverseLinkedList(secondHalfHead);
                return false;
            }
            second_node = second_node.next;
            first_node = first_node.next;
        }
        // before returning rearrange the list to it's original
        this.reverseLinkedList(secondHalfHead);
        return true;
    }

    // Add one to given Node
    public Node<Integer> addOne(Node<Integer> head) {
        if(head == null){
            return null;
        }
        // using recursion, it is the only way doing this without reversing as we can do it by backtracking using recursion
        int carry = helper(head);
        if(carry > 0) {
            Node<Integer> newNode = new Node<>();
            newNode.data = carry;
            newNode.next = head;
            return newNode;
        }
        return head;

        // Node reversedHead = reverseLinkedList(head);
        // Node curr = reversedHead;
        // int carry = 1;
        // while(curr != null) {
        // 	if(carry == 0){
        // 		break;
        // 	}
        // 	int sum = carry + curr.data;
        // 	curr.data = sum % 10;
        // 	carry = sum / 10;
        // 	curr = curr.next;
        // }
        // // reverse after adding 1 to node
        // Node modifiedNode = reverseLinkedList(reversedHead);
        // // for last carry over, create new node and attach it to front of modified node
        // if(carry > 0){
        // 	Node newNode = new Node(carry);
        // 	newNode.next = modifiedNode;
        // 	modifiedNode = newNode;
        // 	// curr = curr.next;
        // }
        // return modifiedNode;

    }
    private int helper(Node<Integer> node){
        if(node == null){
            return 1;
        }
        int carry = helper(node.next);
        int sum = carry + node.data;
        if(sum < 10){
            node.data = sum;
            return 0;
        }
        node.data = 0;
        return 1;
    }


    public Node<Integer> flattenLinkedList(Node<Integer> head) {

        // TC = O(N * M * log(N)) N = no of nodes reaches using next pointer and M for child nodes
        // SC = O(N)
        // using Priority Queue
        // Priority queue to store nodes
        PriorityQueue<Node<Integer>> pq
                = new PriorityQueue<>(new NodeComparator());

        // Adding main linked list nodes into priority queue
        while (head != null) {
            pq.add(head);
            head = head.next;
        }

        Node<Integer> dummy= new Node<>(-1);
        Node<Integer> res = dummy;
        // Extracting the minimum node
        // while priority queue is not empty
        while (!pq.isEmpty()) {
            // Extracting the minimum node
            Node<Integer> k = pq.poll();

            // Printing the node data
            res.child = new Node<>(k.data);
            res = res.child;
            if (k.child != null) {
                pq.add(k.child);
            }
        }

        return dummy.child;

        // TC: = O(2(N*M)), SC = O(N)
        // using recursion
        // if(head == null || head.next == null) {
        //     return head;
        // }

        // Node mergedNode = flattenLinkedList(head.next);
        // return merge(head, mergedNode);
    }

    private static Node<Integer> merge(Node<Integer> node1, Node<Integer> node2){
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> res = dummy;
        while(node1 != null && node2 != null){
            if(node1.data < node2.data){
                res.child = node1;
                res = node1;
                node1 = node1.child;
            } else {
                res.child = node2;
                res = node2;
                node2 = node2.child;
            }
            res.next = null;
        }
        if(node1 != null) {
            res.child = node1;
        } else {
            res.child = node2;
        }
        return dummy.child;
    }

    public void printChild(Node<T> head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.child;
        }
        System.out.println();
    }
}

class NodeComparator implements Comparator<Node<Integer>>{

    @Override
    public int compare(Node<Integer> o1, Node<Integer> o2) {
        return o1.data - o2.data;
    }

}
