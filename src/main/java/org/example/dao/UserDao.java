package org.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.model.entity.User;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert("insert into user(username,sex,address,birthday) " +
            "values(#{username},#{sex},#{address},#{birthday})")
    Integer insert(User user);

    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") int id);
}
