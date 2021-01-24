package com.test.learning;

import org.testng.annotations.Test;

public class ExceptedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
