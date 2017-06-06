package com.xoa.service.sys.impl;

import com.xoa.service.sys.SystemInfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/5/31 19:26
 * @类介绍: 系统信息
 * @构造参数: 无
 **/
@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    //软件名称
    public static String softName = "OA协同办公智能管理平台";
    //系统版本
    public static final String softVersion = "2017.06.10.1.0";
    //版本号
    public static final String softVersionNO = "1.0";
    //操作系统
    public static String operationSystem = "";
    //服务器路径
    public static final String serverPath = "";
    //jdk版本
    public static String jdkVersion = "";
    //组织机构名称
    public static final String orgName = "";
    //机器码
    public static final String machineCode = "";
    //软件序列号
    public static final String softSerialNo = "";
    //用户信息
    public static final String userInfo = "";
    //正式授权信息说明文字
    public static final String reloadAuthorizationstr = "正式授权信息" +
            "（正式授权信息，需校验组织机构名称、机器码和软件序列号，务必与授权文件中的信息一致）";
    //授权单位
    public static final String authorizationUnit = "";
    //授权机器码
    public static final String authorizationCode = "";

    //授权开始日期
    public static final String authorizationBeginDate = "";
    //授权结束日期
    public static final String authorizationEndDate = "";
    //移动终端限制
    public static final String mobileTeriminalLimit = "1000000";
    //pc终端限制
    public static final String pcTerminalLimit = "1000000";
    //oa用户限制
    public static final String oaUserLimit = "1000000";

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 19:27
     * @函数介绍: 获取系统信息
     * @参数说明: @param 无
     * @return: Map<String, String>
     **/
    public Map<String, String> getSystemInfo() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("softName", softName);
        map.put("softVersion", softVersion);
        map.put("softVersionNO", softVersionNO);

        operationSystem = getOperationSystem();
        map.put("operationSystem", operationSystem);

        map.put("serverPath", serverPath);
        jdkVersion = getJdkVersion();
        map.put("jdkVersion", jdkVersion);
        map.put("machineCode", machineCode);
        map.put("orgName", orgName);
        map.put("softSerialNo", softSerialNo);
        map.put("userInfo", userInfo);
        map.put("reloadAuthorizationstr", reloadAuthorizationstr);
        map.put("authorizationUnit", authorizationUnit);
        map.put("authorizationCode", authorizationCode);
        map.put("authorizationBeginDate", authorizationBeginDate);
        map.put("authorizationEndDate", authorizationEndDate);
        map.put("mobileTeriminalLimit", mobileTeriminalLimit);
        map.put("pcTerminalLimit", pcTerminalLimit);
        map.put("oaUserLimit", oaUserLimit);
        return map;
    }


    public String getOperationSystem() {

        Properties prop = System.getProperties();
        String osName = (String) prop.get("os.name");

        return osName; //operationSystem;
    }


    public String getJdkVersion() {

        return System.getProperty("java.version");
    }
}
