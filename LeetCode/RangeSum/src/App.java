
class OperationOnArray
{

    public static int countSubArraySumLE(int[] array, int k)
    {
        int count = 0;
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;

        while (endIndex < array.length)
        {
            sum = sum + array[endIndex];

            while (startIndex <= endIndex && sum > k)
            {
                sum -= array[startIndex++];
            }

            count += (endIndex - startIndex + 1);
            endIndex++;
        }
        return count;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.print(OperationOnArray.countSubArraySumLE(new int[]{-1,4, 0}, 3));
    }
}
