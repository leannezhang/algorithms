package src.LinkedList;

/**
 * Created by liyangzhang on 2016-06-25.
 *
 * There is a better solution than this.
 * Run time: O(n^2)
 */
public class MergeLists {

    //  Merge two linked lists
    //  head pointer input could be NULL as well for empty list
    //  Node is defined as
    static class Node {
        int data;
        Node next;
        public Node(){}

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node mergeList = null;
        Node pointerA = headA;
        Node pointerB = headB;

        while (pointerA != null && pointerB != null) {
            Node tmp = new Node();

            if (pointerA.data <= pointerB.data) {
                tmp = new Node(pointerA.data, null);
                mergeList = append(tmp, mergeList);
                pointerA = pointerA.next;
            } else {
                tmp = new Node(pointerB.data, null);
                append(tmp, mergeList);
                pointerB = pointerB.next;
            }
        }

        if (pointerA == null && pointerB!= null) {
            if (mergeList == null) {
                return pointerB;
            } else {
                return append(pointerB, mergeList);
                //mergeList.next = pointerB;
                //return mergeList;
            }
        } else if (pointerA != null && pointerB == null) {
            if (mergeList == null) {
                return pointerA;
            } else {
                return append(pointerA, mergeList);
            }
        } else {
            return mergeList;
        }
    }
    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("nothing");
        }
        else {
            while (head.next != null) {
                System.out.println(head.data);
                head = head.next;
            }
            System.out.println(head.data);
        }
    }

    public static Node append(Node n, Node head) {
        Node header = head;
        if (head == null) {
            return n;
        }

        while (head.next != null) {
            head = head.next;
        }
        head.next = n;
        return header;
    }

    public static void main(String[] args) {
        Node headA = new Node();
        headA.data = 1;
        headA.next = new Node(3, null);
        headA.next.next = new Node(5, null);

        Node headB = new Node(2, null);
        headB.next = new Node(4, null);
        headB.next.next = new Node(7, null);

        Node mergedList = MergeLists(headA, headB);
        printLinkedList(mergedList);
    }


}
