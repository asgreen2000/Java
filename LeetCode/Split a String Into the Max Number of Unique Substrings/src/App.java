import java.util.ArrayList;
import java.util.List;

public class App {

    public int maxUniqueSplit(String s) {
        
        return maxUnique(s, new ArrayList<String>());
    }

    int maxUnique(String s, List<String> list)
    {
        int max = 0;

        for (int i = 1; i <= s.length(); i++)
        {
            String tmp = s.substring(0, i);
            
            if (list.contains(tmp) == false) {

                list.add(tmp);
                max = Math.max(maxUnique(s.substring(i), list), max);
                list.remove(list.size() - 1);
            }
        }

        return max;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
