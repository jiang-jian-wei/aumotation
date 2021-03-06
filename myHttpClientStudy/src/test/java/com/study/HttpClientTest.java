package com.study;

import com.study.utils.HttpClientUtil;
import com.study.utils.HttpUtil;
import com.study.utils.TestServer;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class HttpClientTest {
    @Value("${localHost}")
    private String localHost;

    @Value("${get.param.url}")
    private String getParamUrl;

    @Value("${url.login}")
    private String urlLogin;

    @Value("${url.getUserList}")
    private String urlGetUserList;

    @Autowired
    TestServer testServer;


    @Test
    public void getTest() throws URISyntaxException, UnsupportedEncodingException {
        String url = HttpUtil.buildUrl(localHost,getParamUrl);
        System.out.println("url>>>>>>>>>|"+url);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URI uri = new URIBuilder(url).setParameter("start","10").setParameter("end","20").build();

        HttpGet get = new HttpGet(uri);
        get.addHeader("user-agent","");

        String encoder = URLEncoder.encode("dsfas+sdf", StandardCharsets.UTF_8.name());
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(get);
            HttpEntity httpEntity = response.getEntity();
            String result = EntityUtils.toString(httpEntity);
            System.out.println(result);

            int code = response.getStatusLine().getStatusCode();
            Assert.assertEquals("result:"+result,200,code);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void downloadImage()  {
        String url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201810%" +
                "2F22%2F20181022214008_hKr8W.thumb.700_0.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,1" +
                "0000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616857138&t=67634b5850687aa59d69e25bb30db77ehttps://gimg2.baidu.com/i" +
                "mage_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201810%2F22%2F20181022214008_hKr8W.th" +
                "umb.700_0.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?s" +
                "ec=1616857138&t=67634b5850687aa59d69e25bb30db77e";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(get);
            HttpEntity httpEntity = response.getEntity();

            String suffix = "";
            String contentType = httpEntity.getContentType().getValue();
            System.out.println(contentType);
            if (contentType.contains("jpeg")|contentType.contains("jpg")){
                suffix = ".png";
            }
            String abcPath = "d:\\abc"+suffix;

            byte[] bytes = EntityUtils.toByteArray(httpEntity);
            FileOutputStream fos = new FileOutputStream(abcPath);
            fos.write(bytes);
            fos.close();
            EntityUtils.consume(httpEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){
        String result = testServer.getResult();
        System.out.println(result);

        String url = HttpUtil.buildUrl(localHost,getParamUrl);
        System.out.println(url);
    }

    @Test
    public void test4() throws IOException {
        String url = "http://localhost:8888/login";

        Map<String,String> params = new HashMap<>();
        params.put("username","zhangSan");
        params.put("password","123456");
        String result = HttpClientUtil.sendPost(url,params);
        System.out.println(result);

    }

    @Test
    public void testLogin() throws IOException {
        String url = HttpUtil.buildUrl(localHost,urlLogin);

        Map<String,String> params = new HashMap<>();
        params.put("username","zhangSan");
        params.put("password","123456");

        CookieStore cookies = HttpClientUtil.login(url,params);

        String urlUserList = HttpUtil.buildUrl(localHost,urlGetUserList);

        JSONObject paramJson = new JSONObject();
        paramJson.put("username","zhangSan");
        paramJson.put("password","123456");
        paramJson.put("sex","man");
        StringEntity stringEntity = new StringEntity(paramJson.toString(),"utf-8");
        String result = HttpClientUtil.sendPostWithCookies(urlUserList,cookies,stringEntity);
        System.out.println(result);
    }
}
