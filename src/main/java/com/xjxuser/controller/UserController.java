package com.xjxuser.controller;

import com.xjxuser.entity.UserEntity;
import com.xjxuser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<UserEntity> getAllUser() {
        List<UserEntity> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(Long userId) {
        System.out.println(userId);
        UserEntity user = userMapper.getOne(userId);
        return user;
    }

    @RequestMapping("/addUser")
    public ResponseEntity addUser(UserEntity userEntity) {
        System.out.println(userEntity);
        if (userEntity.nickname == null) {
            return ResponseEntity.badRequest().body("nickname can not be null");
        }
        userMapper.insert(userEntity);
        return ResponseEntity.ok("ok");
    }

    @RequestMapping("/update")
    public ResponseEntity updateUser(UserEntity userEntity) {
        userMapper.update(userEntity);
        return ResponseEntity.ok("ok");
    }

    @RequestMapping("/deleteUser")
    public ResponseEntity deleteUser(Long userId) {
        userMapper.delete(userId);
        return ResponseEntity.ok("ok");
    }

}
