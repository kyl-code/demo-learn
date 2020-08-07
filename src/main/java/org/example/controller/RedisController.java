package org.example.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import org.example.model.RespBody;
import org.example.model.entity.Book;
import org.example.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class RedisController extends BaseController{

    @Autowired
    private RedisService redisService;

    private static final String KEY = "book";

    @PostMapping("/setCache")
    public RespBody<T> set(@RequestBody Book book){
        redisService.set(KEY, JSONObject.toJSONString(book));
        return successData();
    }

    @RequestMapping("/getCache")
    public RespBody get(){
        String result = redisService.get(KEY);
        Book book = JSONObject.parseObject(result, Book.class);
        return successData(book);
    }

    @RequestMapping("/delCache")
    public RespBody<T> del(){
        redisService.remove(KEY);
        return successData();
    }
}
