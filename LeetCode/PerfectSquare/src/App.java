class Solution {

    int LIMIT;
    int min;
    public int numSquares(int n) {
        
        this.LIMIT = (int) Math.sqrt(n);
        this.min = 1000000;

        generateUntil(n, this.LIMIT, 0);

        return this.min;
    }

    void generateUntil(int target, int x, int count)
    {
        if (target == 0) {

            min = count < min ? count : min;
        }

        if (target < 0 || x <= 0 || count > min) {

            return;
        }

        int sq = (int) Math.sqrt(target);
        generateUntil(target - x * x, x < sq ? sq : x, count + 1);
        generateUntil(target - x * x, (x - 1) < sq ? sq : (x - 1), count + 1);
        generateUntil(target, x - 1, count);
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
