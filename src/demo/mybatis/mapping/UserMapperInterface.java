package demo.mybatis.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import demo.mybatis.vo.User;

public interface UserMapperInterface {
  //使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into user(username, password) values(#{username}, #{password})")
    public int add(User user);
    
    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from user where userid=#{userid}")
    public int deleteById(int id);
    
    //使用@Update注解指明update方法要执行的SQL
    @Update("update user set username=#{username},password=#{password} where userid=#{userid}")
    public int update(User user);
    
    //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from user where userid=#{userid}")
    public User getById(int id);
    
    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from user")
    public List<User> getAll();
}
