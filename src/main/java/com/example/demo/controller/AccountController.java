package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.common.Msg;
import com.example.demo.dao.UserMapping;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *  用户权限
 *
 */

@RestController
public class AccountController {
    @Autowired
    UserMapping userMapping;

//    @RequestMapping("/account")           // 接收任何类型的请求
    @GetMapping("/account")       // 指定接收get请求
    public Msg getAccount(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 10);
        List<User> res = userMapping.getAll();
        PageInfo page = new PageInfo(res, 5);
        return Msg.success().add("data", page);
    }

    /**
     *  平台新增登录用户
     * @return
     */
    @PostMapping("/adduser")
    public Msg addAccount(@RequestBody User newUser){
        System.out.println(newUser);
        newUser.setStatus(1);
        Boolean res = userMapping.addUser(newUser);
        if (!res){
            return Msg.failed();
        }
        return Msg.success();
    }

    /**
     * 删除用户         @RequestBody 不支持@GetMapping
     */
    @PostMapping("/deluser")
    public Msg delAccount(@RequestBody User delUser){
        System.out.println(delUser);

        Boolean res = userMapping.delUser(delUser);
        if (!res){
            return Msg.failed();
        }
        return Msg.success();
    }
}
