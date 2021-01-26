package com.test.learning;

import org.testng.annotations.*;

public class TestCases {

    @Test
    public void testOne (){
        System.out.println("testOne这是第一个测试用例！！！");
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void testTwo (){
        System.out.println("testTwo，this is the second TestCase!!!");
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }

    @BeforeMethod
    public void testBeforeMethod(){
        System.out.println("BeforeTest测试用例执行的前置条件！！！");
    }

    @AfterMethod
    public void testAfterMethod(){
        System.out.println("AfterTest测试用例执行结束！！！");
    }

    @BeforeClass
    public void testBeforeClass(){
        System.out.println("BeforeClass 测试类开始执行~~~");
    }

    @AfterClass
    public void testAfterClass(){
        System.out.println("AfterClass 测试类执行结束~~~");
    }

    @BeforeSuite
    public void testBeforeSuit(){
        System.out.println("BeforeSuit 测试套件");
    }

    @AfterSuite
    public void testAfterSuit(){
        System.out.println("AfterSuit 测试套件");
    }

}
