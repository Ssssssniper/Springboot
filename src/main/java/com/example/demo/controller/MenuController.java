package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Menu;
import com.example.demo.dao.MenuMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuMapping menuMapping;

    @RequestMapping("/menu")
    public String getMenuList(){
        List<Menu> menuList = menuMapping.getMenuList();
        HashMap<String, Object> res = new HashMap<>();
        if (menuList!=null){
            res.put("code", "200");
            res.put("status", "success");
            res.put("data", menuList);
        }else {
            res.put("code", "400");
            res.put("status", "failed");
        }
        String s = JSON.toJSONString(res);
        return s;
    }
}
