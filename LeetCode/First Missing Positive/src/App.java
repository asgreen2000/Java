

public class App {

    static public int firstMissingPositive(int[] nums) {
        
        int min = 1;
        int hash[] = new int[1048576];
        
        for (int i = 0; i < nums.length; i++)
        {   
            if (nums[i] > 0)
                hash[nums[i] % 1048576] = 1;
            if (hash[min] == 1)
            {
                min++;
            }
        }
        
        while(hash[min] == 1)
        {
                min++;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        firstMissingPositive(new int[] {1,2,6,3,5,4});
    }
}
