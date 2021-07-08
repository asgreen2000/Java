public class App {

    static int maxProduct(int[] arr) {

        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        left[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++)
        {
            left[i] = arr[i] * left[i - 1];
            right[arr.length - 1 - i] = ((arr[arr.length - 1 - i] % 1000000007) * 
            (right[arr.length - 1 - i + 1]% 1000000007)) % 1000000007;
        }

        int max =  -1000000007;
        for (int i = 0; i < arr.length - 1; i++)
        {   
            max = Math.max(max, (left[i] + right[i + 1])  % 1000000007);
        
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        
        int arr[] = new int[] {-3,0};
        System.out.println(maxProduct(arr));
    }
}
