package org.example.dao.test2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.model.entity.User;

import java.util.List;

@Mapper
public interface UserSource2Dao {

    @Insert("insert into user(username,sex,address,birthday) " +
            "values(#{username},#{sex},#{address},#{birthday})")
    Integer insert(User user);

    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") int id);
}
