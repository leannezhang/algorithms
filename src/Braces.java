package src;

import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces?
 Return 0/1
 0 -> NO 1 -> YES

 Input will be always a valid expression

 and operators allowed are only + , * , - , /

 Example:

 ((a+b)) has redundant braces so answer will be 1
 (a + (a + b)) doesn't have have any redundant braces so answer will be 0


 * Hint: Solve by finding the subexpression. A valid subexpression has an operator and a letter
 * Note: (a) and (a*(b)) are consider redundant braces
 * Created by liyangzhang on 2016-05-29.
 */
public class Braces {


    public static int braces(String a) {

        Stack<Character> stack = new Stack<Character>();
        boolean operator = false;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) != ')') {
                stack.push(a.charAt(i));
            }
            // reach ')'
            else {
                if (stack.peek().equals('(')) {
                    return 1;
                } else {
                    Character c = stack.pop();
                    while (!c.equals('(')) {
                        if (c.equals('+') || c.equals('*') || c.equals('-') || c.equals('/')) {
                            operator = true;
                        }
                        c = stack.pop();
                    }
                    if (!operator) {
                        return 1;
                    }
                    operator = false;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(braces("(a*b)+(b*(d+(a)))"));
        System.out.println(braces("((a*b))"));
        System.out.println(braces("((a+b)*c)"));
    }

}
