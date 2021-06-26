
class Solution {

    boolean isPalin(String s) {

        int n = s.length();

        for (int i = 0; i < (n >> 1); i++)
        {
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        }

        return true;
    }
    public int minCut(String s) {
        
        int n = s.length();
        int dp [] = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++)
        {   
            dp[i] = 10000;
            for (int j = 0; j < i; j++)
            {
                if (isPalin(s.substring(j, i)))
                {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n] - 1;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        System.out.println(solution.minCut("11211"));
    }
}
