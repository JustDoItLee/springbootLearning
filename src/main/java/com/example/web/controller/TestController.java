package com.example.web.controller;

import com.example.web.bean.ConfigBean;
import com.example.web.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class TestController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/test")
    public String test() {
        return name + ":" + age;
    }

    @RequestMapping(value = "/lucy")
    public String miya(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @Autowired
    User user;
    @RequestMapping(value = "/user")
    public String user(){
        return user.getName()+user.getAge();
    }
}
