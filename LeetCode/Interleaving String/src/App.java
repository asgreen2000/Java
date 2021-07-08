
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        
        if (s3.length() == 0)
            return false;
        
        boolean first = false;
        if (s1.length() > 0) {
            first = s1.charAt(0) == s3.charAt(0) && 
            isInterleave(s1.substring(1), s2, s3.substring(1));
        }

        if (first)
            return true;

        boolean second = false;
        if (s2.length() > 0) {
            second = s2.charAt(0) == s3.charAt(0) && 
            isInterleave(s1, s2.substring(1), s3.substring(1));
        }

        return second;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
