public class App {

    String firstDegreeEquation(String s) {
    
        int const_count[] = new int[2];
        
        int i = 0;
        
        while (i < s.length())
        {
            i = extract(const_count, s, i);
        }
        int ans = 0;

        if (const_count[0] == 0 && const_count[1] == 0)
            return "Infinite Solution";
        if (const_count[0] != 0 && const_count[1] == 0)
            return "No solution";
        if (const_count[1] % const_count[0] == 0)
            return Integer.toString((-const_count[0]) / const_count[1]);
        return "100";
    }

    int extract(int const_count[], String s, int i)
    {
        int count = 1;
        int current_count = 0;
        int deg = 0;
        boolean complete = true;
        int sign = (i > 0 && s.charAt(i - 1) == '-') ? -1 : 1;
        int countNum = 0;

        if (s.indexOf('=') < i)
        {
            sign *= -1;
        }

        for (; i < s.length(); i++)
        {   
            if (count == 0 && countNum == 0)
                count = 1;
                 
            if (s.charAt(i) == 'x') {

                deg = 1;
            } else if (s.charAt(i) == '*')
            {
                count *= current_count;
                current_count = 0;
                complete = true;
                

            } else if (s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '=')
            {
                if (complete == false)
                {
                    count *= current_count;
                    current_count = 0;
                    complete = true;
                }
                break;
            }
            else {

                current_count = current_count * 10 + (s.charAt(i) - '0');
                complete = false;
                countNum = 1;
            }
        }

        if (complete == false)
        {
            count *= current_count;
            current_count = 0;
            complete = true;
        }
        const_count[deg] += count * sign;

        return i + 1;
    }

    public static void main(String[] args) throws Exception {
        
        App app = new App();
        String ans = app.firstDegreeEquation("x*3+18=21");

        System.out.println(ans);
    }
}
