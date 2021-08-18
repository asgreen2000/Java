import java.util.ArrayList;
import java.util.List;

class Graph
{
    double matrix[][];
    int nodes;
    int visited[];
    double maxOnThis[];

    public Graph(int [][] edges, double[] succProb, int n)
    {
        this.nodes = n;
        setAdjList(edges, succProb);
    }

    void setAdjList(int [][]edges, double[] succProb)
    {
        visited = new int[nodes];
        maxOnThis = new double[nodes];
        int i = 0;
        for (double prob : succProb) {
            int u = edges[i][0];
            int v = edges[i][1];
            i++;
            matrix[u][v] = matrix[v][u] = prob;
        }
    }


    double getMaxProbPath(int start, int end)
    {
        dfs(start, 1, 0);
        return maxOnThis[end];
    }

    void dfs(int u, double prob, int i) {

        if (prob <= maxOnThis[u])
            return;
        if (i > 0)
            maxOnThis[u] = prob;
        for (int v = 0; v < nodes; v++)
            if (matrix[u][v] > 0)
                dfs(v, prob * matrix[u][v], i + 1);
    }
}



public class Solution {

    static public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        Graph graph = new Graph(edges, succProb, n);
        return graph.getMaxProbPath(start, end);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
