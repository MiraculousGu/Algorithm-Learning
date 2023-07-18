public class Test {
    public static void main(String[] args) {

        System.out.println("Test Reverse String");
        System.out.println(StackImplementation.reverseString("abcde"));

        System.out.println("Test if the input is a balanced expression");
        System.out.println(StackImplementation.isBalancedExpression("()1[2](){"));

        System.out.println("Test Array Stack");
        ArrayStack stack = new ArrayStack();

        System.out.println("Test push");
        stack.push(10);
        stack.push(20);
        stack.push(50);
        System.out.println(stack);

        System.out.println("Test peek");
        System.out.println(stack.peek());

        System.out.println("Test pop");
        stack.pop();
        System.out.println(stack);
    }
}
