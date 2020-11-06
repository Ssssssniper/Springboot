package com.example.demo.analysisfile.entity;

/**
 * 终端管辖范围的数据对象
 */

public class TerminalEntity {

    private Integer terminalId;
    private Integer nodeId;
    private Integer nodeType;

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public String toString() {
        return "{" +
                "terminalId=" + terminalId +
                ", nodeId=" + nodeId +
                ", nodeType=" + nodeType +
                '}';
    }
}
