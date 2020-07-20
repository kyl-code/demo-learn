package org.example;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.assertj.core.util.Lists;
import org.example.dao.test1.EventDao;
import org.example.model.RespBody;
import org.example.model.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private EventDao eventDao;

    @Test
    public void test1() {
    }

    @Test
    public void test3() {
        final int a = 1;
        List<Book> bookList = Lists.newArrayList();
        Map<Integer, String> collect = bookList.stream().collect(Collectors.toMap(book -> book.getId(), book -> book.getName()));
    }

    @Test
    public void test4(){
        RespBody<List<Book>> responseBody = new RespBody();
        responseBody.setCode("12");
        responseBody.setMessage("124");
        List<Book> list = Lists.newArrayList();
        Book book = new Book();
        book.setPrice(100.1);
        book.setName("name");
        list.add(book);
        responseBody.setParam(list);
        Object o = JSONObject.toJSON(responseBody);
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(o.toString(), JsonObject.class);
        Map<String, String> result = gson.fromJson(json.get("param"), Map.class);
        String name = result.get("name");
        System.err.println(name);
    }

    @Test
    public void test5() {
        String str = "123";
        Assert.assertEquals("123",str);
    }

    @Test
    public void test6() {
    }

    public static void main(String[] args) {


    }

}
