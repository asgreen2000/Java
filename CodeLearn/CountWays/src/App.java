public class App {

    int countWays(int n) {
        
        int arr[][] = new int[];
    }

    boolean isValid(int arr[][])
    {
        if (arr[0][0] == 1)
        {
            if (arr[0][1] == 1 || arr[1][0] == 1)
                return false;
        }
        if (arr[1][1] == 1)
        {
            if (arr[1][0] == 1 || arr[0][1] == 1)
                return false;
        }

        return true;
    }
    public static void main(String[] args) throws Exception {
        
        App app = new App();
        System.out.println(app.countWays(5));
    }
}
