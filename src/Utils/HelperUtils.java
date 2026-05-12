package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

public class HelperUtils {
    //Null Check Methods

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
    //String Validation Methods
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
    //ID Generation Methods
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
    public static String generateId(String prefix) {
        return prefix + "-" + (int)(Math.random() * 100000);
    }
    public static String generateId(String prefix, int length) {
        String num = String.valueOf((long)(Math.random() * Math.pow(10, length)));
        return prefix + "-" + num;
    }
    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + (int)(Math.random() * 100000) + "-" + suffix;
    }
    //Date Validation Methods
    public static boolean isValidDate(Date date){
        return date != null;
    }
    public static boolean isValidDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean isValidDate(Date date, Date minDate, Date maxDate) {
        if (date == null) return false;
        return date.after(minDate) && date.before(maxDate);
    }

    //Numeric Validation Methods
    public static boolean isFutureDate(Date date) {
        return date != null && date.after(new Date());
    }
    public static boolean isPastDate(Date date) {
        return date != null && date.before(new Date());
    }














}
