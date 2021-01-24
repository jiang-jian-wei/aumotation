package com.test.learning.groups;

import org.testng.annotations.Test;
@Test(groups = "stu")
public class GroupsOnClass2 {
    @Test
    public void stu1(){
        System.out.println("GroupsOnClass2 stu1111");
    }

    @Test
    public void stu2(){
        System.out.println("GroupsOnClass2 stu2222");
    }
}
