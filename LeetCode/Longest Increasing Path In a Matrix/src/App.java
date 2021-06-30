import java.util.ArrayList;
import java.util.List;





class Graph
{
    class Vertex {

        int key;
        int val;
        int maxCount = 1;
        boolean visited = false;
        Vertex(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private List<List<Vertex>> adjList = new ArrayList<List<Vertex>>();
    int vertexs;
    int maxCount = 0;
    private Vertex [] vertexList;

    void createAdjList(int i, int j, int [][] matrix)
    {   
        int m = matrix.length;
        int n = matrix[0].length;

        int cellIndex = i * n + j;

        if (vertexList[cellIndex] == null)
            vertexList[cellIndex] = new Vertex(cellIndex, matrix[i][j]);

        int left = cellIndex - 1;
        int right = cellIndex + 1;
        int up = (i - 1) * n + j;
        int down = (i + 1) * n + j;
        List<Vertex> list = new ArrayList<>();

        if (left >= 0 && left < m * n && j > 0)
        {
            if (vertexList[left] == null)
                vertexList[left] = new Vertex(left, matrix[i][j - 1]);
            list.add(vertexList[left]);
        }

        if (right >=0 && right < m * n && j < (n - 1))
        {
            if (vertexList[right] == null)
                vertexList[right] = new Vertex(right, matrix[i][j + 1]);
            list.add(vertexList[right]);
        }
        if (up >= 0 && up < m * n && i > 0)
        {
            if (vertexList[up] == null)
                vertexList[up] = new Vertex(up, matrix[i - 1][j]);
            list.add(vertexList[up]);
        }
        if (down >= 0 && down < m * n && i < (m - 1))
        {
            if (vertexList[down] == null)
                vertexList[down] = new Vertex(down, matrix[i + 1][j]);
            list.add(vertexList[down]);
        }
        adjList.add(list);
    }
    
    Graph(int [][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        this.vertexs = m * n;

        vertexList = new Vertex[m * n];

        for (int i = 0; i < m; i++)
        {   
            for (int j = 0; j < n; j++)
            {
                createAdjList(i, j, matrix);
            }
        }
    }

    void dfsUntil(int u)
    {   
        vertexList[u].visited = true;

        int max = 0;

        for (Vertex vertex : adjList.get(u))
        {
            if (vertex.visited == false && vertex.val > vertexList[u].val)
                dfsUntil(vertex.key);
            if (vertex.val > vertexList[u].val)
                max = vertex.maxCount > max ? vertex.maxCount : max;
        }
        vertexList[u].maxCount += max;

    }

    void dfs() {

        for (int u = 0; u < vertexs; u++) {

            if (vertexList[u].visited == false)
                dfsUntil(u);
            this.maxCount = vertexList[u].maxCount > this.maxCount ? vertexList[u].maxCount : this.maxCount; 
        }
    }

    public int getLongestIncreaseSubseq() {

        this.maxCount = 0;
        dfs();
        return this.maxCount;
    }
}

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        Graph graph = new Graph(matrix);

        return graph.getLongestIncreaseSubseq();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
        int matrix [][] = new int[][] {{9, 9 , 4}, {6, 6, 8}, {2, 1, 1}};
        Graph graph = new Graph(matrix);
        System.out.println(graph.getLongestIncreaseSubseq());
    }
}
