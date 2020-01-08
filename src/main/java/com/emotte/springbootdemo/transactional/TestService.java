package com.emotte.springbootdemo.transactional;

import com.emotte.springbootdemo.jdbctemplate.IAccountDAO;
import com.emotte.springbootdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService implements ITestService {

    @Autowired
    IAccountDAO accountDAO;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Transactional
    public void transfer() throws RuntimeException{
        Account account = new Account();
        account.setId(1);
        account.setMoney(210);
        account.setName("aaa");
        accountDAO.update(account);

        int i=1/0;

        Account account1 = new Account();
        account1.setId(2);
        account1.setMoney(220);
        account1.setName("bbb");
        accountDAO.update(account1);
    }


}
