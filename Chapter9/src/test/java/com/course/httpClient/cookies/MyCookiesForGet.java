package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    String host;
    String url;
    ResourceBundle bundle;
    CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        host = bundle.getString("testHost");
        url = bundle.getString("getCookies.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        HttpGet get = new HttpGet(host+url);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookies= store.getCookies();

        for (Cookie cookie:cookies){
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();

            System.out.println("cookieName:"+cookieName+";cookieValue:"+cookieValue);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void getWithCookies() throws IOException {
        String withCookiesUrl = host+(bundle.getString("getWithCookies.url"));
        System.out.println(withCookiesUrl);
        HttpGet get = new HttpGet(withCookiesUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        int status = response.getStatusLine().getStatusCode();
        if (status == 200){
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }else {
            System.out.println("测试失败");
        }
    }
}
