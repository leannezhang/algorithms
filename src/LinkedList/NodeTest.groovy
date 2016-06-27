

import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * Created by liyangzhang on 2016-06-26.
 */
public class NodeTest {

    @BeforeMethod
    public void setUp() throws Exception {
        Node headA = new Node();
        headA.data = 1;
        headA.next = new Node(3, null);
        headA.next.next = new Node(5, null);
    }

    @Test
    void testInsertToHead() {

        headA.InsertNth(headA, 2, 1);

    }
}
