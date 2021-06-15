import java.util.PriorityQueue;

class Solution {

    class Point {

        int x, y;
        int dist;

    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> q = new PriorityQueue<Point>((p1, p2) -> p1.dist - p2.dist);
    
        for(int [] p: points) {

            Point point = new Point();
            point.x = p[0];
            point.y = p[1];
            point.dist = point.x * point.x + point.y * point.y;
            q.add(point);
        }

        int [][] ans = new int[k][2];

        for (int i = 0; i < k; i++)
        {
            Point point = q.poll();
            ans[i][0] = point.x;
            ans[i][1] = point.y;
        }

        return ans;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
