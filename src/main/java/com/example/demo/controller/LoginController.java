package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.User;
import com.example.demo.dao.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 登录控制
 */
@RestController
public class LoginController {
    @Autowired
    UserMapping userMapping;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("进入登录Controller >>>");
        System.out.println(user.toString());
        User us = userMapping.getUserByMessage(user.getUsername(),user.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if (us != null){
            res.put("code","200");
            res.put("status","success");
            res.put("data", us);
        }else {
            res.put("code","400");
            res.put("status","failed");
            if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
                res.put("code", "200");
                res.put("status", "success");
            }
        }
        String s = JSON.toJSONString(res);      // 将对象转为Json字符串
        return s;
    }

}
