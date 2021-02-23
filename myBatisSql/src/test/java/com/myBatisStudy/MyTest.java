package com.myBatisStudy;

import com.myBatisStudy.Dao.StudentDao;
import com.myBatisStudy.domain.Student;
import com.myBatisStudy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void testSelectById(){
        SqlSession session = MyBatisUtil.getSqlSession();

        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectById(1);

        System.out.println("学生的实体类==="+student);

        session.close();
    }

    @Test
    public void testSelectStudents(){
        SqlSession session = MyBatisUtil.getSqlSession();

        String sqlId = "com.myBatisStudy.Dao.StudentDao"+"."+"selectStudents";
        List<Student> selectList= session.selectList(sqlId);

        for (Student stu : selectList){
            System.out.println("学生的实体类==="+stu);
        }
        session.close();
    }

    @Test
    public void testInsertStudents(){
        SqlSession session = MyBatisUtil.getSqlSession();

        StudentDao dao = session.getMapper(StudentDao.class);


        Student student = new Student();
        student.setName("王五");
        student.setEmail("Wangwu@qq.com");
        student.setAge(45);

        int rows = dao.insertStudents(student);
        session.commit();
        System.out.println("插入student影响的行数："+rows);

        session.close();
    }

    @Test
    public void testSelectForEachOne(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);

        List<Student> studentList = dao.selectForEachOne(idList);

        studentList.forEach(student -> System.out.println(student));

        session.close();
    }

    @Test
    public void testSelectForEachTwo(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> students = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setId(1);
        Student stu2 = new Student();
        stu2.setId(2);

        students.add(stu1);
        students.add(stu2);

        List<Student> studentList = dao.selectForEachTwo(students);

        studentList.forEach(student -> System.out.println(student));

        session.close();
    }

}
