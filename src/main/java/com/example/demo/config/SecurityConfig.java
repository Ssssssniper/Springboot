//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    @Qualifier("UserService")
//    private UserDetailsService userDetailsService;
//
//    // 密码加密
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
//    // 可对用户密码进行加密
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().disable();
//        http.csrf().disable().formLogin().defaultSuccessUrl("/home").permitAll();
////                .authorizeRequests()
////                .antMatchers("/").permitAll()
////                .antMatchers("/display").hasRole("管理员")
////                .antMatchers("/home").hasAnyRole("管理员","普通用户")
////                .antMatchers("/home/**").hasAnyRole("管理员","普通用户")
////                .antMatchers("/home/welcome").permitAll()
////                .anyRequest().permitAll()
////                .and().anonymous()
////                .and().formLogin().loginPage("http://localhost:8080/#/home").loginProcessingUrl("/home").permitAll();           // 使用自定义的登录界面
//    }
//}
