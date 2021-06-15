
import java.util.ArrayList;
import java.util.List;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class App {

    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> listUntil = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            
            permuteUntil(nums, listUntil, 0, i + 1);
        }
        return this.list;
    }

    private void permuteUntil(int [] nums, List<Integer> list, int pos, int k)
    {
        if (list.size() == k) 
        {   
            List<Integer> newList = new ArrayList<Integer>(list);
            this.list.add(newList);
        }
        else if (pos >= nums.length)
        {
            return;
        }
        else {

            for (int i = 0; i <= list.size() ; i++)
            {
                list.add(i, nums[pos]);
                permuteUntil(nums, list, pos + 1, k);
                list.remove(i);
            }

        }
    }
    public static void main(String[] args) throws Exception {
        
        App app = new App();
        int [] arr = {0, 1};
        app.permute(arr);
        
    }



}
