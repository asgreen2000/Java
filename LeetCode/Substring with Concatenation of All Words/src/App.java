import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class App {

    static public List<Integer> findSubstring(String s, String[] words) {
            
        List<Integer> ans = new ArrayList<>();

        int start = 0, end = words.length * words[0].length() - 1;
        int wordSize = words[0].length();

        for (; end < s.length(); end++, start++)
        {
            int i = start + wordSize;
            HashMap<String, Integer> hashMap = new HashMap<>();
            
            for (String word : words)
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);

            while (i <= (end + 1))
            {
                String sub = s.substring(i - wordSize, i);
                int count = hashMap.getOrDefault(sub, 0);
                if (count <= 0)
                    break;
                hashMap.put(sub, count - 1);
                i += wordSize;
            }

            if (i > (end + 1))
                ans.add(start);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        
        String words [] = new String[] {"foo","bar"};
        String s = "barfoothefoobarman";

        List<Integer> l = findSubstring(s, words);
        l = null;
    }
}
