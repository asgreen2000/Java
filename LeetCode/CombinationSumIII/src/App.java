import java.util.ArrayList;
import java.util.List;

class Solution {

    private int target;
    private int limitNumber;
    private List<List<Integer>> lst = new ArrayList<List<Integer>>();
    private List<Integer> iteratorList = new ArrayList<Integer>();
    void setAttribute(int k, int n)
    {
        this.target = n;
        this.limitNumber = k;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        this.setAttribute(k, n);

        
        this.combineUntil(1, 0);

        return this.lst;
    }
    
    void combineUntil(int num, int curSum)
    {
        if (iteratorList.size() == this.limitNumber)
        {   
            if (curSum == this.target) {
                List<Integer> newList = new ArrayList<Integer>(iteratorList);
                lst.add(newList);
            }
        } else if(num > 9) {

            return;
        } else {

            this.iteratorList.add(num);
            combineUntil(num + 1, curSum + num);
            this.iteratorList.remove(iteratorList.size() - 1);
            combineUntil(num + 1, curSum);
        }

    }

}

public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        solution.combinationSum3(3, 7);
    }
}
