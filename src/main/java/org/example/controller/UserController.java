package org.example.controller;

import io.swagger.annotations.Api;
import org.example.annotation.FeignMesage;
import org.example.model.RespBody;
import org.example.model.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public RespBody<Integer> insert( User user){
        RespBody<Integer> respBody = new RespBody<>();
        Integer insert = userService.insert(user);
        respBody.setParam(insert);
        return respBody;
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @FeignMesage(value = "123")
    public RespBody<User> select(@RequestParam("id")  Integer id){
        RespBody<User> respBody = new RespBody<>();
        User user = userService.selectById(id);
        respBody.setParam(user);
        return respBody;
    }
}
