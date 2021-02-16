package com.myBatisStudy;

import com.myBatisStudy.Dao.StudentDao;
import com.myBatisStudy.domain.Student;
import com.myBatisStudy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class MyTest3 {
    @Test
    public void selectById(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = studentDao.selectById(2);

        System.out.println(student.toString());
    }

    @Test
    public void selectStudents(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao studentDao= session.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectStudents();

        for(Student student:studentList){
            System.out.println(student);
        }

        session.close();
    }

    @Test
    public void selectNameOrAge (){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> studentList = dao.selectByNameOrAge("jjj",18);

        studentList.forEach(student -> System.out.println(student.toString()));

        session.close();
    }

    @Test
    public void testSelectByObject(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("jjw");
        student.setAge(11);
        List<Student> studentList = studentDao.selectByObject(student);

        studentList.forEach(student1 -> System.out.println(student1));

        session.close();
    }
}
