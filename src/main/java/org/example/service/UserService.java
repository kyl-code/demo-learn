package org.example.service;

import org.example.dao.test1.UserSource1Dao;
import org.example.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Adam_Guo
 * @Date  2020/4/6
 * @Version 1.0
 **/
@Service
public class UserService {

    @Autowired
    private UserSource1Dao userDao;

    public Integer insert(User user){
        user.setBirthday(LocalDateTime.now());
        Integer count = userDao.insert(user);
        return count;
    }

    public List<User> selectAll(){
        List<User> list = userDao.selectAll();
        return list;
    }

    public User selectById(int id){
        return userDao.selectById(id);
    }

}
