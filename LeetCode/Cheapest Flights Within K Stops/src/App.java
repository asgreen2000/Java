
class Graph
{
    int [][] map;
    int V;
    int min;
    int dst;
    int maxK;
    int [] visited;

    Graph(int [][] matrix, int n)
    {
        this.V = n;
        map = new int[this.V][this.V];

        for (int i = 0; i < n; i++)
        {
            int u = matrix[i][0];
            int v = matrix[i][1];
            int w = matrix[i][2];
            map[u][v] = w;
        }
    }

    int findShortestPath(int src, int dst, int k) {


    }

    void dfs(int u, int k, int totalWeight)
    {   
        if (u == dst)
        {
            this.min = Math.min(this.min, totalWeight);
            return;
        }
        visited[u] = 1;
        k++;
        
        if (k > maxK)
            return;
        
        for (int v = 0; v < this.V; v++)
        {

        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
