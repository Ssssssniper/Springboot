package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Employee;
import com.example.demo.common.Msg;
import com.example.demo.dao.EmployeeMapping;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeMapping employeeMapping;

//    @RequestMapping("/emps")
    @GetMapping("/emps")
    @ResponseBody
    public Msg getEmp(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,10);
        List<Employee> all = employeeMapping.getAll();
        PageInfo page = new PageInfo(all,5);
        System.out.println("用户信息获取："+page);
        return Msg.success().add("data", page);
    }

    /**
     * 根据姓名和部门进行查询
     * @return
     */
    @PostMapping(value = {"/queryemps/{name}/{gender}","/queryemps/{name}"})
    @ResponseBody
    public Msg querEmp(@PathVariable(required = true) String name,@PathVariable(required = false) String gender){
        PageHelper.startPage(1, 10);
        List<Employee> employees = employeeMapping.selectBycondition(name,gender);
        PageInfo page = new PageInfo(employees, 5);
        System.out.println("条件："+name+"性别："+gender+"查询结果："+page);
        return Msg.success().add("data", page);
}

//    @RequestMapping("/addemps")
    @PostMapping("/addemps")
    @ResponseBody
    public Msg addEmp(@RequestBody Employee employee){
        return Msg.success();
    }
}
