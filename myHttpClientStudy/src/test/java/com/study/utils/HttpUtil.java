package com.study.utils;

public class HttpUtil {
    public static String buildUrl(String localhost,String uri){
        String url = String.format("http://%s%s",localhost,uri);
        return url;
    }
}
