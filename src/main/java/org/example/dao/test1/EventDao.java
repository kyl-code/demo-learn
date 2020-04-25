package org.example.dao.test1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.entity.User;

@Mapper
public interface EventDao {

    @Insert("insert into user(username,sex,address,birthday) " +
            "values(#{username},#{sex},#{address}, now())")
    Integer insert(User user);
}
