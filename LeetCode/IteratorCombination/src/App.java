import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

class CombinationIterator {

    List<String> lst = new ArrayList<String>();
    String characters;
    int combinationLength;
    int iterator_index = 0;
    public CombinationIterator(String characters, int combinationLength) {
        
        this.setAttributes(characters, combinationLength);
        this.generateCombinations();

    }
    
    public String next() {
        
        if (iterator_index < lst.size()) {

            return lst.get(iterator_index++);
        }

        return null;
    }
    
    public boolean hasNext() {
        
        return iterator_index < lst.size();
    }

    void setAttributes(String characters, int combinationLength)
    {
        this.characters = characters;
        this.combinationLength = combinationLength;

    }
    private void generateCombinations() {

        this.generateUntil("", 0);
    }

    private void generateUntil(String str, int index) {

        if (str.length() == combinationLength)
        {   
            if (lst.contains(str) == false)
                lst.add(str);
        }

        if (str.length() > combinationLength)
        {
            return;
        }

        if (index >= characters.length())
        {
            return;
        }

        generateUntil(str + characters.charAt(index), index + 1);
        generateUntil(str, index + 1);


    }
}





public class App {
    public static void main(String[] args) throws Exception {
        
        CombinationIterator itr = new CombinationIterator("abc", 2);
        itr.next();    // return "ab"
        itr.hasNext(); // return True
        itr.next();    // return "ac"
        itr.hasNext(); // return True
        itr.next();    // return "bc"
        itr.hasNext(); // return False
    }
    
    @Test
    void test() {

        CombinationIterator itr = new CombinationIterator("abc", 2);
        assertEquals(true, (itr.next()).equals("ab"));    // return "ab"
        itr.hasNext(); // return True
        itr.next();    // return "ac"
        itr.hasNext(); // return True
        itr.next();    // return "bc"
        itr.hasNext(); // return False
    }
}
