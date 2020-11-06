package com.example.demo.analysisfile;

import java.util.Map;
import java.util.Objects;

/**
 * 处理 map中的值为转成其他类型时，所导致的异常
 * Noninstantiable utility class
 */
public class DealNullValue {

    private DealNullValue(){}
    /**
     * 将String 转成 Integer
     * @param value
     * @return
     */
    public static Integer toInteger(String value){

        return value == null ? null : isKong(value);
    }
    private static Integer isKong(String value){
        if("".trim().equals(value)){
            return  null;
        }
        return Integer.valueOf(value);
    }
    private static Long isNull(String value){
        if("".trim().equals(value)){
            return  null;
        }
        return Long.valueOf(value);
    }

    /**
     * 通过key,获取Map中的值
     * @param map
     * @param configEnum
     * @return
     */
    public static String  getString(Map<String, Object> map, String configEnum) {
        Objects.requireNonNull(map,"所传入参数Map的值为空");
        return  map.get(configEnum) == null ? null : map.get(configEnum).toString();
    }

    /**
     * 将String 转成Long
     * @param value
     * @return
     */
    public static Long toLong(String value){
        return value == null ? null : isNull(value);
    }
}
