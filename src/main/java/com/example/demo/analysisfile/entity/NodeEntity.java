package com.example.demo.analysisfile.entity;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/2.
 * 中心网络节点配置的数据对象
 */
public class NodeEntity {
    public NodeEntity() {
    }
    /**
     * 电报码
     */
    private  String fcode;//D电报码
    /**
     * 车站连接状态 0 未连接 1 连接 2 连其他机器(编写算法计算) 状态都是由前置机提供
     */
    private  Integer state;
    //    // ftype 类型 中心 前置 车站 终端 局服务
    private Integer fnodeType;
    private Integer fnodeId;
    private String fnodeName;//节点名称11
    private String fipAddress;//IP地址1
    private String felectricServiceSection;//电务段
    private String fworkshop;//车间
    private String fline;//线路
    private Integer fcompany;//厂家
    private Integer fversion;//型号
    private String fworkArea;
    private Integer fnodeSequence;
    private Integer fstationServerId;//当节点类型为车站时添加此配置，车站所属服务器ID
    //根据电报码和这个值来判断定时提取应该提取那条命令  1:正常命令  2:扩展命令
    private Integer extractType=2;


    public Integer getExtractType() {
        return extractType;
    }

    public void setExtractType(Integer extractType) {
        this.extractType = extractType;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFnodeType() {
        return fnodeType;
    }

    public void setFnodeType(Integer fnodeType) {
        this.fnodeType = fnodeType;
    }

    public Integer getFnodeId() {
        return fnodeId;
    }

    public void setFnodeId(Integer fnodeId) {
        this.fnodeId = fnodeId;
    }

    public String getFnodeName() {
        return fnodeName;
    }

    public void setFnodeName(String fnodeName) {
        this.fnodeName = fnodeName;
    }

    public String getFipAddress() {
        return fipAddress;
    }

    public void setFipAddress(String fipAddress) {
        this.fipAddress = fipAddress;
    }

    public String getFelectricServiceSection() {
        return felectricServiceSection;
    }

    public void setFelectricServiceSection(String felectricServiceSection) {
        this.felectricServiceSection = felectricServiceSection;
    }

    public String getFworkshop() {
        return fworkshop;
    }

    public void setFworkshop(String fworkshop) {
        this.fworkshop = fworkshop;
    }

    public String getFline() {
        return fline;
    }

    public void setFline(String fline) {
        this.fline = fline;
    }

    public Integer getFcompany() {
        return fcompany;
    }

    public void setFcompany(Integer fcompany) {
        this.fcompany = fcompany;
    }

    public Integer getFversion() {
        return fversion;
    }

    public void setFversion(Integer fversion) {
        this.fversion = fversion;
    }

    public String getFworkArea() {
        return fworkArea;
    }

    public void setFworkArea(String fworkArea) {
        this.fworkArea = fworkArea;
    }

    public Integer getFnodeSequence() {
        return fnodeSequence;
    }

    public void setFnodeSequence(Integer fnodeSequence) {
        this.fnodeSequence = fnodeSequence;
    }

    public Integer getFstationServerId() {
        return fstationServerId;
    }

    public void setFstationServerId(Integer fstationServerId) {
        this.fstationServerId = fstationServerId;
    }

    @Override
    public String toString() {
        return "NodeEntity{" +
                "fcode='" + fcode + '\'' +
                ", state=" + state +
                ", fnodeType=" + fnodeType +
                ", fnodeId=" + fnodeId +
                ", fnodeName='" + fnodeName + '\'' +
                ", fipAddress='" + fipAddress + '\'' +
                ", felectricServiceSection='" + felectricServiceSection + '\'' +
                ", fworkshop='" + fworkshop + '\'' +
                ", fline='" + fline + '\'' +
                ", fcompany=" + fcompany +
                ", fversion=" + fversion +
                ", fworkArea='" + fworkArea + '\'' +
                ", fnodeSequence=" + fnodeSequence +
                ", fstationServerId=" + fstationServerId +
                ", extractType=" + extractType +
                '}';
    }
}
