public class Solution {


    public int jump(int[] nums) {
        
        int jumpToThis[] = new int[nums.length];

        /* start jump from first index of the array */
        jumpToThis[0] = 0; 

        for (int i = 1; i < nums.length; i++)
        {
            for (int j = 0; j < i; j++)
            {   
                if (nums[j] + j >= i) {
                    if (jumpToThis[i] == 0 || jumpToThis[i] < (jumpToThis[j] + 1)) 
                    {
                        jumpToThis[i] = jumpToThis[j] + 1;
                    }
                }
            }
        }
        
        return jumpToThis[nums.length - 1];
    }



    public static void main(String[] args) throws Exception {
        
        
    }
}
