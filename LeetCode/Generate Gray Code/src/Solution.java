import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {

    static public List<Integer> grayCode(int n) {
        
        List<Integer> L1;
        if (n == 1)
        {   
            L1 = new ArrayList<>();
            L1.add(0);
            L1.add(1);
            return L1;
        }

        L1 = grayCode(n - 1);
        List<Integer> L2 = new ArrayList<>(L1);
        Collections.reverse(L2);
        int add = (int) Math.pow(2, n - 1);

        for (int i = 0; i < L1.size(); i++)
        {   
            L2.set(i, L2.get(i) + add);
        }

        L1.addAll(L2);
        return L1;

    }

    public static void main(String[] args) throws Exception {
        
        grayCode(2);
    }
}
