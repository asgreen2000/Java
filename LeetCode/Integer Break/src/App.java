
class Solution {
    public int integerBreak(int n) {
        
        int [] dp = new int[n + 1];
        
        dp[0] = 1;

        for (int i = 1; i <= n; i++)
        {   
            for (int j = 1; j <= i; j++)
            {
                dp[i] = Math.max(dp[i], dp[i - j] * j);    
            }
        }

        return dp[n];
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
