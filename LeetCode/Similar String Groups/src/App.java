import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

class StringHanlder
{

    static boolean checkSameGroup(String s1, String s2)
    {
        int count = 0;

        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            
            if (count > 2)
                return false;
        }
        return count == 0 || count == 2;
    }
}

class GrapApp
{
    int [][] matrix;
    String [] strs;
    int n;

    GrapApp(String [] strs)
    {   
        this.n = strs.length;
        setMatrix(strs);
    }
    void setMatrix(String [] strs)
    {
        this.strs = strs;

        matrix = new int[strs.length][strs.length];

        for (int i = 0; i < strs.length; i++)
        {
            for (int j = 0; j < strs.length; j++)
            {
                if (i == j)
                    continue;
                if (StringHanlder.checkSameGroup(strs[i], strs[j]))
                    matrix[i][j] = 1;
            }
        }
    }


    int findNumOfGroup() {

        int count = 0;
        boolean visited[] = new boolean[n];
        
        for (int i = 0; i < n; i++)
        {
            if (visited[i] == false)
            {
                count++;
                dfs(i, visited);
            }
        }
        return count;
    }


    void dfs(int u, boolean [] visited)
    {
        visited[u] = true;

        for (int v = 0; v < n; v++) {

            if (visited[v] == false && matrix[u][v] == 1)
            {
                dfs(v, visited);
            }
        }
    }
}



class Solution {
    public int numSimilarGroups(String[] strs) {
        
        GrapApp grapApp = new GrapApp(strs);

        return grapApp.findNumOfGroup();
    }
}


public class App extends TestCase{
    public static void main(String[] args) throws Exception {
        String [] strs = {"omv","ovm"};
        Solution solution = new Solution();
        int answer = solution.numSimilarGroups(strs);

        System.out.println(answer);
    }

    @Test
    public void test() {

        String [] strs = {"omv","ovm"};
        Solution solution = new Solution();
        int answer = solution.numSimilarGroups(strs);

        assertEquals(answer, 1);
    }
}
