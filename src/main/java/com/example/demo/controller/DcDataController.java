package com.example.demo.controller;

import com.example.demo.bean.Dc;
import com.example.demo.bean.Dcdata;
import com.example.demo.common.Msg;
import com.example.demo.dao.DcDataMapping;
import com.example.demo.utils.ByteConvert;
import com.example.demo.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// 道岔数据的查询

/**
 * 10版组织道岔的数据结构get10All（）：    道岔名  时间  频率  [-A ， 曲线值， 动作方向]
 */

@RestController
public class DcDataController {

    @Autowired
    DcDataMapping dcDataMapping;

    /**
     * 查询库表，获取所有道岔名
     * @param database
     * @return
     */
//    @RequestMapping("/display")
    @GetMapping("/display")
    @ResponseBody
    public Msg getDcname(@RequestParam(value = "database",defaultValue = "true") Boolean database){
        System.out.println(database);
        List<String> dcdata;
        Set<String> name = new HashSet<>();         // 存储道岔名

        if (database){
            // true默认10版数据库表结构       查T_SYS_MNLCONFIG表、T_SYS_EQU
            dcdata = dcDataMapping.get10dcname();

        }else{
            // 查18版表结构    待开发
            System.out.println("18版表结构待开发");
//            dcDataMapping.get18All();
            return Msg.failed().add("data", "18版表结构待开发");
        }
        // dc名称排序
        TreeSet ts = new TreeSet(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.replace("-", "").compareTo(o2.replace("-", ""));
            }
        });
        for (String dc : dcdata) {
            ts.add(dc);
        }
        System.out.println("道岔名："+ts);
        return Msg.success().add("dcname", ts);
    }

    /**    搜索展示
     * 根据道岔名获取相应信息用于表格展示（不含曲线数据）
     * @param dcname
     * @return
     */
//    @RequestMapping("/searchData")
    @GetMapping("/searchData")
    @ResponseBody
    public Msg getDcData(@RequestParam(value = "dcname",defaultValue = "") String dcname,@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        System.out.println(dcname);

        if (!dcname.isEmpty()){
            System.out.println("开始搜索该道岔数据");
            PageHelper.startPage(pn, 11);
            List<Dcdata> Dc = dcDataMapping.selectByName(dcname);
            // 时间格式转换
            for (Dcdata dcdata : Dc) {
//                String time = DateUtils.dealDateFormat(dcdata.getStartTime());
                String time = dcdata.getStartTime();
                dcdata.setStartTime(time);
            }

            PageInfo page = new PageInfo(Dc, 3);        // 格式转换（包装）   navigatePages:导航页码数
            System.out.println(page);
            return Msg.success().add("data", page);
        }
        return Msg.failed();
    }

    /**     查看
     *  根据表格中所选行，获取曲线数据
     * @Param  道岔名    动作时间   动作方向
     */
    @GetMapping("/watch")
    @ResponseBody
    public Msg watchData(@RequestParam(value = "dcname",defaultValue = "") String dcname, @RequestParam(value = "startTime") String time, @RequestParam(value = "direction") String typeno){
        // 时间格式转换
        System.out.println(time);
        String t = time.replace(" ", "+");
        // 定-反  0    反-定  1
        switch (typeno){
            case "定-反":
                typeno = "0";
                break;
            case "反-定":
                typeno = "1";
                break;
            case "定-定":
                typeno = "2";
                break;
            case "反-反":
                typeno = "3";
                break;
            case "定-故障":
                typeno = "4";
                break;
            case "反-故障":
                typeno = "5";
                break;
            case "故障-定":
                typeno = "6";
                break;
            case "故障-反":
                typeno = "7";
                break;
            default:
                System.out.println("动作方向匹配错误");
        }
        List<Dcdata> dcdata = dcDataMapping.getDcdata(dcname, t, typeno);            // A B C 三相电流
        // [Dcdata{dcname='13#', startTime='2020-07-05T01:36:30+08:00', freq=40, direction=反-定, dcList=[Dc{typeNum='-A', value=[0, 0, 0, 0, 0, 0, 0, 0, -95, -96, 32, 63, -105, -26, -26, 63, -30, 63, 0, 0, 0, 0, 0, 0, 0]},
        // Dc{typeNum='-B', value=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 63, -30,26, 63, -30, -31, -31, 63, -30, -30, -31, -31, -86, 42, 63, -85, -86, 42, 63, -85, -86, -86, 0, 0]},
        // Dc{typeNum='-C', value=[0, 0, 0, 0, 0, 0, 0, 0, -95, -96, -25, -26, 63, -30, -31, -31, 63, -25, -26, -26, 63, -25, -26, -26, 63, -4, 0, 0, 0, 0, 0, 0,, 0, 0, 0, 0, 0]}]}]
        List<Map<String,Object>> res = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        for (Dcdata dcdatum : dcdata) {
            List<Dc> dcList = dcdatum.getDcList();
            for (Dc dc : dcList) {
                List<Float> x = new ArrayList<>();      // x轴
                List<Float> list = new ArrayList<>();   // y轴
                byte[] value = dc.getValue();
                for (int i = 0; i < value.length; i = i+4) {
                    float v = ByteConvert.bytesToFloat(value, i);
                    list.add(v);
                }
                for (int j = 0; j < list.size(); j++) {
                    x.add(j*0.04f);
                }
                System.out.println("x_length:"+x.size());
                System.out.println("list_length:"+list.size());
                //     构二维数组
                Object[] arrY = list.toArray();
                Object[] arrX = x.toArray();

                float[][] curve = new float[list.size()][2];
                for (int i = 0; i < list.size(); i++) {
                    curve[i][0] = (float)arrX[i];
                    curve[i][1] = (float)arrY[i];
                }
                map.put( dc.getTypeNum().replace("-", ""),curve);
            }
        }
        return Msg.success().add("data", map);
    }
}
