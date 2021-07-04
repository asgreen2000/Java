import java.util.ArrayList;
import java.util.List;

public class App {

    List<String> ans = new ArrayList<>();
    List<String> wordDict;
    public List<String> wordBreak(String s, List<String> wordDict) {
    
        this.wordDict = wordDict;

        breakUntil(s, "");
        return ans;
    }

    void breakUntil(String s, String curStr)
    {
        if (s == "")
        {
            ans.add(trimStr(curStr));
            return;
        }

        for (int i = 1; i <= s.length(); i++)
        {
            String sub = s.substring(0, i);

            if (wordDict.contains(sub))
            {
                breakUntil(s.substring(i), curStr + " " + sub);
            }
        }

    }

    String trimStr(String s)
    {
        int lastSpace = s.length();

        while (lastSpace > 0 && s.charAt(lastSpace - 1) == ' ')
        {
            lastSpace--;
        }

        return lastSpace > 0 ? s.substring(0, lastSpace) : "";
    }
    public static void main(String[] args) throws Exception {
        

        App app = new App();

        System.out.println(app.trimStr("  ") + "s");
    }
}
