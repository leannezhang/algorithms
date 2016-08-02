package LinkedList;

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
    public static Node InsertNth(Node head, int data, int position) {
        Node newNode = new Node();
        Node header = head;

        // scenario when head is null
        if ( head == null) {
            newNode.data = data;
            return newNode;
        }

        newNode.data = data;
        // scenario when we want to insert in the first element on the list
        if (position == 0) {
            newNode.next = head;
            header = newNode;
            return header;
        }

        // insert somewhere else
        // should stop the element before the position to keep track of next element and assign new element
        for (int i=1; i < position && head.next !=null; i++) {
            head = head.next;
        }
        if (head.next != null) {
            newNode.next =  head.next;
            head.next = newNode;
        } else {
            head.next = newNode;
        }
        return header;
    }
    public static void main(String[] args) {
        Node headA = new Node();
        headA.data = 1;
        headA.next = new Node(2, null);
//        headA.next.next = new Node(3, null);

        //Node head = InsertNth(headA, 2, 1);
        //Node head = deleteNode(headA, 1);
        printLinkedList(headA);
    }


}
