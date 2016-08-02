package concept;

/**
 * Created by liyangzhang on 2016-04-10.
 */
public class RunnableThreadExample implements Runnable{

    public int count = 0;
    @Override
    public void run() {
        System.out.println("RunnableThread starting.");
        while (count < 1000) {
            System.out.println("Count :" + count++);
        }
        System.out.println("RunnableThread terminating.");
    }
}
