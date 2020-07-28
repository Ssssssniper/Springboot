package com.example.demo.controller;

import com.example.demo.bean.Account;
import com.example.demo.common.Msg;
import com.example.demo.dao.AccountMapping;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountMapping accountMapping;

    @RequestMapping("/account")
    public Msg getAccount(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 10);
        List<Account> res = accountMapping.getAll();
        PageInfo page = new PageInfo(res, 5);
        return Msg.success().add("data", page);
    }
}
