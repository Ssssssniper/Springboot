package com.example.demo.dao;

import com.example.demo.bean.Dcdata;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface DcDataMapping {
    // 10版数据结构 获取所有道岔名
    public List<String> get10dcname();
    // 按名字 条件查询
    public List<Dcdata> selectByName(@Param("dcname") String dcname);
    // 根据信息获取曲线数据
    public List<Dcdata> getDcdata(@Param("dcname") String dcname, @Param("time") String time, @Param("typeno") String typeno);

    // 18版数据结构
    public List<Dcdata> get18All();

}
