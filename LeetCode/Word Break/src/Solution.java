import java.util.List;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        
        int [] dp = new int[s.length() + 1];



        
        dp[0] = 1; // empty string is always valid

        for (int i = 1; i <= s.length(); i++)
        {
            for (String word : wordDict) {

                int size = word.length();

                if (size <= i && dp[i - size] == 1 && word.equals(s.substring(i - size, i)))
                {
                    dp[i] = 1;
                }
            }

        }

        return dp[s.length()] > 0 ? true : false;
    }

    public static void main(String[] args) throws Exception {
        


    }
}
