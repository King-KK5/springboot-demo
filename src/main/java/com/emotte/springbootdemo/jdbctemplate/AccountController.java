package com.emotte.springbootdemo.jdbctemplate;

import com.emotte.springbootdemo.exception.AccountNotFoundException;
import com.emotte.springbootdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    private static Map<String, Account> accountRepo = new HashMap<>();
    static {
        Account honey = new Account();
        honey.setId(1);
        honey.setName("Honey");
        accountRepo.put(String.valueOf(honey.getId()), honey);
        Account almond = new Account();
        almond.setId(2);
        almond.setName("Almond");
        accountRepo.put(String.valueOf(almond.getId()), almond);
    }

    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "money" ,required = true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t=accountService.update(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        int t= accountService.add(account);
        if(t==1){
            return account.toString();
        }else {
            return "fail";
        }

    }


    @RequestMapping(value = "/transfer",method = {RequestMethod.GET,RequestMethod.POST})
    public String transfer() {
        try {
            accountService.transfer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "transactional";
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody Account account) {
        if(accountService.findAccountById(id) != null) throw new AccountNotFoundException();

        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }


}
