
class HashValue {

    int [] hash;
    int totalCount;
    int [] constHash;
    HashValue(String str) {

        hash = new int[28];
        totalCount = str.length();
        constHash = new int [28];

        for (int i = 0; i < totalCount; i++) {

            hash[str.charAt(i) - 'a'] += 1;
            constHash[str.charAt(i) - 'a'] += 1;
        }

    }
    boolean decreaseValue(char c) {

        boolean flag = false; 

        if (hash[c- 'a'] > 0) { 
            
            flag = true;
            hash[c - 'a'] -= 1;
            totalCount -= 1;
        }
        return flag;
    }

    void increaseValue(char c) {

        if (constHash[c - 'a'] > 0) { // check whether string contains this character, if answer is yes then restoring previous value
            hash[c - 'a'] += 1;
            totalCount += 1;
        }
    }

    int getValue(char keyChar) {

        return hash[keyChar - 'a'];
    }

    int getTotalCount() {

        return this.totalCount;
    }

}



class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        HashValue table = new HashValue(s1);
        
        int start = 0, end = 0;

        for (; end < s2.length(); end++)
        {
            boolean flag = table.decreaseValue(s2.charAt(end));

            if (table.getTotalCount() == 0)
            {

                return true;
            }

            if (!flag && table.getTotalCount() != s1.length())
            {
                while (start < end)
                {
                    table.increaseValue(s2.charAt(start));
                    if (s2.charAt(start) == s2.charAt(end)) {

                        table.decreaseValue(s2.charAt(start++));
                        break;
                    }
                    start++;
                }
            }
            else if (!flag) {
                start++;
            }
        }
        return false;
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }
}
