package Concept;

/**
 * Created by liyangzhang on 2016-04-03.
 */
public class MutableObject {

    public static void main(String[] args){
        String firstString = new String("hello");
        System.out.println(firstString + System.identityHashCode(firstString));

        String secondString = firstString;
        System.out.println(secondString  + System.identityHashCode(secondString));

        firstString = "liyang";
        System.out.println(firstString  + System.identityHashCode(firstString));
        System.out.println(secondString + System.identityHashCode(secondString));
    }

}
