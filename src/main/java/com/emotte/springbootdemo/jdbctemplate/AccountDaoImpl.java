package com.emotte.springbootdemo.jdbctemplate;

import com.emotte.springbootdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDAO {

    /*@Autowired  //按类型注入，多数据源时需要指定优先使用哪一个
    private JdbcTemplate jdbcTemplate;*/

    /*@Resource(name = "firstJdbcTemplate")
    JdbcTemplate jdbcTemplate;*/

    @Resource(name = "secondJdbcTemplate")  //按名称注入
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert into account(name, money) values(?, ?)",
                account.getName(),account.getMoney());

    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE  account SET NAME=? ,money=? WHERE id=?",
                account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE account where id=?",id);
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            Account account = list.get(0);
            return account;
        }else{
            return null;
        }
    }

    @Override
    public List<Account> findAccountList() {
        List<Account> list = jdbcTemplate.query("select * from account", new Object[]{}, new BeanPropertyRowMapper(Account.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


}
