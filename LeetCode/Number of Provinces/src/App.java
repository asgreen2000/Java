import java.util.ArrayList;
import java.util.List;


class Graph
{
    private List<List<Integer>> adjList = new ArrayList<List<Integer>>();
    private int vertexNum;
    private int countConnectComponent = 0;

    Graph(int [][] matrix) {

        this.vertexNum = matrix.length;

        for (int i = 0; i < matrix.length; i++)
        {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] > 0)
                    list.add(j);
            adjList.add(list);
        }
    }

    void dfsUntil(int u, int [] visited)
    {
        visited[u] = 1;

        for (Integer v : adjList.get(u)) {

            if (visited[v] == 0)
                dfsUntil(v, visited);
        }
    }

    void dfs() {

        int [] visited = new int[this.vertexNum];
        this.countConnectComponent = 0;

        for (int u = 0; u < vertexNum; u++) {

            if (visited[u] == 0) {
                countConnectComponent++;
                dfsUntil(u, visited);
            }
        }
    }

    int getConnectComponentCount() {

        if (this.countConnectComponent == 0)
            this.dfs();
        return this.countConnectComponent;
    }
}


class Country {

    Graph map;

    Country(int [][] citiesMap)
    {
        this.map = new Graph(citiesMap);
    }

    int getProvincesCount() {

        return map.getConnectComponentCount();
    }
}


class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        Country country = new Country(isConnected);


        return country.getProvincesCount();
    }
}

public class App {

    public static void main(String[] args) throws Exception {
        
        int matrix[][] = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        Solution solution = new Solution();
        solution.findCircleNum(matrix);
    }
}
