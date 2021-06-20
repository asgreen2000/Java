public class App {

    static int convert(char c)
    {
        switch(c) {

            case 'A' : return 10;
            case 'B' : return 11;
            case 'C' : return 12;
            case 'D' : return 13;
            case 'E' : return 14;
            case 'F' : return 15;
        }

        return c - '0';

    }
    static void rabin(char [] arr)
    {
        int n = arr.length;
        int p = (11 * 16 + 12) % 17;

        for (int i = 0; i < n - 1; i++) {

            int ans = (convert(arr[i]) * 16 + convert(arr[i + 1])) % 17;

            if (ans == p)
                System.out.printf("%c%c\n", arr[i], arr[i + 1]);
        }
    }
    public static void main(String[] args) throws Exception {
        
        char [] arr = new char[] {'3', '1', 'A', 'B', 'C', '9', '2', '6', 'D', 'E', 'F', '8', '9', '7', 'A'};
        
        rabin(arr);
    }
}
