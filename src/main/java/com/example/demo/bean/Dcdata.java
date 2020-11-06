package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class Dcdata {
    private String dcname;      // 道岔名
    private String startTime;       // 动作时间
    private Integer freq;           // 采集频率
    private String direction;      // 动作方向
    private List<Dc> dcList;        // 道岔数据实体

    public Dcdata() {
    }

    public Dcdata(String dcname, String startTime, Integer freq, List<Dc> dcList) {
        this.dcname = dcname;
        this.startTime = startTime;
        this.freq = freq;
        this.dcList = dcList;
    }

    public String getDcname() {
        return dcname;
    }

    public void setDcname(String dcname) {
        this.dcname = dcname;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Dc> getDcList() {
        return dcList;
    }

    public void setDcList(List<Dc> dcList) {
        this.dcList = dcList;
    }

    @Override
    public String toString() {
        return "Dcdata{" +
                "dcname='" + dcname + '\'' +
                ", startTime='" + startTime + '\'' +
                ", freq=" + freq +
                ", direction=" + direction +
                ", dcList=" + dcList +
                '}';
    }
}
