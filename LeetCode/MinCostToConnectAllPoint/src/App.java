import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

import jdk.jfr.Timestamp;

class Solution {
    
    int key[];
    int p[];
    int visited[];
    int matrix[][];
    int V;

    int extractMin()
    {
        int minIndex = V;

        for (int i = 0; i < V; i++) {

            if (visited[i] == 0 && key[i] < key[minIndex])
                minIndex = i;
        }

        return minIndex;
    }
    
    public int minCostConnectPoints(int[][] points) {

        int cost = 0;
        
        V = points.length;
        key = new int[V + 1];
        Arrays.fill(key, 1000000000);
       
        p = new int[V];
        matrix = new int[V][V];
        visited = new int[V];
        key[0] = 0;
        p[0] = 0;

        for (int i = 0; i < points.length; i++)
        {
            int x1 = points[i][0], y1 = points[i][1];

            for (int j = 0; j < points.length; j++)
            {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                matrix[i][j] = dist;
                matrix[j][i] = dist;
            }
        }
        
        int u = 0;
        do 
        {
            cost += matrix[u][p[u]];
            visited[u] = 1;

            for (int v = 0; v < V; v++)
            {
                if (visited[v] == 0 && matrix[u][v] < key[v])
                {
                    p[v] = u;
                    key[v] = matrix[u][v];
                }
            }
            u = extractMin();
        }  while (u != V);
        
        return cost;

    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
    }

    @Test
    public void test() {

        int points[][] = {{-1000000,-1000000},{1000000,1000000}};

        Solution solution = new Solution();
        

        assertEquals(4000000, solution.minCostConnectPoints(points));
    }
}
