package com.test.learning.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvide(String name,String sex,int age){
        System.out.println("姓名："+name+"\n性别："+sex+"\n年龄："+age);
    }
    @DataProvider(name = "data")
    public Object[][] dataProvide(){
        Object[][] objects= new Object[][]{
                {"张三","男",10},
                {"李四","男",15},
                {"小红","女",18}
        };
        return objects;
    }

    @Test(dataProvider = "method")
    public void test1(String name,String sex,int age){
        System.out.println("========test1方法========\n姓名："+name+"\n性别："+sex+"\n年龄："+age);
    }

    @Test(dataProvider = "method")
    public void test2(String name,String sex,int age){
        System.out.println("========test2方法========\n姓名："+name+"\n性别："+sex+"\n年龄："+age);
    }

    @DataProvider(name = "method")
    public Object[][] methodDataProvider(Method method){
        Object[][] objects = null;
        if (method.getName().equals("test1")){
            objects = new Object[][]{
                    {"张三","男",10},
                    {"李四","男",15}
            };
        }else if (method.getName().equals("test2")){
            objects = new Object[][]{
                    {"小红","女",14},
                    {"小燕子","女",18}
            };
        }
        return objects;
    }

}
