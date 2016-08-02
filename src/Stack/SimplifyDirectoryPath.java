package Stack;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

 Examples:

 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 Note that absolute path always begin with ‘/’ ( root directory )
 Path will not have whitespace characters.

 * Created by liyangzhang on 2016-05-28.
 */

public class SimplifyDirectoryPath {


    public static String simplifyPath(String a) {
        Stack<String> stack = new Stack<String>();
        String[] tokens = a.split("/");
        for (int i=0; i <tokens.length; i++) {
            if (tokens[i].equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (tokens[i].equals(".") || tokens[i].equals("")){
                continue;
            } else {
                stack.push(tokens[i]);
            }
        }
        StringBuilder simplified = new StringBuilder();
        while (!stack.empty()) {
            simplified.insert(0, "/" + stack.pop());
        }
        if (simplified.toString().equals("")) {
            return "/";
        }
        return simplified.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
}
