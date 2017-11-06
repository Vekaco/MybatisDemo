package demo.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import demo.mybatis.util.MybatisUtil;
import demo.mybatis.vo.Order;

/**
 * 表字段与实体类变量名不一致的处理方案
 * 
 * @author KaikaiFu
 *
 */
public class OrderMapperUnitTest {
    @Test
    public void testGetOrderById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
         * getOrderById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "demo.mybatis.mapping.orderMapper.getOrderById";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(order);// 打印结果：null，也就是没有查询出相应的记录
    }

    @Test
    public void testGetOrderById2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
         * selectOrder是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "demo.mybatis.mapping.orderMapper.selectOrder";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(order);// 打印结果：Order [id=1, orderNo=aaaa, price=23.0]
    }

    @Test
    public void testGetOrderById3() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
         * selectOrderResultMap是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "demo.mybatis.mapping.orderMapper.selectOrderResultMap";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(order);// 打印结果：Order [id=1, orderNo=aaaa, price=23.0]
    }
}
