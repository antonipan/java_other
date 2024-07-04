package projectsByJava.sandbox;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {

    public static boolean test (String s) {
        Pattern p = Pattern.compile("^Ivan$");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static boolean test2 (String str) {
        Pattern p = Pattern.compile(".+\\.(com|ru|org)");
        Matcher m = p.matcher(str);
        return m.matches();
    }




}
