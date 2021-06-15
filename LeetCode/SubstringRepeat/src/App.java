import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Solution {

    int k;
    public int longestSubstring(String s, int k) {
        
        this.k = k;

        return divideUntil(s);
    }

    public int divideUntil(String s) {

        int [] hash = new int[28];

        for (int i = 0; i < s.length(); i++) {

            hash[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {

            if (hash[s.charAt(i) - 'a'] < k) {

                return Math.max(divideUntil(s.substring(0, i)), divideUntil(s.substring(i + 1)));
            }
        }

        return s.length();
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        
        
    }

    @Test
    public void test() {

        assertEquals(3, (new Solution()).longestSubstring("aaabb", 3));

    }

}
