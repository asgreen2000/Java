import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        
        int [] count = new int[s.length() + 1];
        int max = 0;

        for (int i = 2; i <= s.length(); i++)
        {
            Character c = s.charAt(i - 1);

            if (c == '(')
                count[i] = 0;
            else if (c == ')') {

                if (s.charAt(i - 2) == '(')
                {   
                    /*Example: ()(c*/
                    count[i] = count[i - 2] + 2;
                }
                else if (i - count[i - 1] - 2 >= 0 && s.charAt(i - count[i - 1] - 2) == '(') {
                    
                    /*Example: ()(()c*/
                    count[i] = count[i - 1] + 2 + count[i - count[i - 1] - 2];
                }

            }

            max = Math.max(max, count[i]);
        }

        return max;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        System.out.print(solution.longestValidParentheses("()(())"));
    }
}
