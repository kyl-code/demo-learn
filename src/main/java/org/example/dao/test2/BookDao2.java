package org.example.dao.test2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.entity.Book;

/**
 * @Author Adam_Guo
 * @Date 2020/4/14
 * @Version 1.0
 **/
@Mapper
public interface BookDao2 {
    @Insert("insert into book(name,price) " +
            "values(#{name},#{price})")
    Integer insert(Book book);
}
