package com.allaber.pass.utils;

public class Utils {
    public static boolean isBlankString( String value )
    {
        return value == null || value.trim().length() == 0;
    }
}
