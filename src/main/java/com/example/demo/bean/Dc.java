package com.example.demo.bean;

import java.util.Arrays;
import java.util.List;

public class Dc {
    private String typeNum;        // 模拟量类型  -A
    private byte[] value;      // 曲线值


    public String getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(String typeNum) {
        this.typeNum = typeNum;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dc{" +
                "typeNum='" + typeNum + '\'' +
                ", value=" + Arrays.toString(value) +
                '}';
    }
}
