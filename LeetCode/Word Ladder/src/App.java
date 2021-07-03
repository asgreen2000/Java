import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class App {

    int visited[];
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
    }

    String findNextValidWord(String begin, List<String> wordList)
    {

        for (int i = 0; i < wordList.size(); i++) {
            if (visited[i] == 0 && validWord(begin, wordList.get(i)))
                return wordList.get(i);
        }

        return "";
    }

    boolean validWord(String s1, String s2) {

        String a = getSortString(s1);
        String b = getSortString(s2);

        int count = 0;

        for (int i = 0; i < s1.length(); i++)
        {
            if (a.charAt(i) != b.charAt(i))
                count++;

            if (count == 2)
                return false;
        }
        return true;
    }

    String getSortString(String s) {

        char temp[] = s.toCharArray();
        Arrays.sort(temp);

        return temp.toString();
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.validWord("ab", "ca"));
    }
}
