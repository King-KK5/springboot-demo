package com.emotte.springbootdemo.transactional;

import com.emotte.springbootdemo.model.Account;

public interface ITestService {

    int add(Account account);

    void transfer();

}
