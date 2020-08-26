package com.example.demo.dao;

import com.example.demo.bean.Dcdata;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DcDataMapping {
    // 10版数据结构
    public List<Dcdata> get10All();
    // 按名字 条件查询
    public List<Dcdata> selectByName(@Param("dcname") String dcname);
    // 18版数据结构
    public List<Dcdata> get18All();

}
