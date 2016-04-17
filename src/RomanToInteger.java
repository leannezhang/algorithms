package src;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Read more details about roman numerals at Roman Numeric System

 Example :

 Input : "XIV"
 Return : 14
 Input : "XX"
 Output : 20

 * Created by liyangzhang on 2016-04-16.
 */
public class RomanToInteger {
    /**
     *  Note: Roman alphabet is listed in descending order
     **/
    public int romanToInt(String a) {
        int nextInt = 0;
        int sum = 0;
        HashMap<Character, Integer> symbolMap = generateSymbolMap();

        for (int i=0; i < a.length(); i++) {

            int currentInt = symbolMap.get(a.charAt(i));

            // handle subtractive notation such IV = 4 XD= 490
            if ( i < a.length() -1) {
                nextInt = symbolMap.get(a.charAt(i+1));
                // when the next roman is bigger than than the current one
                // it's a substractive notation
                if (nextInt > currentInt) {
                    currentInt = currentInt * -1;
                }
            }

            sum += currentInt;

        }

        return sum;

    }

    public  HashMap<Character, Integer> generateSymbolMap() {
        HashMap<Character, Integer> symbolMap = new HashMap<Character, Integer>();
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);

        return symbolMap;
    }
}
