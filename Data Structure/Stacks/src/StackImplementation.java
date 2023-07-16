import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackImplementation {

    private static final List<Character> left = Arrays.asList('(','[','<','{');
    private static final List<Character> right = Arrays.asList(')',']','>','}');

    public static String reverseString(String str){
        if (str == null)
            throw new IllegalArgumentException("The input is null");
        
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

    public static Boolean isBalancedExpression(String str){
        if (str == null)
            throw new IllegalArgumentException("The input is null");

        //create a stack to store characters
        Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray()){
            if ((isLeftBracket(c)))
                stack.push(c);

            if (isRightBracket(c)){
                if (stack.isEmpty()) return false;
                var top = stack.pop();
                if (!BracketMatched(c,top)) return false;
            }
        }

        return stack.isEmpty();
    }

    private static Boolean isLeftBracket(char c){
        return left.contains(c);
    }

    private static Boolean isRightBracket(char c){
        return right.contains(c);
    }

    private static Boolean BracketMatched(char l, char r){
        return left.indexOf(l) == right.indexOf(r);
    }

}
