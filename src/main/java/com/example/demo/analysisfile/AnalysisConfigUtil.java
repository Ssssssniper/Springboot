package com.example.demo.analysisfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/************************************************
 * @ClassName: AnalysisConfigUtil.java
 * @Tables:
 * @Author: 徐靖源
 * @CreateDate: 2019/6/18
 * @RevisionHistory:
 ***********************************************/
public class AnalysisConfigUtil {
    //Suppress default constructor for noninstantiability
    private AnalysisConfigUtil(){}
    static String tableSplit = "à";       //表分割符
    static String tableNameSplit = "ó";   //表名分割符
    static String titleSplit = "Ç";      //表列标题分隔符
    static String rowSplit = "ζ";         //表行分隔符
    static String colSplit = "θ";         //表列标题、行字段分隔符
    /**
     * 解压、解析的组合方法
     * @param bytes
     * @return root 返回xml文件中的根节点
     */
    public static Map<String,ArrayList<HashMap<String,Object>>> component(byte[] bytes, boolean isCompress){
        Map<String,ArrayList<HashMap<String,Object>>> ret = new  HashMap<String,ArrayList<HashMap<String,Object>>>();
        try {
        byte[] databytes = bytes;
        if(isCompress){
            databytes = GZIPUtils.uncompress(bytes);
        }
       // log.info("字符串长度："+databytes.length);
      //  log.info("压缩后：："+ByteConvert.bytesToHexString(databytes));
       // FileRead.getFile(databytes,"d:\\","55.txt");
        String data = new String(databytes,"utf-8");

        //分割表
        String[] tableArr = data.split(tableSplit);
        //表循环
        for (int i = 0; i < tableArr.length; i++)
        {
            //拆分出表名
            String[] tblNameArr = tableArr[i].split(tableNameSplit);
            String tableName = tblNameArr[0];
            //拆分出字段标题数组
            String[] colTitleArr = tblNameArr[1].split(titleSplit);
            String[] columnNameArr = colTitleArr[0].split(colSplit);
            //拆分行数组
            String[] rowDataArr = colTitleArr[1].split(rowSplit);
            //拆分出列类型
            String[] colType = rowDataArr[0].split(colSplit);
            //创建表
            ArrayList<HashMap<String,Object>> dt1 = new   ArrayList<HashMap<String,Object>>();
            ret.put(tableName,dt1);
            //行字段数据
                for (int j = 1; j < rowDataArr.length; j++)
                {
                    String[] colDataArr = rowDataArr[j].split(colSplit);
                    HashMap<String,Object> dr = new HashMap<String,Object>();
                    dt1.add(dr);
                    for (int k = 0; k < colDataArr.length; k++)
                    {

                        String v = colDataArr[k];
                        String coltype =  colType[k];
                        String columnname =  columnNameArr[k];

                        if(coltype.indexOf("String")>0){
                            dr.put(columnname,v);
                        }else if(coltype.indexOf("Int32")>0){
                            if(v.equals("")){
                                dr.put(columnname,null);
                            }else{
                                dr.put(columnname,Integer.valueOf(v));
                            }
                        }else if(coltype.indexOf("Int64")>0){
                            if(v.equals("")){
                                dr.put(columnname,null);
                            }else{
                                dr.put(columnname,Long.valueOf(v));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
