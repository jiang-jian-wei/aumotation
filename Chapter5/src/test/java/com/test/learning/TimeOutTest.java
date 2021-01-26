package com.test.learning;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)
    public void timeOutSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 3000)
    public void timeOutFailed() throws InterruptedException {
        Thread.sleep(4000);
    }
}
