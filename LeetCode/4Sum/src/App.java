import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

class Solution {

    List<List<Integer>> fourSumList = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    int target;
    HashSet<List<Integer>> hash = new HashSet<List<Integer>>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);

        this.target = target;

        generateUntil(nums, 0, 0);

        return fourSumList;
    }

    void generateUntil(int [] nums, int pos, int sum)
    {
        if (list.size() == 4)
        {   
            if (sum == target && !hash.contains(list)) {

                hash.add(list);
                fourSumList.add(new ArrayList<Integer> (list));
            }
            return;
        }

        if (pos >= nums.length)
        {
            return;
        }

        list.add(nums[pos]);
        generateUntil(nums, pos + 1, sum + nums[pos]);
        list.remove(list.size() - 1);
        generateUntil(nums, pos + 1, sum);

    }

}


public class App {
    public static void main(String[] args) throws Exception {
        
    }

    @Test
    public void test() {

        Solution solution = new Solution();
        List<List<Integer>> fourSumList = solution.fourSum(new int []{1, 0, -1, 0, -2, 2}, 0);
        
        assertArrayEquals(fourSumList.toArray(), new int[][] {{-2,-1,1,2},{-2,0,0,2},{-1,0,0,1}});
    }
}
