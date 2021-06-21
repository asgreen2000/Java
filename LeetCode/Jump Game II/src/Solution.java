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

    public int obtimizeJump(int[] nums) {
        
        int maxCanReach[] = new int[nums.length];

        /* start jump from first index of the array */
        maxCanReach[0] = nums[0]; 

        for (int i = 1; i < nums.length; i++) {

            maxCanReach[i] = Math.max(maxCanReach[i], maxCanReach[i - 1] - 1);

        }

        int pos = maxCanReach[0];
        int count = 0;

        while (pos < nums.length - 1)
        {   
            if (maxCanReach[pos] == 0)
                return -1;
            pos += maxCanReach[pos];
            count++;
        }

        return count;
    }




    public static void main(String[] args) throws Exception {
        
        
    }
}
