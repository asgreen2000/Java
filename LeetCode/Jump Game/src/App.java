class Solution {
    public boolean canJump(int[] nums) {
        
        int canJumpFromZero [] = new int[nums.length];

        canJumpFromZero[0] = 1;

        for (int i = 1; i < nums.length - 1; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (canJumpFromZero[j] == 1 && nums[j] + j >= i)
                {
                    canJumpFromZero[i] = 1;
                    break;
                }
            }
        }

        for (int i = 0 ; i < nums.length - 1; i++)
        {
            if (canJumpFromZero[i] == 1 && nums[i] + i >= (nums.length - 1))
                return true;
        }

        return false;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
