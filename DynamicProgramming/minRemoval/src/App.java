import java.util.Arrays;

public class App {

    static int minRemovals(int[] arr, int k) {

        Arrays.sort(arr);
        int min = arr.length;
        for (int j = arr.length - 1; j >= 0; j--) {
    
            int i = 0;
    
            while (arr[j] - arr[i] > k)
                i++;
            int size = 
            min = Math.min(min, arr.length - (j - i + 1));
        }
    
        return min;
    }

    public static void main(String[] args) throws Exception {
        //0 1 7 9 14
        
        int arr[] = new int[] {0, 10};
        
        System.out.println(minRemovals(arr, 10));
    }
}
