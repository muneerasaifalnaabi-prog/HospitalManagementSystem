package Utils;

import java.util.UUID;
import java.util.regex.Pattern;

public class HelperUtils {
    public Boolean isNull(Object obj) {
        return obj == null;
    }

    public Boolean isNull(String str) {
        return str == null || str.isEmpty();

    }
    public static  boolean isNotNull(Object obj){
        return obj != null;
    }
    public static boolean isNotNull(String str) {
        return  str !=null || !str.isEmpty();
    }
    public static boolean isValidString(String str) {
        return isNotNull(str);
    }
    public static boolean isValidString(String str, int minLength) {
        return isNotNull(str) && str.length()<=minLength;
    }
    public static boolean isValidString(String str, int minLength, int maxLength) {
        return isNotNull(str)
                && str.length() >=minLength && str.length() <= maxLength;
    }
    public static boolean isValidString(String str, String regex) {
        return isNotNull(str) && Pattern.matches(regex, str);
    }
    public static String generateId() {
        return UUID.randomUUID().toString();
    }





}
