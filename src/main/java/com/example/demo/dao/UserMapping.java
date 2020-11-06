package com.example.demo.dao;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapping {
    // 根据登录信息查库
    User getUserByMessage(@Param("username")String username,@Param("password")String password);
//    public User getUserByName(@Param("username")String username);
    // 获取所有用户
    List<User> getAll();
    // 添加用户
    Boolean addUser(User newUser);
    // 删除用户
    Boolean delUser(User delUser);
}
