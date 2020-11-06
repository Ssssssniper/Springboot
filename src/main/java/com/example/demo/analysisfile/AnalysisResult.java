package com.example.demo.analysisfile;

import com.example.demo.analysisfile.entity.NodeEntity;

import java.util.List;

public class AnalysisResult {
    /**
     * 中心_网络节点配置表的解析结果
     */
    private List<NodeEntity> netNodeList;

    public List<NodeEntity> getNetNodeList() {
        return netNodeList;
    }

    public void setNetNodeList(List<NodeEntity> netNodeList) {
        this.netNodeList = netNodeList;
    }
}
