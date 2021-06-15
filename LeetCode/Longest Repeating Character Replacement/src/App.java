
class Solution {

    private int extractMax(int [] count)
    {
        int maxIndex = 0;

        for (int i = 1; i < 26; i++) {

            maxIndex = count[i] > count[maxIndex] ? i : maxIndex;
        }

        return count[maxIndex];
    }
    public int characterReplacement(String s, int k) {
        
        int max = 1;

        int [] count = new int[26];

        int start = 0, end = 0;

        count[s.charAt(end) - 'A'] += 1;

        while (start <= end && end < s.length())
        {
            int windowLength = end - start + 1;
            int maxOccur = extractMax(count);

            if (windowLength - maxOccur <= k) // valid 
            {
                max = windowLength > max ? windowLength : max;
                end++;

                if (end < s.length()) {

                    count[s.charAt(end) - 'A']++;
                }
            }
            else {

                count[s.charAt(start) - 'A']--;
                start++;
            }
        }

        return max;
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();

        solution.characterReplacement("ABAB", 2);

    }
}
