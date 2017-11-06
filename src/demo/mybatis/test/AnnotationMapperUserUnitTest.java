package demo.mybatis.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import demo.mybatis.mapping.UserMapperInterface;
import demo.mybatis.util.MybatisUtil;
import demo.mybatis.vo.User;

public class AnnotationMapperUserUnitTest {
    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        // 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperInterface.class)动态构建出来
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        User user = new User();
        user.setUsername("annotationUser");
        user.setPassword("annotation");
        int add = mapper.add(user);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(add);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        // 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperInterface.class)动态构建出来
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        User user = new User();
        user.setUserid(3);
        user.setUsername("annotationUser-update");
        user.setPassword("annotation-update");
        // 执行修改操作
        int retResult = mapper.update(user);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        // 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperInterface.class)动态构建出来
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        // 执行删除操作
        int retResult = mapper.deleteById(7);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testGetUser() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperInterface.class)动态构建出来
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        // 执行查询操作，将查询结果自动封装成User返回
        User user = mapper.getById(8);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void testGetAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperInterface.class)动态构建出来
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        // 执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = mapper.getAll();
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstUsers);
    }
}
