import java.util.TreeMap;

class Solution {


    public int longestSubarray(int[] nums, int limit) {
        
        int maxLen = 0;

        int start = 0, end = 0;

        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        for(;end < nums.length; end++)
        {
            treeMap.put(nums[end], treeMap.getOrDefault(nums[end], 0) + 1);

            int minimum = treeMap.firstKey();
            int maximum = treeMap.lastKey();

            if (maximum - minimum <= limit)
            {

                maxLen = Math.min(maxLen, end - start + 1);
            } else {

                while (start < end)
                {
                    treeMap.put(nums[start], treeMap.get(nums[start]) - 1);

                    if (treeMap.get(nums[start]) == 0)
                    {
                        treeMap.remove(nums[start]);
                    }

                    start++;

                    minimum = treeMap.firstKey();
                    maximum = treeMap.lastKey();

                    if (maximum - minimum <= limit)
                        break;
                }

            }


        }

        return maxLen;
    }

}



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
