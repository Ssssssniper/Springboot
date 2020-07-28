package com.example.demo.dao;


import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmployeeMapping{
    public List<Employee> getAll();

    // 条件查询
    public List<Employee> selectBycondition(@Param("name") String name, @Param("gender") String gender);
}
