class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int [] count = new int[2]; // keep track occurence of 0 and 1
        int start = 0, end = 0; // two pointer 
        int max = 0;
        
        
        for (; end < nums.length; end++)
        {   
            count[nums[end]]++;
            int windowLength = end - start + 1;

            if (windowLength - count[1] <= k)
            {
                max = windowLength > max ? windowLength : max;
            }
            else {

                count[nums[start]]--;
                start++;
            }
        }

        return max;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        solution.longestOnes(new int[] {0,0,1,1,1,0,0}, 0);
    }
}
