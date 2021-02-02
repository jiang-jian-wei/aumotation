package com.course.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String username;
    private String password;
    private String name;
    private String age;
    private String sex;

    public void getName(){

    }
}
