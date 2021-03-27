package com.gloryroad.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;

public class LoginPage {
    @FindBy(xpath="//iframe[contains(@id,'x-URS-iframe')]")
    private WebElement iframe;

    @FindBy(xpath="//input[contains(@placeholder,'邮箱帐号或手机号码')]")
    private WebElement userName;

    @FindBy(xpath="//*[contains(@data-placeholder,'输入密码')]")
    private WebElement password;

    @FindBy(id="dologin")
    private WebElement loginButton;


    private String title = "网易免费邮";

    public WebDriver webDriver;

    static {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
    }

    public LoginPage(){
        webDriver = new ChromeDriver();
        PageFactory.initElements(webDriver,this);
    }

    // 访问被测试网址的封装方法
    public void load(String url){
        webDriver.get(url);
    }

    // 进入frame方法
    public void switchFrame(){
        webDriver.switchTo().frame(iframe);
    }

    // 退出frame方法
    public void defaultFrame(){
        webDriver.switchTo().defaultContent();
    }

    // 关闭浏览器
    public void quit(){
        webDriver.quit();
    }

    // 登录操作的封装方法
    public void login(){
        userName.sendKeys("testman2020");
        password.sendKeys("123456");
        loginButton.click();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
