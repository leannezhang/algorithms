package CodeReview;

/**
 * Created by liyangzhang on 2016-06-04.
 */

/**
 * This program is just a simple addition calculator that can use whole numbers or decimals.
 *
 * @author Christopher Goodburn
 * @version 6/4/2016
 */
import java.util.Scanner;

public class Calculator
{
    private static final Scanner askScanner = new Scanner(System.in);
    public static double answer;
    public static double firstNumber;
    public static double secondNumber; //makes variables for the whole class

    public static void main(String[] args) {
        calculator();
    }

    public static void calculator() {

        System.out.println("Basic calculator");
        System.out.println("Pick one:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int pick = askScanner.nextInt();

        if(pick == 1) {
            addition();
        }
        else if(pick == 2) {
            subtraction();
        }
        else if(pick == 3) {
            multiplication();
        }
        else if(pick == 4) {
            division();
        }
        else {
            System.out.println("You need to choose 1, 2, 3, or 4");
            calculator();
        }
        askScanner.close();
    }

    private static double getNumbers() {
        System.out.println("First number?");
        firstNumber = askScanner.nextDouble();
        System.out.println("Second Number?");
        secondNumber = askScanner.nextDouble();
        return firstNumber;
    }

    public static void subtraction() {
        System.out.println("Subtraction");
        getNumbers();
        answer = firstNumber - secondNumber;
        System.out.println("This is the difference of the two numbers:  " + answer);
        calculator();
    }

    public static void addition() {
        System.out.println("Addition");
        getNumbers();
        answer = firstNumber + secondNumber;
        System.out.println("This is the sum of the two numbers:  " + answer);
        calculator();
    }

    public static void multiplication() {
        System.out.println("Multiplication");
        getNumbers();
        answer = firstNumber * secondNumber;
        System.out.println("This is the product of the two numbers  " + answer);
        calculator();
    }

    public static void division() {
        System.out.println("Division");
        getNumbers();
        answer = firstNumber / secondNumber;
        System.out.println("This is the quotient of the two numbers:    " + answer);
        calculator();
    }

}