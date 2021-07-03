import java.lang.reflect.Array;
import java.util.Arrays;

public class App {

    public static String longestPalindrome(String s) {

        int maxIndex = 0;
        int [] dp = new int[s.length() + 1];

        for (int i = 2; i<= s.length(); i++)
        {
            Character c = s.charAt(i - 1);

            if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == c)
            {
                dp[i] = dp[i - 1] + 2;
            }

            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }

        return s.substring(maxIndex - dp[maxIndex], maxIndex);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(longestPalindrome("aabaa"));
    }
}
