import java.util.Vector;

public class App {

    static int fibonacci(int n)
    {
        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2]; // fib(n) = fib(n - 1) + fib(n - 2)
        }

        return dp[n];
    }

    static void knapSack()
    {
        int [] value = {25, 20, 15, 40, 50}; 
        int [] size = {3, 2, 1, 4, 5};
        int [][] cost = new int [6][18];
        int [] name = new int [18];
        char arr[] = {'A', 'B', 'C', 'D', 'E', '-'};
        for (int i = 0; i <= 17; i++)
            name[i] = 5;

        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= 6; j++)
            {
                if (j - size[i - 1] >= 0)
                {
                    if (cost[i - 1][j] < (cost[i - 1][j - size[i - 1]] + value[i - 1]))
                    {
                        cost[i][j] = cost[i - 1][j - size[i - 1]] + value[i - 1];
                        name[j] = i - 1; 
                    }
                    else {
                        cost[i][j] = cost[i - 1][j];
                    }
                }
            }

            for (int index = 1; index <= 6; index++)
                System.out.printf("[%d, %c] ", cost[i][index], arr[name[index]]);
            System.out.println();

        }



    }

    static int combination(int m, int n)
    {
        if (m == 0 || m == n)
            return 1;
        
        return combination(m, n - 1) + combination(m - 1, n - 1);
    }


    static int pascalCombination(int m , int n)
    {
        int [][] C = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++)
        {
            C[0][i] = 1;
            C[i][i] = 1;
        }

        for (int i = 1; i <= n - 1; i++)
        {
            for (int j = i + 1; j <= n; j++)
                C[i][j] = C[i][j - 1] + C[i - 1][j - 1];
        }

        return C[m][n];
    }

    static void multiMatrix()
    {
        int [] arr = {5, 3, 2, 19, 18};

        int [][] dp = new int[6][6];
        int [][] s = new int[6][6];
        
        for (int size = 1; size <= 4; size++)
        {
            for (int i = 1; i <= 4; i++)
            {
                int min = 100000000;
                int j = i + size;
                if (j > 4)
                    continue;
                for (int k = i; k < j; k++) {

                    int ans = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];

                    if (ans < min) {

                        min = ans;
                        s[i][j] = k;
                    }
                }
                dp[i][j] = min;
            }
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print(s[i][j] + " ");
            System.out.println();
        }

    }

    static void lcsString()
    {
        char [] a = {'A', 'B', 'A', 'Z', 'D', 'C' };
        char [] b = {'B', 'A', 'C', 'B', 'A', 'D'};

        int m = a.length;
        int n = b.length;

        int [][] dp = new int[m + 1][n + 1];
        String [][] ans = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (a[i - 1] == b[j - 1])
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans[i][j] = "cheo";
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    ans[i][j] = "tren";
                }
                else {
                    dp[i][j] = dp[i][j - 1];
                    ans[i][j] = "trai";
                }
            }
        }

        for (int i = 0; i <= m; i++)
        {   
            
            for (int j = 0; j <= n; j++)
            {
                System.out.printf("%s     ", ans[i][j]);
            }

            System.out.println();
        }

    }

    static void warShall()
    {
        int [][] matrix = {{0, 0, 0, 1}, {1, 0, 1, 1}, {1, 0, 0, 1}, {0, 0, 1, 0}};
        int n = matrix.length;

        for (int y = 0; y < n; y++)
        {
            for (int x = 0; x < n; x++)
            {

                if (matrix[x][y] == 1) {

                    for (int j = 0; j < n; j++)
                    {
                        if (matrix[y][j] == 1)
                            matrix[x][j] = 1;
                    }
                }
                
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("--------");
        }
     
    }
    
    static void coinChange(int V)
    {
        Vector<Integer> ans = new Vector<>();
        int [] coinValue = {25, 10, 5, 1};
        int n = coinValue.length;
       
        for (int i = n - 1; i >= 0; i--)
        {
            
            while (V >= coinValue[i])
            {
                V -= coinValue[i];
                ans.add(coinValue[i]);
            }
        }
 
        for (int i = 0; i < ans.size(); i++)
        {
            System.out.print(
                " " + ans.elementAt(i));
        }

    }

    static void floyd()
    {
        int [][] matrix = {{0, 0, 3, 0}, {2, 0, 0, 0}, {0, 7, 0, 1}, {6, 0, 0, 0}};
        int n = matrix.length;
        char [][] p = new char[4][4];
        char [] name = {'a', 'b', 'c', 'd'};

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                p[i][j] = '0';
            }
            
        }

        for (int y = 0; y < n; y++)
        {
            for (int x = 0; x < n; x++)
            {

                if (matrix[x][y] > 0) {

                    for (int j = 0; j < n; j++)
                    {   
                        if (matrix[y][j] > 0) {
                        if (matrix[x][j] == 0 || matrix[x][y] + matrix[y][j] < matrix[x][j])
                            matrix[x][j] = matrix[x][y] + matrix[y][j];
                            p[x][j] = name[y];
                        }
                    }
                }
                
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("--------");
        }
     
    }

    
    public static void main(String[] args) throws Exception {
        
        
        ActivitySelection.main(null);
    }
}

class ActivitySelection
{
    // Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    //  n   -->  Total number of activities
    //  s[] -->  An array that contains start time of all activities
    //  f[] -->  An array that contains finish time of all activities
    public static void printMaxActivities(int s[], int f[], int n)
    {
    int i, j;
      
    System.out.print("Following activities are selected : n");
      
    // The first activity always gets selected
    i = 0;
    System.out.print(i+" ");
      
    // Consider rest of the activities
    for (j = 1; j < n; j++)
    {
         // If this activity has start time greater than or
         // equal to the finish time of previously selected
         // activity, then select it
         if (s[j] >= f[i])
         {
              System.out.print(j+" ");
              i = j;
          }
     }
    }
      
    // driver program to test above function
    public static void main(String[] args)
    {
    int s[] =  {1, 3, 4, 2, 6, 4, 10, 12, 11};
    int f[] =  {3, 4, 6, 8, 10, 13, 14, 15, 16};
    int n = s.length;
        
    printMaxActivities(s, f, n);
    }
     
}