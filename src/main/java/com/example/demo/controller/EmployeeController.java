package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeMapping employeeMapping;

    @RequestMapping("/emps")
    public String getEmp(){
        List<Employee> all = employeeMapping.getAll();
        System.out.println("login");
        HashMap<String, Object> res = new HashMap<>();
        if (all!=null){
            res.put("code", "200");
            res.put("status", "success");
            res.put("data", all);
        }else{
            res.put("code", "400");
            res.put("status", "failed");
        }
        String s = JSON.toJSONString(res);
        return s;
    }
}
