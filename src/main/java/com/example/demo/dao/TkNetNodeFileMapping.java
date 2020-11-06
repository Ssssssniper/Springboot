package com.example.demo.dao;

import com.example.demo.bean.TkNetNodeFile;
import org.springframework.stereotype.Repository;

@Repository
public interface TkNetNodeFileMapping {
    Boolean saveFile(TkNetNodeFile file);
}
