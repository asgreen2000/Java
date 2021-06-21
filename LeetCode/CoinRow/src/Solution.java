public class Solution {

    int solveCoinRow(int [] arr)
    {
        int [] f = new int[arr.length + 1];  // array indicating max value at index
        f[0] = 0; 
        f[1] = arr[0];

        for (int i = 2; i <= arr.length; i++) {

            f[i] = Math.max(arr[i - 1] + f[i - 2], f[i - 1]);
        }

        return f[arr.length];

    }
    public static void main(String[] args) throws Exception {
        
        

    }
}
