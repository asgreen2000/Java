
class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        

        int [][] dp = new int[n + 1][11];

        for (int i = 0; i < 11; i++)
        {
            dp[0][i] = 0;
        }

        for (int i = 0; i < n; i++)
        {
            dp[i][0] = 0;
        }

        int [] pow = new int[n];
        pow[0] = 1;
        
        for (int i = 1; i < n; i++)
        {
            pow[i] =pow[i - 1] + (int) Math.pow(10, i);
        }

        for (int i = 1; i < n; i++)
        {   
            int sum = 0;
            for (int j = 1; j < 10; j++)
            {
                dp[i][j] = dp[i - 1][10] + pow[i - 1];
                sum += dp[i][j];
            }
            dp[i][10] = sum;
        }
        
        return (int) Math.pow(10, n) - dp[n - 1][10];
    }

    
}



public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        solution.countNumbersWithUniqueDigits(3);
    }
}
