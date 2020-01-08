package com.emotte.springbootdemo.mybatis;


import com.emotte.springbootdemo.model.User;
import com.emotte.springbootdemo.mybatis.mapper.UserMapper;
import com.emotte.springbootdemo.mybatis.mapper.test1.User1Mapper;
import com.emotte.springbootdemo.mybatis.mapper.test2.User2Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {


    //@Autowired
    //private UserMapper userMapper; //这里会报错，但是并不会影响

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public int addUser(User user) {
        return user1Mapper.insert(user);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = user2Mapper.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    //默认地 只 在抛出运行时和unchecked exceptions时才标识事务回滚。（Errors 也一样 - 默认地 - 标识事务回滚。）
    //@Transactional(rollbackFor = Exception.class)  //异常checked例外也回滚
    //@Transactional(notRollbackFor=RunTimeException.class)  //让unchecked例外不回滚
    //propagation 事务传递
    //isolation 事务隔离级别
    @Transactional
    @Override
    public String getUserPhone() {
        try {
            User user = user1Mapper.selectByPrimaryKey(1);
            user.setPhone(user.getPhone() + "0");
            user1Mapper.updateByPrimaryKey(user);


            User user1 = user1Mapper.selectByPrimaryKey(1);
            user1.setPhone(user1.getPhone() + "0");
            user1Mapper.updateByPrimaryKey(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(int id) {
        return user1Mapper.selectByPrimaryKey(id);
    }
}
