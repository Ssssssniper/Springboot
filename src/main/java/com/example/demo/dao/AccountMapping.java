package com.example.demo.dao;

import com.example.demo.bean.Account;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountMapping {
    public List<Account> getAll();
}
