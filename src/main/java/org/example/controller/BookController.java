package org.example.controller;

import io.swagger.annotations.Api;
import org.example.model.RespBody;
import org.example.model.entity.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Adam_Guo
 * @Date 2020/4/25
 * @Version 1.0
 **/
@RestController
@Api
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public RespBody<Integer> insert(@RequestBody @Validated Book book){
        Integer insert = bookService.insert(book);
        return  RespBody.RB.success(insert);
    }

    @RequestMapping("/cache")
    public RespBody<String> testCache(){
        RespBody<String> respBody = new RespBody<>();
        respBody.setParam("123");
        return respBody;
    }
}
