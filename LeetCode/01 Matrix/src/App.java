import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Point
    {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int INFINITE = 10000;
        int [][] upMatrix = new int[m][n];

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0)
                {
                    upMatrix[i][j] = 0;
                    q.add(new Point(i, j));
                }
                else {
                    upMatrix[i][j] = INFINITE;
                }

        while (!q.isEmpty())
        {
            Point point = q.remove();

            /*left-neighbour*/
            if (point.j > 0 && matrix[point.i][point.j - 1] ==1)
            {
                if (upMatrix[point.i][point.j] + 1 < upMatrix[point.i][point.j - 1]) {

                    q.add(new Point(point.i, point.j - 1));
                    upMatrix[point.i][point.j - 1] = upMatrix[point.i][point.j] + 1;
                }
            }

            /*right-neighbour*/
            if (point.j < n - 1 && matrix[point.i][point.j + 1] ==1)
            {
                if (upMatrix[point.i][point.j] + 1 < upMatrix[point.i][point.j + 1]) {

                    q.add(new Point(point.i, point.j + 1));
                    upMatrix[point.i][point.j + 1] = upMatrix[point.i][point.j] + 1;
                }
            }

            /*up-neighbour*/
            if (point.i > 0 && matrix[point.i - 1][point.j] ==1)
            {
                if (upMatrix[point.i][point.j] + 1 < upMatrix[point.i - 1][point.j]) {

                    q.add(new Point(point.i - 1, point.j));
                    upMatrix[point.i - 1][point.j] = upMatrix[point.i][point.j] + 1;
                }
            }

            /*down-neighbour*/
            if (point.i < m - 1 && matrix[point.i + 1][point.j] ==1)
            {
                if (upMatrix[point.i][point.j] + 1 < upMatrix[point.i + 1][point.j]) {

                    q.add(new Point(point.i + 1, point.j));
                    upMatrix[point.i + 1][point.j] = upMatrix[point.i][point.j] + 1;
                }
            }
        }

        return upMatrix;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
