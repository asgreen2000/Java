import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> pathList = new ArrayList<List<Integer>>();
    int target;
    int [][] visitedPath;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        visitedPath = new int[graph.length][graph.length];
        target = graph.length - 1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        
        if (dfsUntil(0, list, graph))
            return pathList;
        return null;
    }

    boolean dfsUntil(int currentNode, List<Integer> list, int[][] graph)
    {
        if (currentNode == target) {

            pathList.add(new ArrayList<>(list));
            return true;
        }
        boolean successReach = false;
        int totalAdjNode = graph[currentNode].length;
        for (int i = 0; i < totalAdjNode; i++)
        {
            int adjNode = graph[currentNode][i];

            if (visitedPath[currentNode][adjNode] != -1) {

                list.add(adjNode);
                boolean isValidPath = dfsUntil(adjNode, list, graph);
                list.remove(list.size() - 1);
                if (isValidPath) {
                    visitedPath[currentNode][adjNode] = 0;
                    successReach = true;
                }
                else
                    visitedPath[currentNode][adjNode] = -1;
            }
        }

        return successReach;
    }
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        int [][]graph = new int[][] {{1, 2}, {3}, {3}, {}};
        solution.allPathsSourceTarget(graph);
    }
}
