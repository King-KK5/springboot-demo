package com.emotte.springbootdemo.jdbctemplate;

import com.emotte.springbootdemo.model.Account;
import com.emotte.springbootdemo.transactional.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountDAO accountDAO;

    @Autowired
    ITestService testService;

    @Autowired
    ITestService testService1;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }

    @Transactional
    public void transfer() throws RuntimeException{
        Account account = new Account();
        account.setId(1);
        account.setMoney(190);
        account.setName("aaa");
        accountDAO.update(account);//用户1减10块 用户2加10块

        int i=1/0;
        account.setId(2);
        account.setMoney(110);
        account.setName("bbb");
        accountDAO.update(account);
    }



}
