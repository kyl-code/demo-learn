package org.example.service;

import org.example.dao.test1.BookDao1;
import org.example.dao.test2.BookDao2;
import org.example.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Adam_Guo
 * @Date 2020/4/25
 * @Version 1.0
 **/
@Service
public class BookService {
    @Autowired
    private BookDao1 bookDao1;
    @Autowired
    private BookDao2 bookDao2;

    public Integer insert(Book book){
        if(book.getPrice().intValue() > 10){
            return bookDao1.insert(book);
        }else {
            return bookDao2.insert(book);
        }
    }

}
