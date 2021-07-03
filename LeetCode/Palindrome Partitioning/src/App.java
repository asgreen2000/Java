import java.util.ArrayList;
import java.util.List;

public class App {

    List<List<String>> ansList = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {

        buildUntil(new ArrayList<>(), s);
        return ansList;
    }

    void buildUntil(List<String> list, String s)
    {
        if (s.equals(""))
        {
            ansList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {

            String tmp = s.substring(0, i);

            if (isPalin(tmp)) {

                list.add(tmp);
                buildUntil(list, s.substring(i));
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalin(String s)
    {
        int mid = s.length() / 2;
        
        for (int i = 0; i < mid; i++) {

            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return true;
        }

        return false;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
