package com.myBatisStudy;

import com.myBatisStudy.domain.Student;
import com.myBatisStudy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testSelectById(){
        SqlSession session = MyBatisUtil.getSqlSession();

        String sqlId = "com.myBatisStudy.Dao.StudentDao"+"."+"selectById";
        Student student = session.selectOne(sqlId,1);

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

        String sqlId = "com.myBatisStudy.Dao.StudentDao"+"."+"insertStudents";

        Student student = new Student();
        student.setId(3);
        student.setName("zhangSan");
        student.setEmail("zhangSan@qq.com");
        student.setAge(34);

        int rows = session.insert(sqlId,student);
        session.commit();
        System.out.println("插入student影响的行数："+rows);

        session.close();
    }

}
