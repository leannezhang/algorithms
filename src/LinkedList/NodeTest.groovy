

import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
/**
 * Created by liyangzhang on 2016-06-26.
 */
public class NodeTest {

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    void testInsertToHead() {


        headA.InsertNth(headA, 2, 1);

    }
}
