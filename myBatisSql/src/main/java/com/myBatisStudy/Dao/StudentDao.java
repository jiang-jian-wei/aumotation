package com.myBatisStudy.Dao;

import com.myBatisStudy.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    Student selectById(int id);

    List<Student> selectStudents();

    int insertStudents(Student student);

    List<Student> selectByNameOrAge(@Param(value = "myName") String name, @Param(value = "myAge") int age);

    List<Student> selectByObject(Student student);

    List<Student> selectForEachOne(List<Integer> idList);

    List<Student> selectForEachTwo(List<Student> students);


}

