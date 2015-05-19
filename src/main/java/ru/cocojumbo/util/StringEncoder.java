package ru.cocojumbo.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by ANK on 17.05.2015.
 */
public class StringEncoder {
    public static String encode(String str)throws UnsupportedEncodingException{
        return str == null ? "": new String(str.getBytes("ISO-8859-1"), "UTF-8");
    }
}
