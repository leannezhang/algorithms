package src.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Created by liyangzhang on 2016-05-27.
 */
public class ValidParentheses {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        // Keys store opening bracket
        // Values store closing bracket
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsKey(current) && i != s.length() - 1) { // meet any opening bracket
                stack.push((Character) current);
            } else { // meet a closing bracket
                if (stack.empty()) {
                    return false;
                }
                Character openBracket = stack.pop();
                if (!map.get(openBracket).equals(current)) {
                    return false;
                }
            }
        }
        return true;
    }

}
