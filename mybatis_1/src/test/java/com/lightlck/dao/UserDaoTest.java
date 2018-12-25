package com.lightlck.dao;



import com.lightlck.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {
    public static void main(String[] args) throws IOException {
        //加载配置文件,获取文件流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSession工厂的构造器
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSession工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
        is.close();
    }

}
