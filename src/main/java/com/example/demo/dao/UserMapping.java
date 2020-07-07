package com.example.demo.dao;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapping {
    public User getUserByMessage(@Param("username")String username,@Param("password")String password);
//    public User getUserByName(@Param("username")String username);
}
