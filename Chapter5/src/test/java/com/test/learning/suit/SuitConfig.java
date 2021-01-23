package com.test.learning.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuitConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforeSuit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("afterSuit");
    }

    @BeforeTest
    public void before(){

    }
}
