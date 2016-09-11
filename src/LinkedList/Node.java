package LinkedList;

/**
 * Created by liyangzhang on 2016-06-26.
 */
public class Node {

    public int data;
    public Node next;

    public Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node insertToHead(Node head, int x) {
        Node newHead = new Node();
        newHead.data = x;
        newHead.next= head;
        return newHead;
    }

    public void printLinkedList(Node head) {
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

    public Node append(Node n, Node head) {
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

    public Node InsertNth(Node head, int data, int position) {
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

    public Node deleteNode(Node root, int num) {

        Node head = root;

        if (root.data == num) {
            return head.next;
        }

        while (root.next != null) {
            if (root.next.data == num) {
                root.next = root.next.next;
                return head;
            }
            root = root.next;
        }

        return root;
    }

    /**
     * This question tests your skills in keeping track of pointers.
     *
     * The key is make sure that when you swap nodes
     * the original linkage should be destroyed as well.
     *
     * The easiest solution is used to recursion and a dummy node.
     *
     * @param head
     * @return
     */
    public Node swapPairs(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(head.data, null);
        head = head.next;
        Node nextnextNode = swapPairs(head.next);
        head.next = dummy;
        dummy.next = nextnextNode;
        return head;
    }

    public Node swapPairsIteratively(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p1 = head;
        Node p2 = p1.next;
        Node temp = p2.next;
        head = p2;
        while (p1 != null && p2 != null) {
            p2.next = p1;
            p1.next = temp;
            p1 = temp;
            if (p1 != null) {
                if (p1.next != null) {
                    p2.next.next = p1.next;
                }
                p2 = p1.next;
            }
            if (p2 != null) {
                temp = p2.next;
            }
        }
        return head;
    }


}
