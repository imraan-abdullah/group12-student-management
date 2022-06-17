package za.ac.cput.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class StringHelper {

    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }

    public static String checkId(String id) {
        if(isEmptyOrNull(id))
            throw new IllegalArgumentException("invalid credentials provided");
        return id;
    }

    public static String checkEmailValidation(String email) {
        if(EmailValidator.getInstance().isValid(email) == false)
            throw new IllegalArgumentException("Invalid email address provided");
        return email;
    }

    public static int checkPostalCode(int postalCode) {
        int min = 1000;
        int max = 9999;
        if(postalCode < min || postalCode > max)
            throw new IllegalArgumentException("invalid postalCode provided");
        return postalCode;
    }
}
