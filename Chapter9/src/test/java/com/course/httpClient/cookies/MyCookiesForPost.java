package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.EmptyStackException;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    String host;
    String cookieUrl;
    String getWithCookiesUrl;
    String postUrl;
    ResourceBundle bundle;

    CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application");
        host = bundle.getString("testHost");
        cookieUrl = bundle.getString("getCookies.url");
        getWithCookiesUrl = bundle.getString("getWithCookies.url");
        postUrl = bundle.getString("postWithCookies.url");
    }

    @Test
    public void getCookies() throws IOException {
        String url = host+cookieUrl;
        HttpGet get = new HttpGet(url);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        store=client.getCookieStore();
        String result = EntityUtils.toString(response.getEntity());
        Assert.assertEquals(result,"cookies获取成功~");
    }

    @Test(dependsOnMethods = {"getCookies"})
    public void testPostCookies() throws IOException {
        String url = host+postUrl;
        HttpPost post = new HttpPost(url);
        DefaultHttpClient client = new DefaultHttpClient();

        StringEntity stringEntity = new StringEntity("{\n" +
                "        \"name\": \"huhansan\",\n" +
                "        \"age\": \"17\"\n" +
                "      }","utf-8");

        post.setEntity(stringEntity);
        client.setCookieStore(store);

        post.setHeader("content-type","application/json");

        HttpResponse response = client.execute(post);
        String result=EntityUtils.toString(response.getEntity());
        System.out.println(result);


    }

}
