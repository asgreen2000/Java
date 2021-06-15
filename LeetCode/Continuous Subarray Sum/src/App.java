class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int [][] dp = new int[2][n + 1];

        for (int i = 0; i <= n; i++)
        {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = i; j <= n; j++)
            {
                dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + nums[j - 1];

                if (i >= 2 && dp[i % 2][j] % k ==0)
                    return true;
            }
        }

        return false;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
