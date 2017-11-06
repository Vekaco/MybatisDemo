package demo.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import demo.mybatis.util.MybatisUtil;
import demo.mybatis.vo.User;

public class XmlMapperUnitTest {

    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
         */
        String statement = "demo.mybatis.mapping.userMapper.addUser";// 映射sql的标识字符串
        User user = new User();
        user.setUsername("kaikai");
        user.setPassword("123456");
        // 执行插入操作
        int retResult = sqlSession.insert(statement, user);
        // 手动提交事务
        // sqlSession.commit();
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
         */
        String statement = "demo.mybatis.mapping.userMapper.updateUser";// 映射sql的标识字符串
        User user = new User();
        user.setUserid(3);
        user.setUsername("kaikai");
        user.setPassword("654321");
        // 执行修改操作
        int retResult = sqlSession.update(statement, user);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
         */
        String statement = "demo.mybatis.mapping.userMapper.deleteUser";// 映射sql的标识字符串
        // 执行删除操作
        int retResult = sqlSession.delete(statement, 2);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testGetAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "demo.mybatis.mapping.userMapper.getAllUsers";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = sqlSession.selectList(statement);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstUsers);
    }
}
