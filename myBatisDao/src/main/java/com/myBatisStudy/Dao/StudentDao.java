package com.myBatisStudy.Dao;

import com.myBatisStudy.domain.Student;
import com.myBatisStudy.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    Student selectById(int id);

    List<Student> selectStudents();

    int insertStudent(Student student);

    List<Student> selectByNameOrAge(@Param(value = "myName") String name, @Param(value = "myAge") int age);

    List<Student> selectByObject(Student student);

    List<Student> selectQueryParam(QueryParam queryParam);

}

