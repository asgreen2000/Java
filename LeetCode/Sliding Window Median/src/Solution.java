import java.util.Arrays;

class ArrayHandler {

    int [] arr;
    int currentSize;
    int lastElementIndex = 0;

    ArrayHandler(int [] nums, int k)
    {
        this.currentSize = k;
        this.arr = new int[k];

        for (int i = 0; i < k; i++)
            arr[i] = nums[i];
        Arrays.sort(arr);
    }

    double getMedian()
    {
        if (currentSize % 2 != 0)
        {
            return arr[currentSize / 2];
        }

        return (arr[currentSize / 2 - 1] + arr[currentSize / 2]) / 2.0;
    }

    void add(int num) {

        arr[lastElementIndex] = num;
        
        if (lastElementIndex > 0 && arr[lastElementIndex] < arr[lastElementIndex - 1])
            lastElementIndex = sortBefore(lastElementIndex);
        else if (lastElementIndex < currentSize - 1 && arr[lastElementIndex] > arr[lastElementIndex + 1])
            lastElementIndex = sortAfter(lastElementIndex);

    }

    int sortBefore(int index)
    {   
        int i = index;

        for (; i > 0; i--)
        {
            if (arr[i] < arr[i - 1]) {

                arr[i] = arr[i] ^ arr[i - 1];
                arr[i - 1] = arr[i] ^ arr[i - 1];
                arr[i] = arr[i] ^ arr[i - 1];
            }
            else {
                break;
            }
        }

        return i;
    }

    int sortAfter(int index)
    {   
        int i = index;

        for (; i < currentSize - 1; i++)
        {
            if (arr[i] > arr[i + 1]) {

                arr[i] = arr[i] ^ arr[i - 1];
                arr[i - 1] = arr[i] ^ arr[i - 1];
                arr[i] = arr[i] ^ arr[i - 1];
            }
            else {
                break;
            }
        }

        return i;
    }

}


public class Solution {

    static public double[] medianSlidingWindow(int[] nums, int k) {
        
        ArrayHandler handler = new ArrayHandler(nums, k);

        double [] arr = new double[nums.length - k + 1];
        int currentIndex = 1;
        arr[0] = handler.getMedian();

        for (int i = )

        return arr;
    }

    public static void main(String[] args) throws Exception {
        
        medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);

    }
}
