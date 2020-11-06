package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Menu;
import com.example.demo.common.Msg;
import com.example.demo.dao.MenuMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 菜单栏控制
 */

@RestController
public class MenuController {
    @Autowired
    MenuMapping menuMapping;

    @RequestMapping("/menu")
    public Msg getMenuList(){
        List<Menu> menuList = menuMapping.getMenuList();
        if (menuList!=null){
            System.out.println(Msg.success().add("data", menuList));
            return Msg.success().add("data", menuList);
        }else {
            return Msg.failed();
        }
    }
}
