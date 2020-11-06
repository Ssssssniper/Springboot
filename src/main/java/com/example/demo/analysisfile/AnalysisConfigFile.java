package com.example.demo.analysisfile;

import com.example.demo.analysisfile.entity.NodeEntity;
import com.example.demo.analysisfile.entity.TerminalEntity;
import com.example.demo.analysisfile.enumconfigfile.ConfigEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.analysisfile.DealNullValue.getString;
import static com.example.demo.analysisfile.DealNullValue.toInteger;

/**
 * 解析TK文件类
 */
public class AnalysisConfigFile {

    /**
     *  解析格式为字节数组类型的文件
     * @param bytes
     * @return
     */
    public static AnalysisResult analysisBytesType(byte[] bytes){
        return analysisResult(bytes);
    }
    /**
     * 解析格式为inputStream类型的数据
     * @param inputStream
     * @return
     */
    public static AnalysisResult analysisInputStreamType(InputStream inputStream){
        return analysisResult(inputStream);
    }

    /**
     * 文件对象格式转换
     * @param obj
     * @return  byte[]
     */
    private static byte[] formatConvert(Object obj){
        byte[] bytes = null;
        if (obj instanceof byte[]){
            bytes = (byte[])obj;
        }else if (obj instanceof InputStream){
            // 流 ——》byte[]
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            try {
                while ((rc = ((InputStream)obj).read(buff, 0, 100)) > 0) {
                    swapStream.write(buff, 0, rc);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            bytes = swapStream.toByteArray();
        }else if (obj instanceof File){
            // 文件 ——》byte[]
            byte[] buffer = null;
            try {
                FileInputStream fis = new FileInputStream((File)obj);
                ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
                byte[] b = new byte[1000];
                int n;
                while ((n = fis.read(b)) != -1) {
                    bos.write(b, 0, n);
                }
                fis.close();
                bos.close();
                buffer = bos.toByteArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bytes = buffer;
        }else{
            throw new NullPointerException("错误的参数类型，byte[]/InputStream/File");
        }
        return bytes;
    }

    private static AnalysisResult analysisResult(Object object){
        byte[] bytes = formatConvert(object);
        AnalysisResult result = new AnalysisResult();
        List<NodeEntity> listNodeEntity = new ArrayList<>();    // 网络节点配置表
//        List<TerminalEntity> authorityList = new ArrayList<>();     // 终端权限表
//        List<DataTableStatusEntity> dataTableList = new ArrayList<>();
//        List<IncrementMaxValueEntity> incrementMaxValueList = new ArrayList<>();
//        List<VersionInfoMainEntity> versionInfoMainList = new ArrayList<>();
//        List<VersionInfoSubEntity> versionInfoSubList = new ArrayList<>();

        Map<String, ArrayList<HashMap<String, Object>>> tableMap = AnalysisConfigUtil.component(bytes ,true);
        for (Map.Entry<String, ArrayList<HashMap<String, Object>>> table : tableMap.entrySet()) {
//            System.out.println("表:" + table.getKey());
            if (table.getKey().equals(ConfigEnum.node_nodeconfig.value)) {
                for (HashMap<String, Object> columnMap : table.getValue()) {
                    NodeEntity nodeEntity = new NodeEntity();
                    nodeEntity.setFnodeName(getString(columnMap,ConfigEnum.node_fnodeName.value));
                    nodeEntity.setFnodeType(toInteger(getString(columnMap,ConfigEnum.node_ftype.value)));
                    nodeEntity.setFnodeId(toInteger(getString(columnMap,ConfigEnum.node_fnodeId.value)));

                    nodeEntity.setFcode(getString(columnMap,ConfigEnum.node_ftelegraphcode.value));
                    nodeEntity.setFipAddress(getString(columnMap,ConfigEnum.node_fipAddress.value));
                    nodeEntity.setFelectricServiceSection(getString(columnMap,ConfigEnum.node_felectricServiceSection.value));

                    nodeEntity.setFworkshop(getString(columnMap,ConfigEnum.node_fworkshop.value));
                    nodeEntity.setFline(getString(columnMap,ConfigEnum.node_fline.value));
                    nodeEntity.setFcompany(toInteger(getString(columnMap,ConfigEnum.node_fcompany.value)));
                    nodeEntity.setFversion(toInteger(getString(columnMap,ConfigEnum.node_fversion.value)));
                    nodeEntity.setFworkArea(getString(columnMap,ConfigEnum.node_fworkArea.value));
                    nodeEntity.setFnodeSequence(toInteger(getString(columnMap,ConfigEnum.node_fnodeSequence.value)));
                    nodeEntity.setFstationServerId(toInteger(getString(columnMap,ConfigEnum.node_fstationServerId.value)));
                    if (5 == toInteger(getString(columnMap,ConfigEnum.node_ftype.value))){
                        nodeEntity.setFstationServerId(toInteger(getString(columnMap,ConfigEnum.node_fstationServerId.value)));
                    }
                    nodeEntity.setState(0);
                    listNodeEntity.add(nodeEntity);
                }
            }
//            if (table.getKey().equals(ConfigEnum.terminal_authorityconfig.value)) {
//                for (HashMap<String, Object> columnMap : table.getValue()) {
//                    TerminalEntity entity = new TerminalEntity();
//                    entity.setTerminalId(toInteger(getString(columnMap, ConfigEnum.terminal_fterminalId.value)));
//                    entity.setNodeId(toInteger(getString(columnMap, ConfigEnum.terminal_fnodeId.value)));
//                    entity.setNodeType(toInteger(getString(columnMap, ConfigEnum.terminal_fnodeType.value)));
//                    authorityList.add(entity);
//                }
//            }
//            if (table.getKey().equals(ConfigEnum.versioninfosub_sublist.value)) {
//                for (HashMap<String, Object> columnMap : table.getValue()) {
//                    VersionInfoSubEntity entity = new VersionInfoSubEntity();
//                    entity.setTableId(toInteger(getString(columnMap, ConfigEnum.versioninfosub_tableId.value)));
//                    entity.setTableName(getString(columnMap, ConfigEnum.versioninfosub_tableName.value));
//                    entity.setVersionNo((getString(columnMap, ConfigEnum.versioninfosub_versionNo.value)));
//                    entity.setIsChange(toInteger(getString(columnMap, ConfigEnum.versioninfosub_isChange.value)));
//                    entity.setChangeNumber(toInteger(getString(columnMap, ConfigEnum.versioninfosub_changeNumber.value)));
//                    versionInfoSubList.add(entity);
//                }
//            }
//            if (table.getKey().equals(ConfigEnum.increment_maxValueTable.value)) {
//                for (HashMap<String, Object> columnMap : table.getValue()) {
//                    IncrementMaxValueEntity entity = new IncrementMaxValueEntity();
//                    entity.setTableName(getString(columnMap, ConfigEnum.increment_tableName.value));
//                    entity.setColumnName(getString(columnMap, ConfigEnum.increment_columnName.value));
//                    entity.setMaxValue(toInteger(getString(columnMap, ConfigEnum.increment_maxValue.value)));
//                    incrementMaxValueList.add(entity);
//                }
//            }
//            if (table.getKey().equals(ConfigEnum.status_dataTableStatus.value)) {
//                for (HashMap<String, Object> columnMap : table.getValue()) {
//                    DataTableStatusEntity entity = new DataTableStatusEntity();
//                    entity.setTableName(getString(columnMap, ConfigEnum.status_tableName.value));
//                    entity.setTableStatus(toInteger(getString(columnMap, ConfigEnum.status_tableStatus.value)));
//                    entity.setLastModifier(getString(columnMap, ConfigEnum.status_lastModifier.value));
//                    entity.setLastModifyTime(getString(columnMap, ConfigEnum.status_lastModifyTime.value));
//                    dataTableList.add(entity);
//                }
//            }
//            if (table.getKey().equals(ConfigEnum.versioninfomain_master.value)) {
//                for (HashMap<String, Object> columnMap : table.getValue()) {
//                    VersionInfoMainEntity entity = new VersionInfoMainEntity();
//                    entity.setId(toInteger(getString(columnMap, ConfigEnum.versioninfomain_id.value)));
//                    entity.setFileVersion(getString(columnMap, ConfigEnum.versioninfomain_fileVersion.value));
//                    entity.setTime(toLong(getString(columnMap, ConfigEnum.terminal_fnodeType.value)));
//                    entity.setIssuer(getString(columnMap, ConfigEnum.versioninfomain_issuer.value));
//                    entity.setSystem(toInteger(getString(columnMap, ConfigEnum.versioninfomain_system.value)));
//                    entity.setContent(getString(columnMap, ConfigEnum.versioninfomain_content.value));
//                    entity.setStatus(toInteger(getString(columnMap, ConfigEnum.versioninfomain_status.value)));
//                    entity.setIsNew(toInteger(getString(columnMap, ConfigEnum.versioninfomain_isNew.value)));
//                    entity.setDataVersion(getString(columnMap, ConfigEnum.versioninfomain_dataVersion.value));
//                    entity.setProcedureVersion(getString(columnMap, ConfigEnum.versioninfomain_procedureVersion.value));
//                    versionInfoMainList.add(entity);
//                }
//            }

        }
        result.setNetNodeList(listNodeEntity);
//        result.setTerminalList(authorityList);
//        result.setDataTableList(dataTableList);
//        result.setIncrementMaxValueList(incrementMaxValueList);
//        result.setVersionInfoMainList(versionInfoMainList);
//        result.setVersionInfoSubList(versionInfoSubList);
        return result;
    }
}
