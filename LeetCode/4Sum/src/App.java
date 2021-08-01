
public class App {
    public static void main(String[] args) throws Exception {
        
        int a = 1;
        System.out.println(System.identityHashCode(a));
        a = 1;
        System.out.println(System.identityHashCode(a));
    }
}
