package org.example.controller;

import io.swagger.annotations.Api;
import org.example.event.HandleEvent;
import org.example.model.RespBody;
import org.example.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api
public class EventController {
    @Autowired
    private HandleEvent handleEvent;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public RespBody<String> testEvent(@RequestParam String param){
        RespBody<String> respBody = new RespBody<>();
        handleEvent.handleSomething( param);
        respBody.setParam("success");
        return respBody;
    }

    @RequestMapping(value = "/testSession",method = RequestMethod.GET)
    public RespBody<String> testSession(@RequestBody String username, HttpServletRequest request){
        RespBody<String> respBody = new RespBody<>();
        HttpSession session = request.getSession();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        session.setAttribute("username",username);
        respBody.setParam("success");
        return respBody;
    }

    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    public RespBody<String> getSession(HttpServletRequest request){
        RespBody<String> respBody = new RespBody<>();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        respBody.setParam(username);
        HashMap map = new HashMap<>(8);
        Object b = map.put("1", "b");
        return respBody;
    }

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/test" , method = RequestMethod.POST)
    public void test(){
        Map<String , Integer> map = new HashMap<>();
        map.put("id", 7);
        //RespBody forObject = restTemplate.getForObject("http://127.0.0.1:8084/event/user/select?id={id}", RespBody.class, 7);
        User user = new User();
        user.setUsername("test");
        user.setSex("男");

        String uri = restTemplate.postForObject("http://127.0.0.1:8084/event/user/insert", user,String.class);
    }
}
