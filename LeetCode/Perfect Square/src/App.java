public class App {


    private final int LIMIT = 100000;

    public int numSquares(int n) {
        
        int dp[] = new int[n + 1];
    
        dp[1] = 1;
        dp[0] = 0;

        for (int i = 2; i <= n; i++)
        {   
            dp[i] = LIMIT;
            for (int j = 1; j <= i && j * j <= i ; j++)
            {   
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }   
        }

        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        
            
    }
}
