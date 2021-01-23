package com.test.learning.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "sever")
    public void test1 (){
        System.out.println("这是服务端的测试11111111111");
    }

    @Test(groups = "sever")
    public void test2 (){
        System.out.println("这是服务端的测试22222222222");
    }

    @Test(groups = "client")
    public void test3 (){
        System.out.println("这是客户端的测试33333333333");
    }

    @Test(groups = "client")
    public void test4 (){
        System.out.println("这是客户端的测试444444444444");
    }

    @BeforeGroups("sever")
    public void beforeGroupOnSever(){
        System.out.println("这是服务端组运行之前的方法");
    }

    @AfterGroups("sever")
    public void afterGroupOnSever(){
        System.out.println("这是服务端组运行之后的方法！！！！！！！！！！！！！！");
    }

    @BeforeGroups("client")
    public void beforeGroupOnClient(){
        System.out.println("这是客户端组运行之前的方法");
    }

    @AfterGroups("client")
    public void afterGroupOnClient(){
        System.out.println("这是客户端组运行之后的方法！！！！！！！！！！");
    }
}
