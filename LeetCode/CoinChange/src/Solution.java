import java.util.Arrays;

public class Solution {

    private final int MAX_INT = 10000000;
    public int coinChange(int[] coins, int amount) {
        
        Arrays.sort(coins);
        int n = coins.length;
        int [] coinCount = new int[amount + 1];
        coinCount[0] = 0;

        for (int i = 1; i <= amount; i++)
        {   
            /* find minimum number of coin which has total amount
            equalling to current amount*/
            int minCount = MAX_INT; 
            
            for (int j = 0; j < n && coins[j] <= i; j++)
                minCount = Math.min(minCount, coinCount[i - coins[j]]);
            coinCount[i] = minCount + 1;
        }

        return coinCount[amount] < MAX_INT ? coinCount[amount] : -1;
        }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
