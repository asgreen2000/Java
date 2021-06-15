import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class GenerateSubset extends Thread
{
    int sizeSubset;
    int [] nums;
    List<List<Integer>> listSubset = new ArrayList<List<Integer>>();

    GenerateSubset(int [] nums, int sizeSubset) {

        this.sizeSubset = sizeSubset;
        this.nums = nums;
    }

    void subsetUntil(int index, List<Integer> list) {
        
        if (list.size() == this.sizeSubset)
        {
            this.listSubset.add(new ArrayList<Integer>(list));
            return;
        }
        if (index >= nums.length || list.size() > sizeSubset)
            return;
        
        list.add(nums[index++]);
        subsetUntil(index, list);
        list.remove(list.size() - 1);
        subsetUntil(index, list);
    }


    public void run() {

        subsetUntil(0, new ArrayList<Integer>());
    }

}

class Permutation extends Thread
{   
    
    void generatePermutation()
}
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> result = new ArrayList<Integer>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        long start = System.currentTimeMillis();
        list.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        GenerateSubset [] threadList = new GenerateSubset[nums.length];

        for (int i = 0; i < nums.length; i++) {

            threadList[i] = new GenerateSubset(nums, i + 1);
            threadList[i].start();
        }
        long start_ = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            try {
            threadList[i].join();
            }
            catch (InterruptedException e) {}
            List<List<Integer>> threadAns = threadList[i].listSubset;
            this.list.addAll(threadAns);
        }
        long end = System.currentTimeMillis();
        System.out.println( Double.toString(end - start_)  + Double.toString(end - start));
        return list.stream().distinct().collect(Collectors.toList());
    }

    

    public static void main(String[] args) {
       
        Solution solution = new Solution();

        List<List<Integer>> lst = solution.subsetsWithDup(new int[] {1, 2, 2});
        GenerateSubset g = new GenerateSubset(new int[] {1, 2, 3}, 3);

        g.subsetUntil(0, new ArrayList<Integer>());
    }
}