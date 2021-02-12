package Test;

import com.mybatis.course.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

public class UserTest {

    @Test
    public void findByIdTest() throws IOException {
        // 定义读取文件名
        String resources = "mybatis-config.xml";
        // 创建流
        InputStream inputStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = factory.openSession();

        String sqlId = "com.mybatis.course.UserDao" +"."+"findById";

        User user =  sqlSession.selectOne(sqlId,1);

        System.out.println(user.toString());

        System.out.println(user.getUage());

        sqlSession.close();

    }

    @Test
    public void testInsertUser() throws IOException {
        // 定义读取文件名
        String resources = "mybatis-config.xml";
        // 创建流
        InputStream inputStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = factory.openSession();

        String sqlId = "com.mybatis.course.UserDao" +"."+"insertUser";

        User user = new User();
        user.setUid(4);
        user.setUname("赵六");
        user.setUage(45);

        int rows =  sqlSession.insert(sqlId,user);

        System.out.println("插入用户影响的数据库行数："+rows);

        sqlSession.commit();

        sqlSession.close();

    }
}
