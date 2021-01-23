package com.test.learning;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignoreTestOne(){
        System.out.println("ignoreOne Start");
    }

    @Test(enabled = false)
    public void ignoreTestTwo(){
        System.out.println("ignoreTwo Start");
    }
}
