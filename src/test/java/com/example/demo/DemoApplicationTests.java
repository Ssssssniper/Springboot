package com.example.demo;


import com.example.demo.dao.EmployeeMapping;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    EmployeeMapping employeeMapping;

    @Test
    void contextLoads() {


//        List<Employee> all = employeeMapping.getAll();
//        System.out.println(all);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("csm"));
    }

}
