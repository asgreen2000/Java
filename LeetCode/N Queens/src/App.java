import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    boolean cols[];
    boolean a[];
    boolean b[];
    int x[];
    int n;

    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> list = new ArrayList<>();

        this.n = n;
        cols = new boolean[n];
        a = new boolean[n];
        b = new boolean[n];
        x = new int[n];
        Arrays.fill(x, -1);

        solveUntil(0);

        

        return list;
    }

    boolean solveUntil(int i)
    {
        for (int j = 0; j < n; j++)
        {
            if (!a[i + j] && !b[Math.abs(i - j)] && !cols[j])
            {
                x[i] = j;
                a[i + j] = true;
                b[Math.abs(i - j)] = true;
                cols[j] = true;

                if (solveUntil(i + 1))
                    return true;
                x[i] = -1;
                a[i + j] = false;
                b[Math.abs(i - j)] = false;
                cols[j] = false;
            }
        }
        return false;
    }

}


public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.
    }
}
