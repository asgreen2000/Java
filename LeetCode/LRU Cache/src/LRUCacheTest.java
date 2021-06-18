import java.lang.reflect.Array;
import java.util.ArrayList;

class Mem
{
    private int key;
    private int value;
    private int lastTimeUsed = 0;
    Mem(int key, int value) {

        this.key = key;
        this.value = value;
    }

    int getKey() {

        return this.key;
    }
    int getValue() {
        
        return this.value;
    }

    void setValue(int value) {
        this.value = value;
    }

    int getTime() {

        return this.lastTimeUsed;
    }
    void setTime(int time) {
        this.lastTimeUsed = time;
    }
}

class LRUCache {

    private int capacity = 0;
    private int size = 0;
    private int timeCount = 0;
    ArrayList<Mem> memList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        memList = new ArrayList<>();
    }
    
    public int get(int key) {
        
        Mem mem = findMemByKey(key);

        if (mem == null)
            return -1;
        return mem.getValue();
    }
    
    public void put(int key, int value) {
        
        Mem mem = findMemByKey(key);

        if (mem != null) {

            mem.setValue(value);
            mem.setTime(timeCount);
        }
        else {

            ensureSlotForThis();
            mem = new Mem(key, value);
            mem.setTime(timeCount);
            memList.add(mem);
        }
    }
    private void ensureSlotForThis() {

        if (size < capacity)
            return;
        int lruIndex = 0;

        for (int i = 0; i < size; i++) {

            if (memList.get(i).getTime() < memList.get(lruIndex).getTime()) {

                lruIndex = i;
            }
        }

        memList.remove(lruIndex);

    }

    public Mem findMemByKey(int key)
    {
        for (Mem mem : memList) {

            if (mem.getKey() == key)
                return mem;
        }

        return null;
    }

}

public class LRUCacheTest {

    public static void main(String[] args) {
        
    }
}