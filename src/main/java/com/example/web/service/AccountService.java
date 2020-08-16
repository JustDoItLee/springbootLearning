package com.example.web.service;

import com.example.web.dao.AccountMapper;
import com.example.web.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

//    public int update(String name, double money, int id) {
//        return accountMapper.update(name, money, id);
//    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }

    @Transactional
    public int transfer() throws RuntimeException {
        accountMapper.update(90, 4);//用户1减10块 用户2加10块
        int i = 1 / 0;
        int response = accountMapper.update(110, 5);
        return response;
    }
}
