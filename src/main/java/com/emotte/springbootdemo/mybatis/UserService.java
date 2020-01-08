package com.emotte.springbootdemo.mybatis;

import com.emotte.springbootdemo.model.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

    int addUser(User user);

    User getUser(int id);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    String getUserPhone();

}
