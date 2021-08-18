
class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        
        if (sum % 2 != 0)
            return false;
        
        return equalSum(nums, sum / 2);
    }
    
    public boolean equalSum(int [] nums, int target) {
        
        int dp [] = new int[target + 1];
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = target; j >= 0 && nums[i] <= j; j--)
            {   
                if (dp[j - nums[i]] > 0 || j == nums[i])
                    dp[j] = 1;
            }
        }

        return dp[target] > 0;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
