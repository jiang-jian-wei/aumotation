package com.myBatisStudy;

import com.myBatisStudy.Dao.StudentDao;
import com.myBatisStudy.Dao.impl.StudentDaoImpl;
import com.myBatisStudy.domain.Student;
import org.testng.annotations.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void testSelectOne(){
        int id = 1;
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.selectById(id);

        System.out.println(student);
    }

    @Test
    public void testSelectStudents(){
        StudentDao studentDao = new StudentDaoImpl();

        List<Student> studentList = studentDao.selectStudents();

        for (Student stu : studentList){
            System.out.println("学生的实体类==="+stu);
        }
    }

    @Test
    public void testInsertStudent(){
        StudentDao studentDao = new StudentDaoImpl();

        Student student = new Student();
        student.setId(4);
        student.setName("liSi");
        student.setEmail("liSi@qq.com");
        student.setAge(35);

        studentDao.insertStudent(student);


    }
}
