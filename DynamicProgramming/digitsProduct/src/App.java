public class App {

    static int digitsProduct(int product) {

        if (product == 1)
            return 1;
        int dp[] = new int[product + 2];
    
        dp[0] = 10;
        dp[1] = 0;
        for (int i = 2; i <= product; i++)
        {   
            dp[i] = 100000;
            for (int j = 2; j <= 9 && j <= i; j++)
            {   
                if (i % j == 0)
                    dp[i] = Math.min(dp[i], dp[i / j] * 10 + j);
            }
        }
    
        return dp[product] != 100000 ? dp[product] : -1;
    }

    public static void main(String[] args) throws Exception {
        
        System.out.println(digitsProduct(0));
    }
}
