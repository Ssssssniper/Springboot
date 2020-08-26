package com.example.demo.controller;

import com.example.demo.bean.Dcdata;
import com.example.demo.common.Msg;
import com.example.demo.dao.DcDataMapping;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

// 道岔数据的查询

/**
 * 10版组织道岔的数据结构get10All（）：    道岔名  时间  频率  [-A ， 曲线值， 动作方向]
 */

@RestController
public class DcDataController {

    @Autowired
    DcDataMapping dcDataMapping;

    @RequestMapping("/display")
    @ResponseBody
    public Msg getDcname(@RequestParam(value = "database",defaultValue = "true") Boolean database){
        System.out.println(database);
        List<Dcdata> dcdata;
        Set<String> name = new HashSet<>();         // 存储道岔名

        if (database){
            // true默认10版数据库表结构       查T_SYS_MNLCONFIG表、T_SYS_EQU
            dcdata = dcDataMapping.get10All();
//            System.out.println(dcdata.toString());
            for (Dcdata data : dcdata) {
                name.add(data.getDcname());     // 添加道岔名
            }
        }else{
            // 查18版表结构    待开发
            System.out.println("18版表结构待开发");
            dcDataMapping.get18All();
        }
        System.out.println("道岔名："+name);
        return Msg.success().add("dcname", name);
    }

    @RequestMapping("/searchData")
    @ResponseBody
    public Msg getDcData(@RequestParam(value = "dcname",defaultValue = "") String dcname){
        System.out.println(dcname);
        List<Dcdata> Dc;
        if (!dcname.isEmpty()){
            System.out.println("开始搜索该道岔数据");
            Dc = dcDataMapping.selectByName(dcname);
//            System.out.println("条件查询结果："+Dc);

            return Msg.success().add("data", Dc);
        }
        return Msg.failed();
    }
}
