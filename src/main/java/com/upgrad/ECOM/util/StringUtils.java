package com.upgrad.ECOM.util;

public class StringUtils {

    public static boolean isEmptyOrNull(String str){
        if(str == null){
            return true;
        }else if( str.length() == 0){
            return true;
        } else{
            return false;
        }
    }
}
