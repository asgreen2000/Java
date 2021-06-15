import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return subarraysWithKAtMostDistinct(nums, k) - subarraysWithKAtMostDistinct(nums, k - 1);
    }

    int subarraysWithKAtMostDistinct(int [] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int start = 0, end = 0;
        int ans = 0;
        for (; end < nums.length; end++)
        {
            int count = hashMap.getOrDefault(nums[end], 0);
            hashMap.put(nums[end], count + 1);

            while (start <= end && hashMap.size() > k){

                int countStart = hashMap.get(nums[start]);
                if (countStart == 1) {

                    hashMap.remove(nums[start++]);
                }
                else {
                    hashMap.put(nums[start++], countStart - 1);
                }
            }
            ans += (end - start + 1);
        }

        return ans;

    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        solution.subarraysWithKDistinct(new int[] {1, 2, 1, 2, 3}, 2);
    }
}
