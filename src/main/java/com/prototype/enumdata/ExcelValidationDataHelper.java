package com.prototype.enumdata;

/**
 * Created by runner on 15. 5. 11.
 */
public class ExcelValidationDataHelper {
    public static String getSetMethodName(String fieldName) {

        String firstChar =  fieldName.charAt(0) + "";
        String upperFirstChar = firstChar.toUpperCase();

        String setMethodName = "set" + upperFirstChar + fieldName.substring(1);

        return setMethodName;
    }

    public static String getGetMethodName(String fieldName) {

        String firstChar =  fieldName.charAt(0) + "";
        String upperFirstChar = firstChar.toUpperCase();

        String getMethodName = "get" + upperFirstChar + fieldName.substring(1);

        return getMethodName;
    }
}
