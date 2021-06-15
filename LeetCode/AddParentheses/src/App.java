import java.util.ArrayList;
import java.util.List;

class Operator {

    static boolean isOperator(char op) {

        return op == '+' || op == '-' || op == '*' || op == '/';
    }
}


class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        
        return computeUntil(expression);
    }

    private List<Integer> computeUntil(String exp)
    {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < exp.length(); i++)
        {

            char c = exp.charAt(i);

            if (Operator.isOperator(c))
            {
                List<Integer> left = computeUntil(exp.substring(0, i));
                List<Integer> right = computeUntil(exp.substring(i + 1));
                
                for(int lValue: left)
                {   
                    for(int rValue: right)
                    {
                        switch(c)
                        {
                            case '+': result.add(lValue + rValue);
                                    break;
                            case '-': result.add(lValue - rValue);
                                    break;
                            case '*': result.add(lValue * rValue);
                                    break;

                        }

                    }

                }



            }
        }

        if (result.size() == 0)
        {
            result.add(Integer.valueOf(exp));
        }
        return result;
    }

}






public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        solution.diffWaysToCompute("2-1-1");
    }
}
