package com.example.demo.dao;


import com.example.demo.bean.Employee;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmployeeMapping{
    public List<Employee> getAll();
}
