package com.test.learning.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    @Test
    public void teacher1(){
        System.out.println("GroupsOnClass3 teacher1");
    }

    @Test
    public void teacher2(){
        System.out.println("GroupsOnClass3 teacher2");
    }

}
