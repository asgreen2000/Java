import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            Character c = s.charAt(i);

            if (c == '(' || c == '*')
                stack.push(c);
            else if (c == ')' && stack.empty())
                return false;
            else if (c == ')' && (stack.peek() == '(' || stack.peek() == '*'))
                stack.pop();
            else if (c == ')' && stack.peek() == ')')
                return false;
        }

        return stack.empty();
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
