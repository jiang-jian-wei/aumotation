package com.mybatis.course;

public interface UserDao {

    User findById(Integer id);

    int insertUser(User user);

}
