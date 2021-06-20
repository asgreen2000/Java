import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    static long countEvenInString(String str) {

        Pattern pattern = Pattern.compile("[02468]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher.results().count();
    }
    public static void main(String[] args) throws Exception {
        
        String str = "123456789";

        System.out.println(countEvenInString(str));
    }
}
