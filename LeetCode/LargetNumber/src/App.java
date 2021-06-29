import java.util.Arrays;
import java.util.Comparator;

class Solution {

    static int getFirstDigit(int n)
    {   

        while(n / 10 > 0)
        {
            n = n / 10;
        }

        return n;
    }
    static public String largestNumber(int[] nums) {
        
        Integer [] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                
                int first = getFirstDigit(o1);
                int second = getFirstDigit(o2);

                if (first != second)
                    return second - first;
                int p1 = (Integer.toString(o1)).length();
                int p2= (Integer.toString(o2)).length();

                return (int) ((o2 * Math.pow(10, p1)+ o1) - (o1 * Math.pow(10, p2)+ o2));
            } 
        });



        return arrayToString(newNums);
    }

    static String arrayToString(Integer [] nums)
    {
        String ans = "";
        for (Integer num : nums) {
            if (ans == "" && num == 0)
                continue;
            ans += Integer.toString(num);
        }
        return ans != "" ? ans : "0";
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(Solution.largestNumber(new int[] {3,30,34,5,9});
    }
}
