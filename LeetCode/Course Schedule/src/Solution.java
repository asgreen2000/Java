import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph
{
    List<List<Integer>> adjList = new ArrayList<List<Integer>>();
    int [] pos;
    Stack<Integer> stack = new Stack<>();
    int numCourses;
    Graph(int [][] prer, int numCourses)
    {   

        for (int i = 0; i < numCourses; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < prer.length; i++) {
            (adjList.get(prer[i][0])).add(prer[i][1]);
        }
        this.numCourses = numCourses;
        pos = new int[numCourses]; // position of vertex in topo result
    }

    boolean check_cycle()
    {   
        int index = 0;
        while (!stack.empty())
        {
            int u = stack.pop();
            pos[u] = index++;
        }

        for (int u = 0; u < this.numCourses; u++) {

            for (Integer v : adjList.get(u)) {

                if (pos[u] >= pos[v]) /* graph contains cycle*/
                    return false;
            } 
            
        }
        return true;
    }
    boolean topologicalSort()
    {
        int [] visited = new int[this.numCourses];

        for (int u = 0; u < this.numCourses; u++) {

            if (visited[u] != 1) runTopoUntil(u, visited);
        }

        return check_cycle();
    }
    
    void runTopoUntil(int u, int [] visited)
    {
        visited[u] = 1;

        for (Integer v : adjList.get(u)) {

            if (visited[v] != 1) runTopoUntil(v, visited);
        } 
        stack.push(u);
    }
}


public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Graph graph = new Graph(prerequisites, numCourses);

        return graph.topologicalSort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
