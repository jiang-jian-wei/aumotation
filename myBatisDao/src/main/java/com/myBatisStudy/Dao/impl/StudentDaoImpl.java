package com.myBatisStudy.Dao.impl;

import com.myBatisStudy.Dao.StudentDao;
import com.myBatisStudy.domain.Student;
import com.myBatisStudy.utils.MyBatisUtil;
import com.myBatisStudy.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectById(int id) {
        SqlSession session = MyBatisUtil.getSqlSession();

        String sqlId = "com.myBatisStudy.Dao.StudentDao"+"."+"selectById";
        Student student = session.selectOne(sqlId,id);
        session.close();
        return student;
    }

    @Override
    public List<Student> selectStudents() {
        SqlSession session = MyBatisUtil.getSqlSession();

        String sqlId = "com.myBatisStudy.Dao.StudentDao"+"."+"selectStudents";
        List<Student> selectList= session.selectList(sqlId);

        session.close();
        return selectList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MyBatisUtil.getSqlSession();

        String sqlId = "com.myBatisStudy.Dao.StudentDao"+"."+"insertStudents";

        int rows = session.insert(sqlId,student);
        session.commit();
        session.close();
        return rows;
    }

    @Override
    public List<Student> selectByNameOrAge(String name, int age) {
        return null;
    }

    @Override
    public List<Student> selectByObject(Student student) {
        return null;
    }

    @Override
    public List<Student> selectQueryParam(QueryParam queryParam) {
        return null;
    }
}
