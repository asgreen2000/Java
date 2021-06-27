import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
         
        

         for (int i = 1; i <= s.length(); i++)
         {
             for (String word : wordDict) {
 
                 int size = word.length();
                 if (size <= i && dp[i - size].size() > 0 && word.equals(s.substring(i - size, i)))
                 {
                     dp[i] = 1;
                 }
             }
 
         }
 
         return dp[s.length()];
     }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
