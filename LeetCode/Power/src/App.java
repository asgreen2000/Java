import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {

    static double myPow(int x, int n)
    {
        ArrayList<Integer> bArrayList = generateBinArray(n);

        double ans = 1.0;
        
        for (int i = bArrayList.size() - 1; i >= 0; i--)
        {
            int element = bArrayList.get(i) == 1 ? x: 1;

            ans = ans * ans * element;
            
        }
        return ans;
    }

    static ArrayList<Integer> generateBinArray(int n)
    {
        ArrayList<Integer> bArrayList = new ArrayList<>();

        while (n > 0)
        {
            bArrayList.add(n % 2 > 0 ? 1 : 0);
            n /= 2;
        }

        return bArrayList;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(myPow(2, 2));
    }
}
