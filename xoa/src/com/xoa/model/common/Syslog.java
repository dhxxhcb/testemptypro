package com.xoa.model.common;

import java.util.Date;


/**
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-27 上午9:50:20
 * 类介绍  :    系统日志表
 * 构造参数:    无
 */
public class Syslog {
    /**
     * 唯一自增ID
     */
    private Integer logId;
    /**
     * 用户USER_ID
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 记录时间
     */
    private Date time;
    /**
     * IP地址
     */
    private String ip;

    /**
     * IP所在地理位置
     */
    private String ipLocation;

    public String getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    /**
     * 日志类型(详见系统代码)
     */
    private Integer type;

    /**
     * 日志类型名称
     */

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:52:11
     * 方法介绍:   唯一自增ID
     * 参数说明:   @return
     *
     * @return Integer
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:52:17
     * 方法介绍:   唯一自增ID
     * 参数说明:   @param logId
     *
     * @return void
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:52:44
     * 方法介绍:   用户USER_ID
     * 参数说明:   @return
     *
     * @return String
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:52:57
     * 方法介绍:   用户USER_ID
     * 参数说明:   @param userId
     *
     * @return void
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:53:03
     * 方法介绍:   记录时间
     * 参数说明:   @return
     *
     * @return Date
     */
    public Date getTime() {
        return time;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:53:15
     * 方法介绍:   记录时间
     * 参数说明:   @param time
     *
     * @return void
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:53:22
     * 方法介绍:   IP地址
     * 参数说明:   @return
     *
     * @return String
     */
    public String getIp() {
        return ip;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:53:34
     * 方法介绍:   IP地址
     * 参数说明:   @param ip
     *
     * @return void
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:54:06
     * 方法介绍:   日志类型(详见系统代码)
     * 参数说明:   @return
     *
     * @return Integer
     */
    public Integer getType() {
        return type;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:54:23
     * 方法介绍:   日志类型(详见系统代码)
     * 参数说明:   @param type
     *
     * @return void
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:54:29
     * 方法介绍:   备注
     * 参数说明:   @return
     *
     * @return String
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-27 上午9:54:38
     * 方法介绍:   备注
     * 参数说明:   @param remark
     *
     * @return void
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }


}
