package src.ArrayList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liyangzhang on 2016-05-25.
 */
public class UniquePalindrome {

    static int palindrome(String str) {
        Set<String> uniquePalindromes = new HashSet<String>();

        for (int i = 1; i <= str.length() ; i++) {
            for (int j=0; i+ j <= str.length(); j++) {
                int endIndex = i+j;
                String substring = str.substring(0+j, endIndex);

                if (isPalindrome(substring)) {
                    uniquePalindromes.add(substring);
                }
            }

        }
        return uniquePalindromes.size();
    }


    static boolean isPalindrome(String substring) {
        int middle = substring.length() / 2;

        for (int i =0; i < middle; i++ ) {
            int right = substring.length()-i-1;
            if ( substring.charAt(i) != substring.charAt(right)) {
                return false;
            }
        }
        return true;


    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println(palindrome(in.next()));
    }
}
