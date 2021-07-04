public class App {

    static public String reverseWords(String s) {
        
        String ans = "";

        String tmp = "";
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);  

            if (c == ' ' && tmp.length() > 0)
            {   
                ans = tmp + (ans.equals("") ? "" : (" " + ans));
                tmp = "";
            }
            else if (c != ' '){
                tmp += c;
            }
        }

        if (!tmp.equals(""))
        {
            ans = tmp + (ans.equals("") ? "" : (" " + ans));
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        
        String s = "EPY2giL";

        System.out.println(reverseWords(s) + "s");
    }
}
