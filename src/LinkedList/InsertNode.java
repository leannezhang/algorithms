package src.LinkedList;

/**
 *
 Insert Node at the beginning of a linked list
 head pointer input could be NULL as well for empty list

 Run time: O(1) only modify the head element.
 * Created by liyangzhang on 2016-06-26.
 */
public class InsertNode {

    class Node {
        int data;
        Node next;
    }

    Node Insert(Node head,int x) {
        Node newHead = new Node();
        newHead.data = x;
        newHead.next= head;
        return newHead;
    }

}


