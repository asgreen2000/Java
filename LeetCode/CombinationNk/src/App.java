import java.util.ArrayList;
import java.util.List;

public class App {

    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    public static void main(String[] args) throws Exception {
        
        App app = new App();
        app.combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer> lst = new ArrayList<Integer>();
        combineUntil(n, k, 1, lst);

        return this.list;
    }
    
    void combineUntil(int n, int k, int num, List<Integer> lst) {

        if (lst.size() == k)
        {
            List<Integer> list = new ArrayList<Integer>(lst);
            this.list.add(list);

        } else if (num > n) {
            return;

        } else {

            lst.add(num);
            combineUntil(n, k, num + 1, lst);
            lst.remove(lst.size() - 1);
            combineUntil(n, k, num + 1, lst);
        }
    }
}
