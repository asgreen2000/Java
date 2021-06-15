import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


class Solution {
    public int numSubseq(int[] nums, int target) {
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        int start = 0, end = 0;

        for (; end < nums.length; end++)
        {
            hashMap.put(nums[end], hashMap.getOrDefault(nums[end], 0) + 1);

            int maxKey = Collections.max(hashMap.keySet());
            int minKey = Collections.min(hashMap.keySet());

            while (start <= end && maxKey + minKey > target)
            {
                hashMap.put(nums[start], hashMap.getOrDefault(nums[start], 0) - 1);
                if (hashMap.getOrDefault(nums[start], 0) == 0) {
                    hashMap.remove(nums[start]);
                }
                if (hashMap.isEmpty() == true)
                    break;
                maxKey = Collections.max(hashMap.keySet());
                minKey = Collections.min(hashMap.keySet());
                start++;
            }

            if (start <= end && !hashMap.isEmpty())
                count++;
        }

        return count;
    }

    void countUntil(int [] coins, int amount, int index, int current)
    {
        if (amount == 0)
        {
            count = current < count ? current : count;
            return;
        }
        if (amount < 0 || index < 0 || current >= count)
            return;
        
        countUntil(coins, amount - coins[index], index, current + 1);
        countUntil(coins, amount - coins[index], index - 1, current + 1);
        countUntil(coins, amount, index - 1, current);
    }


}


public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        solution.numSubseq(new int[] {3, 3, 6, 8}, 10);
        
    }
}
