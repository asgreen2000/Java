import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;

        int count[][] = new int[m][n];

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++)
        {   
            Arrays.fill(count[i], 100000);
            for (int j = 0; j < n; j++)
            {
                if (i == entrance[0] && j == entrance[1])
                    continue;
                if (maze[i][j] == '+' || !isExit(maze, i, j))
                    continue;
                count[i][j] = 0;
                queue.add(new Pair(i, j));
            }
        }
        
        while (!queue.isEmpty())
        {
            Pair pair = queue.remove();
            int i = pair.i;
            int j = pair.j;

            if (i == entrance[0] && j == entrance[1])
                return count[i][j];
            
            // Update left
            if (j > 0 && maze[i][j - 1] == '.'&& count[i][j - 1] > count[i][j] + 1)
            {
                count[i][j - 1] = count[i][j] + 1;
                queue.add(new Pair(i, j - 1));
            }
            // Update right
            if (j < n - 1 && maze[i][j + 1] == '.'&& count[i][j + 1] > count[i][j] + 1)
            {
                count[i][j + 1] = count[i][j] + 1;
                queue.add(new Pair(i, j + 1));
            }

            // Update up
            if (i > 0 && maze[i - 1][j] == '.'&& count[i - 1][j] > count[i][j] + 1)
            {
                count[i - 1][j] = count[i][j] + 1;
                queue.add(new Pair(i - 1, j));
            }
            
            // Update down
            if (i < m - 1 && maze[i + 1][j] == '.'&& count[i + 1][j] > count[i][j] + 1)
            {
                count[i + 1][j] = count[i][j] + 1;
                queue.add(new Pair(i + 1, j));
            }


        }
        return -1;
    }

    boolean isExit(char[][] maze, int i, int j)
    {
        if (maze[i][j] != '.')
            return false;
        if (i == 0 || i == maze.length - 1)
            return true;
        if (j == 0 || j == maze[0].length - 1)
            return true;
        return false;
    }   
}


public class App {
    public static void main(String[] args) throws Exception {
        
        char maze[][] = new char[][] {{'+','+','+'},{'.','.','.',},{'+','+','+'}};
        int [] pos = {1, 0};
        Solution solution = new Solution();
        solution.nearestExit(maze, pos);
    }
}
