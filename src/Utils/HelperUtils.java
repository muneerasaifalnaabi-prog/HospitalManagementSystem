package Utils;

public class HelperUtils {
    public Boolean isNull(Object obj){
        return obj==null;
    }
    public Boolean isNull(String str ){
        if (str.isEmpty()&& str.equals(null)){
            return true;
        }
        return false;
    }

}
