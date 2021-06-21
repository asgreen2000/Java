
class HashTableHandler
{   
    private int charMap [] = new int[58];
    private int constCharMap [] = new int[58];
    private int currentCount = 0;
    private int targetCount = 0;

    HashTableHandler(String toMap)
    {   
        targetCount = toMap.length();
        for (int i = 0; i < targetCount; i++)
        {
            constCharMap[toMap.charAt(i) - 'A']++;
        }
    }

    boolean add(Character c)
    {
        if (constCharMap[c - 'A'] == 0)
            return false;
        charMap[c - 'A']++;

        if (charMap[c - 'A'] <= constCharMap[c - 'A'])
            currentCount++;
        return true;
    }

    boolean remove(Character c) {

        if (constCharMap[c - 'A'] == 0)
            return false;

        charMap[c - 'A']--;

        if (charMap[c - 'A'] < constCharMap[c - 'A'])
            currentCount--;
        return true;

    }

    boolean isValid() {

        return currentCount == targetCount;
    }

}

public class Solution {

    
    static public String minWindow(String s, String t) {
        
        int start = 0, end = 0;
        int final_start = 0, final_end = s.length() + 2;

        HashTableHandler handler = new HashTableHandler(t);

        for (; end < s.length(); end++) 
        {   
            handler.add(s.charAt(end));

            while (start <= end && handler.isValid() == true)
            {   
                if (end - start < final_end - final_start)
                {
                    final_end = end;
                    final_start = start;
                }
                handler.remove(s.charAt(start++));
            }

        }

        return (final_end - start + 1) < s.length() ? s.substring(final_start, final_end + 1) : "";
    }

    public static void main(String[] args) throws Exception {
        
        System.out.print(minWindow("a", "aa"));
    }
}
