//package com.example.demo.service;
//
//import com.example.demo.bean.User;
//import com.example.demo.dao.UserMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 身份认证
// */
//@Service("UserService")
//public class UserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserMapping userMapping;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        User user = userMapping.getUserByName(username);
//
//        if (username == null || "".equals(username)){
//            throw new RuntimeException("用户不能为空");
//        }
//        if (user == null){
//            throw new RuntimeException("无此用户");
//        }
//        else if (user.getRole().equals("管理员")){
//            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("管理员");
//            authorities.add(grantedAuthority);
//            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
//        }else if (user.getRole().equals("普通用户")){
//            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("普通用户");
//            authorities.add(grantedAuthority);
//            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
//        }
//        else{
//            throw new UsernameNotFoundException("not found");
//        }
//    }
//}
