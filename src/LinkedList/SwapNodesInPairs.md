# Swap Nodes in Pairs

> Given a linked list, swap every two adjacent nodes and return its head.

> For example,
> Given 1->2->3->4, you should return the list as 2->1->4->3.

> Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

```Java
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
```
