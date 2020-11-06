package com.example.demo.analysisfile.enumconfigfile;

public enum ConfigEnum {

    node_nodeconfig("中心_网络节点配置表"),
    node_ftype("节点类型"),
    node_fnodeId("节点ID"),
    node_fnodeName("节点名称"),
    node_fipAddress("IP地址"),
    node_ftelegraphcode("电报码"),
    node_fcompany("厂家"),
    node_fversion("型号"),
    node_fline("线"),
    node_fworkshop("车间"),
    node_felectricServiceSection("电务段"),
    node_fworkArea("工区"),
    node_fnodeSequence("节点顺序"),
    node_fstationServerId("车站所属服务器ID"),

//    terminal_authorityconfig("中心_终端权限表"),
//    terminal_fterminalId("终端ID"),
//    terminal_fnodeId("管辖节点ID"),
//    terminal_fnodeType("管辖节点类型"),
//
//    versioninfosub_sublist("中心_版本信息子表"),
//    versioninfosub_tableId("主表Id"),
//    versioninfosub_tableName("数据表名"),
//    versioninfosub_versionNo("表版本号"),
//    versioninfosub_isChange("是否变更"),
//    versioninfosub_changeNumber("变更码"),
//
//    increment_maxValueTable("中心_自增长最大值表"),
//    increment_tableName("表名"),
//    increment_columnName("列名"),
//    increment_maxValue("最大值"),
//
//    status_dataTableStatus("中心_数据表状态"),
//    status_tableName("表名"),
//    status_tableStatus("表状态"),
//    status_lastModifyTime("最后修改时间"),
//    status_lastModifier("最后修改人员"),
//
//
//    versioninfomain_master("中心_版本信息主表"),
//    versioninfomain_id("ID"),
//    versioninfomain_fileVersion("文件版本号"),
//    versioninfomain_time("发布时间"),
//    versioninfomain_issuer("发布人"),
//    versioninfomain_system("发布系统"),
//    versioninfomain_content("修改内容"),
//    versioninfomain_status("状态"),
//    versioninfomain_isNew("是否最新版"),
//    versioninfomain_dataVersion("所用规则数据版本号"),
//    versioninfomain_procedureVersion("数据工具平台程序版本号"),
//
//
//    station_sequence("显示顺序号"),
//    station_uuid("ID"),
//    station_datatype("数据类型"),
    ;

    public String value;

    ConfigEnum(String value) {
        this.value = value;
    }
}
