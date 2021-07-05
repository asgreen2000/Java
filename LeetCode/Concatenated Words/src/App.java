import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

public class App {

    static public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Arrays.sort(words, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                
                return o1.length() - o2.length();
            }
            
        });

        Hashtable<String, Integer> hashtable = new Hashtable<>();
        List<String> aList = new ArrayList<>();

        for (int i = 0; i < words.length; i++)
        {
            for (int j = 0; j < i && words[j].length() < words[i].length(); j++)
            {
                int index = words[i].indexOf(words[j]);

                if (index < 0 || (index > 0 && (index + words[j].length() < words[i].length())))
                    continue;
                if (index == 0 && 
                hashtable.contains(words[i].substring(index + words[j].length())))
                    aList.add(words[i]);
                if (index > 0 && hashtable.contains(words[i].substring(0, i)))
                    aList.add(words[i]);
            }
            hashtable.put(words[i], 1);
        }
        return aList;
    }

    public static void main(String[] args) throws Exception {
        String [] words = new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        findAllConcatenatedWordsInADict(words);
        System.out.println("a".indexOf("b"));
    }
}
