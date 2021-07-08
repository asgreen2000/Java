public class App {

    static public int longestPalindromeSubseq(String s) {
        
        int count[] = new int[s.length() + 1];

        count[0] = 0;
        int max = 1;
        count[1] = 1;
        
        for (int i = 2; i <= s.length(); i++)
        {   
            count[i] = 1;
            
            for (int j = 0; j < i; j++)
            {
                

            }

            max = count[i] > max ? count[i] : max;
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
