package org.example;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.assertj.core.util.Lists;
import org.example.common.BlockThreadPool;
import org.example.dao.EventDao;
import org.example.model.RespBody;
import org.example.model.entity.Book;
import org.example.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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
        User user = new User();
        user.setUsername("test");
        user.setSex("男");
        user.setAddress("深圳市宝安区");
        user.setBirthday(LocalDateTime.now());
        eventDao.insert(user);
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
        BlockThreadPool pool = new BlockThreadPool(5);
        for(int i = 10000;i<100000;i++){
            User insert = new User();
            insert.setUsername("test" + i);
            insert.setSex("男");
            insert.setAddress("深圳市" + i + "区");
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    eventDao.insert(insert);
                }
            });
        }
    }

    @Test
    public void test6() {

    }

}
