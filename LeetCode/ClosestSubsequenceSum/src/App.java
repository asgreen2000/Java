import java.util.ArrayList;
import java.util.List;

class Solution {

    int goal;
    int [] nums;
    public int minAbsDifference(int[] nums, int goal) {
        
        this.goal = goal;
        this.nums = nums;

        return generateUntil(0, nums.length - 1, new ArrayList<Integer>());
    }

    int generateUntil(int low, int high, List<Integer> list)
    {
        if (low > high || low < 0 || high >= nums.length) {
            return 100000;
        }
        if (low == high) {

            list.add(nums[low]);
            return Math.abs(goal - nums[low]);
        }

        int min = goal;

        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        
        int mid = (high - low) / 2 + low;
        int leftMin = generateUntil(low , mid, left);
        int rightMin = generateUntil(mid+ 1, high, right);

        for (int l: left) {

            for (int r: right) {
                if (list.contains(l + r) == false) {
                list.add(l + r);
                }
                if (list.contains(l) == false) {
                list.add(l);
                }
                if (list.contains(r) == false) {
                list.add(r);
                }
                min = Math.min(min, Math.abs(l + r - goal));
            }

        }
        min = Math.min(min, Math.min(leftMin, rightMin));

        return min;
    }

}


public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        solution.minAbsDifference(new int[] {5,-7,3,5}, 6);
    }
}
