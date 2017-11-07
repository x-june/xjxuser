package com.xjxuser.controller;

import com.xjxuser.entity.UserEntity;
import com.xjxuser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public ResponseEntity getAllUser() {
        List<UserEntity> users = userMapper.getAll();
        return responseWith(1, users);
    }

    @RequestMapping("/getUser")
    public ResponseEntity getUser(Long userId) {
        System.out.println(userId);
        UserEntity user = userMapper.getOne(userId);
        return responseWith(1, user);
    }

    @RequestMapping("/addUser")
    public ResponseEntity addUser(UserEntity userEntity) {
        System.out.println(userEntity);
        if (userEntity.nickname == null) {
            return ResponseEntity.badRequest().body("missing nickname");
        }
        if (userEntity.password == null) throw new AssertionError();
        int result = userMapper.insert( userEntity);
        return responseWith(result, userMapper.getOne(userEntity.userId));
    }

    @RequestMapping("/update")
    public ResponseEntity updateUser(UserEntity userEntity) {
        if (userEntity.userId == null) {
            return ResponseEntity.badRequest().body("missing userId");
        }
//        UserEntity theUser = userMapper.getOne(userEntity.userId);
//        if (theUser == null) {
//            return ResponseEntity.badRequest().body("can't find user");
//        }

        int result = userMapper.update(userEntity);
        return responseWith(result, userMapper.getOne(userEntity.userId));
    }

    @RequestMapping("/deleteUser")
    public ResponseEntity deleteUser(Long userId) {
        int result = userMapper.delete(userId);
        return responseWith(result);
    }

    @RequestMapping("/zeroException")
    public int zeroException() {
        return 100/0;
    }

}
