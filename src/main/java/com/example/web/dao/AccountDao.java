package com.example.web.dao;

import com.example.web.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountDao  extends JpaRepository<Account,Integer> {
    @Query("select t from Account t where t.id = ?1")
    public Account findAccountHandle(Integer id);

    @Query(value = "select * from account t where t.id = ?1", nativeQuery = true)
    public Account findAccountHandle2(Integer id);
}
