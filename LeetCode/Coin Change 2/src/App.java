public class App {

    static public int change(int amount, int[] coins) {
        
        int [] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i <= amount; i++)
        {
            for (int j = 0; j < coins.length && coins[j] <= i; j++)
            {
                if (dp[i - coins[j]] > 0)
                    dp[i]++;
            }
        }

        dp[0] = 0;
        return dp[amount];
    }

    public static void main(String[] args) throws Exception {
        
        int coins [] = new int[] {1, 2, 5};
        int amount = 5;
        change(amount, coins);
    }
}
