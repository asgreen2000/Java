public class Solution {

    static public String countAndSay(int n) {
        
        if (n == 1)
        {
            return "1";
        }

        String res = countAndSay(n - 1);

        String ans = "";

        int count = 1;
        Character prevChar = res.charAt(0);
        int i = 1;
        for (; i < res.length(); i++)
        {
            if (res.charAt(i) != prevChar)
            {
                ans += String.valueOf(count) + prevChar;
                count = 1;
                prevChar = res.charAt(i);
            }
            else {
                count++;
            }
        }

        if (count > 0)
        {
            ans += String.valueOf(count) + prevChar;
        }

        return ans;
    }
    public static void main(String[] args) {
        
        countAndSay(4);
    }
}