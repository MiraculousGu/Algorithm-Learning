import java.util.Stack;

public class StackImplementation {

    public static String reverseString(String str){
        StringBuffer result = new StringBuffer();   //use StringBuffer to avoid memory waste of immutable strings

        //create character stacks to store characters
        Stack<Character> stack = new Stack<>();

        //push characters by oder to the stack
        for (char c: str.toCharArray())
            stack.push(c);

        //reverse pop out
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }



}
