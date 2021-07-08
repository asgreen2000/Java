import java.util.Arrays;

public class App {

    Float [] range;
    final float NON_VALID_VALUE = -1.0f;
    public boolean isAdditiveNumber(String num) {
        
        range = new Float[num.length() + 10];
        Arrays.fill(range, NON_VALID_VALUE);
        return generate(0, num);
    }


    boolean generate(int index, String str)
    {
        if (str.equals(""))
            return index > 2;
        
        for (int i = 1; i <= str.length(); i++)
        {
            Float num = parseFloat(str.substring(0, i));
            
            range[index] = num;
            
            if (generate(index + 1, str.substring(i)))
            {
                if (index < 2 || 
                    (range[index - 2] + range[index - 1] == range[index])
                )
                return true;
            }
            range[index] = NON_VALID_VALUE;
        }

        return false;
    }

    float parseFloat(String s)
    {
        if (s.length() > 1 && s.charAt(0) == '0')
            return 1000025225.0f;
        return Float.parseFloat(s);
    }

    public static void main(String[] args) throws Exception {
        
        App app = new App();
        System.out.println(app.isAdditiveNumber("19910011992"));
        
    }
}
