package com.xjxuser.mapper;

import com.xjxuser.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends Mapper {
    List<UserEntity> getAll();
    UserEntity getOne(Long id);
    int insert(UserEntity user); //return > 0 success;
    int update(UserEntity user);
    int delete(Long id);
}
