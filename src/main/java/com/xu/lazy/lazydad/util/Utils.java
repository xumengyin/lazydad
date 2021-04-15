package com.xu.lazy.lazydad.util;

import javax.servlet.http.Cookie;

public class Utils {



    public static Cookie createCookie(String key,String value)
    {
        Cookie c=new Cookie(key,value);
        return c;
    }
}
