import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class StringHanlder
{
    class Item {

        String value;
        List<Item> adjList;
        boolean visited = false;
        int count = 0;

        Item(String value) {
            this.value = value;
            adjList = new ArrayList<>();
        }
    }

    List<Item> list;


    StringHanlder(List<String> wordList)
    {   
        list = new ArrayList<>();
        for (String word : wordList)
        {
            list.add(new Item(word));
        }

        for (int i = 0; i < wordList.size(); i++)
        {
            for (int j = 0; j < wordList.size(); j++)
            {
                if (valid(wordList.get(i), wordList.get(j)))
                {
                    list.get(i).adjList.add(list.get(j));
                }
            }
        }
    }


    boolean valid(String s1, String s2)
    {
        if (s1.length() != s2.length())
            return false;
        int count = 0;

        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count == 2)
                return false;
        }
        if (count == 0)
            return false;
        return true;
    }


    int ladderLength(String beginWord, String endWord)
    {
        Queue<Item> queue = new LinkedList<>();
        int min = 10000;

        for (Item item : list)
        {   
            if (item.value.equals(beginWord)) {
                item.count = 1;
                queue.add(item);
                item.visited = true;
            }
            else if (valid(beginWord, item.value)) {
                item.count = 2;
                queue.add(item);
                item.visited = true;
            }

        }

        while (!queue.isEmpty())
        {
            Item item = queue.remove();
            if (item.value.equals(endWord))
            {
                min = Math.min(min, item.count);
                continue;
            }

            for (Item item2 : item.adjList)
            {
                if (item2.visited == false)
                {   
                    item2.count = item.count + 1;
                    queue.add(item2);
                }
                else if (item2.count > item.count + 1){
                    item2.count = item.count + 1;
                    queue.add(item2);
                }
                item2.visited = true;
            }
        }



        return min;
    }
}


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
        StringHanlder hanlder = new StringHanlder(wordList);
        return hanlder.ladderLength(beginWord, endWord);
    }
}

class Item {
    int x = 0;
}

public class App {
    public static void main(String[] args) throws Exception {
        
        String arr[] = new String[] {"a", "b", "c"};
        String beginWord = "a";
        String endWord = "c";

        List<String> wordsList = new ArrayList<>();

        for (String str : arr)
        {
            wordsList.add(str);
        }

        StringHanlder hanlder = new StringHanlder(wordsList);
        System.out.println(hanlder.ladderLength(beginWord, endWord));
    }
}
