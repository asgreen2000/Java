import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Graph {

    int [][] matrix;
    int V;

    Graph(int [][] graph)
    {
        this.matrix = graph;
        this.V = matrix.length;
    }

    boolean CheckValidBipartiteGraph() {

        /* transform this problem to graph coloring problem 
            2 color
        */
        int color [] = new int[V]; 
        Arrays.fill(color, -1); // mark all vertex as not colored yet        

        Queue<Integer> queue = new LinkedList<>();
        
        int start = findStartVertex();

        if (start == -1)
            return true;

        queue.add(start);
        color[start] = 1;

        while (!queue.isEmpty())
        {
            int u = queue.remove();

            for (int v : matrix[u])
            {
                if (u == v) // self loop
                    return false;
                if (color[v] == -1) {
                    color[v] = 1- color[u];
                    queue.add(v);
                }
                else if (color[v] == color[u])
                    return false;
            }
        }

        return true;
    }

    int findStartVertex() {

        for (int u = 0; u < V; u++)
            if (matrix[u].length > 0)
                return u;
        return -1;
    }
}


class Solution {
    public boolean isBipartite(int[][] graph) {
        
        Graph graph_ = new Graph(graph);


        return graph_.CheckValidBipartiteGraph();
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
