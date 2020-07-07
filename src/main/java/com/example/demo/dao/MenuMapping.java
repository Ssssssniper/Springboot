package com.example.demo.dao;


import com.example.demo.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapping {
    public List<Menu> getMenuList();
}
