package com.emotte.springbootdemo.mybatis.mapper.test1;


import com.emotte.springbootdemo.model.User;

import java.util.List;

public interface User1Mapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    List<User> selectUsers();
}