package Utils;

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


}
