import java.util.ArrayList;
import java.util.List;

class Solution {

    int maxOnRight[];
    List<List<Integer>> ansList = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        

    }

    void dfs(int i, int nums[], List<Integer> list)
    {
        if (i >= nums.length && list.size() == 0)
            return;
        if (i >= nums.length && list.size() > 0) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        if (maxOnRight[i] == 0)
        {
            if (list.size() > 0)
                ansList.add(new ArrayList<>(list));
            return;
        }

        

    }   

}

void knapSack()
{
    int size[] = {2, 3, 4, 1};
    int val[] = {5, 7, 8, 2};
    int M = 8;
    int dp[][] = new int[M + 1][size.length + 1];

    for (int i = 0; i <= M; i++)
        dp[i][0] = 0;
    
    

    System.out.println(dp[M]);

}
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
