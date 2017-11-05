package com.xjxuser.mapper;

import com.xjxuser.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends Mapper {
    List<UserEntity> getAll();
    UserEntity getOne(Long id);
    void insert(UserEntity user);
    void update(UserEntity user);
    void delete(Long id);
}
