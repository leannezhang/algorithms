package src;

import java.io.IOException;
import java.util.*;

/**
 * Created by liyangzhang on 2016-05-25.
 */
public class NumberOfOccurances {

    public static void main(String[] args) throws IOException {

        int N;
        int K;
        int L;
        int M;
        String str;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();
        L = in.nextInt();
        M = in.nextInt();
        str = in.next();

        System.out.println(mostOftenSubstring(N, K, L, M, str));
    }

    private static int mostOftenSubstring(int n, int k, int l, int m, String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=k; i<=l; i++) {
            for (int j=0; i+ j <= n; j++) {
                String substring = str.substring(j, i+j);
                if (numberOfUniqueCharacters(substring) <= m) {
                    if (map.containsKey(substring)) {
                        map.put(substring, map.get(substring) + 1);
                    } else {
                        map.put(substring, 1);
                    }
                }
            }
        }
        int max = 0;
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() > max) {
                max = (int) entry.getValue();
            }

        }
        return max;
    }

    public static int numberOfUniqueCharacters(String str) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }
}


