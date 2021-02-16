package com.myBatisStudy.domain;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String email;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
