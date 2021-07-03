
class StringHandler {


    public boolean checkPartitioning(String s) {
        
        return checkUntil(s, 0);
    }

    boolean checkUntil(String s, int count)
    {
        if (count > 3)
            return false;
        if (count == 3 && s.length() == 0)
            return true;
        if (s.length() == 0)
            return false;
        
        for (int i = 1; i <= s.length(); i++) {

            String tmp = s.substring(0, i);

            if (isPalin(tmp) && checkUntil(s.substring(i), count + 1))
                return true;
        }

        return false;
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
}



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
