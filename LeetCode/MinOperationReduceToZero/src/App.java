class Solution {

    public int minOperations(int[] nums, int x) {
        
        int start = 0, end = 0;
        int totalSum = 0;

        for (int i : nums) {
            
            totalSum += i;
        }

        int maxLen = 0;
        int sum = 0;
        int need = totalSum - x;

        for (; start < nums.length; start++)
        {   
            sum += nums[end];

            while (start < end && sum > need)
            {
                sum -= nums[start++];
            }

            int windowLength = end - start + 1;
            if (sum == need)
            {
                maxLen = windowLength > maxLen ? windowLength : maxLen;
            }
        }

        return maxLen > 0 ? (nums.length - maxLen) : -1;
    }


}


public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();

        System.out.println(solution.minOperations(new int[] {3,2,20,1,1,3 }, 10));
    }
}
