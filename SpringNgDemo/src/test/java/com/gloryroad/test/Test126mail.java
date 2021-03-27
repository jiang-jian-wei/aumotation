package com.gloryroad.test;

import com.gloryroad.pageobjects.LoginPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest(classes = Application.class)
@SpringBootApplication
public class Test126mail extends CaseBase{

    @Value("${url.email}")
    private String urlEmail;

    @Test
    public void testLogin() throws InterruptedException {
        // 生成一个LoginPage对象
        LoginPage loginPage = new LoginPage();

        // 调用登录页面对象的load方法访问被测试网址
        loginPage.load(urlEmail);

        // 进入frame
        loginPage.switchFrame();

        // 登录操作
        loginPage.login();

        // 关闭浏览器
        Thread.sleep(5000);
        loginPage.quit();
    }
}
