package ArrayList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liyangzhang on 2016-05-25.
 */
public class RepeatedWordinSentences {
    /*
 * Complete the function below.
 */

    static String firstRepeatedWord(String s) {
        String[] tokens = s.split("[ \\t,:;\\-\\.]+");

        Set<String> uniqueWords = new HashSet<String>();
        for (String token : tokens) {
            if (uniqueWords.contains(token)) {
                return token;
            } else {
                uniqueWords.add(token);
            }
        }
        return null;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(firstRepeatedWord(scanner.nextLine()));
    }


}
