package com.example.web.controller;

import com.example.web.dao.AccountDao;
import com.example.web.entity.Account;
import com.example.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountDao.findAccountHandle2(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        Account account1 = accountDao.saveAndFlush(account);

        return account1.toString();

    }

    @RequestMapping(value = "/postAccount", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        Account account1 = accountDao.save(account);
        return account1.toString();
    }

    @RequestMapping(value = "/postAccountByMybatis", method = RequestMethod.POST)
    public String postAccountByMybatis(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "money") double money) {

        int t = accountService.add(name, money);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping(value = "/list2", method = RequestMethod.GET)
    public List<Account> getAccountsByMabatis() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transfer() {
        int i = accountService.transfer();
        if (i > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}