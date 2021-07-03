public class App {

    static public int longestPalindromeSubseq(String s) {
        
        int count[] = new int[s.length() + 1];

        count[0] = 1;
        int max = 1;

        for (int i = 1; i < s.length(); i++)
        {   
            count[i] = 1;
            
            for (int j = 0; j < i; j++)
            {
                if (s.charAt(j - count[j] + 1) == s.charAt(i)) {

                    count[i] = Math.max(count[i], count[j] + 2);
                }
            }

            max = count[i] > max ? count[i] : max;
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
