package LinkedList;


/**
 * Created by liyangzhang on 2016-08-01.
 */
public class SwapNodeTest {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2, null);
        n1.next.next = new Node(3, null);

        n1.printLinkedList(n1.swapPairs(n1));
    }
}
