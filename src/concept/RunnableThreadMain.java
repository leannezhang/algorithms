package concept;

/**
 * Created by liyangzhang on 2016-04-10.
 */
public class RunnableThreadMain {
    public static void main(String[] args) {
        int charCount = 0;
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        /* wait until above thread counts to 5 (slowly) */
        while (charCount < 1000) {
            System.out.println("Char count: " + (char) ('a' + charCount++));
        }
    }
}
