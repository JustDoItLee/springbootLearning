package com.example.web.dao;

import com.example.web.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Insert("insert into account2(name, money) values(#{name}, #{money})")
    int add(@Param("name") String name, @Param("money") double money);

//    @Update("update account2 set name = #{name}, money = #{money} where id = #{id}")
//    int update(@Param("name") String name, @Param("money") double money, @Param("id") int  id);

    @Delete("delete from account2 where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account2 where id = #{id}")
    Account findAccount(@Param("id") int id);

    @Select("select id, name as name, money as money from account2")
    List<Account> findAccountList();

    int update( @Param("money") double money, @Param("id") int  id);
}
