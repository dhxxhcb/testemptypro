package com.xoa.model.attend;

/**
 * 创建作者: 王曰岐 创建日期: 2017-6-6 下午3:25:09 类介绍 : 考勤实体类 构造参数: 无
 */
public class AttendSet {
    /**
     * 唯一自增ID
     */
    private Integer sid;
    /**
     * 创建者ID
     */
    private Integer uid;
    /**
     * 考勤签到类型名称
     */
    private String title;
    /**
     * 第一次签到开关
     */
    private String atime1Set;
    /**
     * 第一次签到标准时间
     */
    private String atime1;
    /**
     * 第二次签到开关
     */
    private String atime2Set;
    /**
     * 第二次签到标准时间
     */
    private String atime2;
    /**
     * 第三次签到开关
     */
    private String atime3Set;
    /**
     * 第三次签到标准时间
     */
    private String atime3;
    /**
     * 第四次签到开关
     */
    private String atime4Set;
    /**
     * 第四次签到标准时间
     */
    private String atime4;
    /**
     * 第五次签到开关
     */
    private String atime5Set;
    /**
     * 第五次签到标准时间
     */
    private String atime5;
    /**
     * 第六次签到开关
     */
    private String atime6Set;
    /**
     * 第六次签到标准时间
     */
    private String atime6;
    /**
     * 上班可提前签到分钟数
     */
    private String worktimeF;
    /**
     * 上班可延后分钟数
     */
    private String worktimeB;
    /**
     * 下班可提前分钟数
     */
    private String workafterF;
    /**
     * 下班可延后分钟数
     */
    private String workafterB;
    /**
     * 规定签到地点
     */
    private String location;
    /**
     * 可签到位置范围（米）
     */
    private String ranges;
    /**
     * 外勤开关
     */
    private String isOut;
    /**
     * 位置是否开启
     */
    private String locationOn;
    /**
     * 是否开启wifi签到
     */
    private String wifiOn;
    /**
     * wifi地址
     */
    private String wifiAddr;
    /**
     * wifi名称
     */
    private String wifiName;
    /**
     * 上班日期
     */
    private String workdate;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAtime1Set() {
        return atime1Set;
    }

    public void setAtime1Set(String atime1Set) {
        this.atime1Set = atime1Set;
    }

    public String getAtime1() {
        return atime1;
    }

    public void setAtime1(String atime1) {
        this.atime1 = atime1;
    }

    public String getAtime2Set() {
        return atime2Set;
    }

    public void setAtime2Set(String atime2Set) {
        this.atime2Set = atime2Set;
    }

    public String getAtime2() {
        return atime2;
    }

    public void setAtime2(String atime2) {
        this.atime2 = atime2;
    }

    public String getAtime3Set() {
        return atime3Set;
    }

    public void setAtime3Set(String atime3Set) {
        this.atime3Set = atime3Set;
    }

    public String getAtime3() {
        return atime3;
    }

    public void setAtime3(String atime3) {
        this.atime3 = atime3;
    }

    public String getAtime4Set() {
        return atime4Set;
    }

    public void setAtime4Set(String atime4Set) {
        this.atime4Set = atime4Set;
    }

    public String getAtime4() {
        return atime4;
    }

    public void setAtime4(String atime4) {
        this.atime4 = atime4;
    }

    public String getAtime5Set() {
        return atime5Set;
    }

    public void setAtime5Set(String atime5Set) {
        this.atime5Set = atime5Set;
    }

    public String getAtime5() {
        return atime5;
    }

    public void setAtime5(String atime5) {
        this.atime5 = atime5;
    }

    public String getAtime6Set() {
        return atime6Set;
    }

    public void setAtime6Set(String atime6Set) {
        this.atime6Set = atime6Set;
    }

    public String getAtime6() {
        return atime6;
    }

    public void setAtime6(String atime6) {
        this.atime6 = atime6;
    }

    public String getWorktimeF() {
        return worktimeF;
    }

    public void setWorktimeF(String worktimeF) {
        this.worktimeF = worktimeF;
    }

    public String getWorktimeB() {
        return worktimeB;
    }

    public void setWorktimeB(String worktimeB) {
        this.worktimeB = worktimeB;
    }

    public String getWorkafterF() {
        return workafterF;
    }

    public void setWorkafterF(String workafterF) {
        this.workafterF = workafterF;
    }

    public String getWorkafterB() {
        return workafterB;
    }

    public void setWorkafterB(String workafterB) {
        this.workafterB = workafterB;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRanges() {
        return ranges;
    }

    public void setRanges(String ranges) {
        this.ranges = ranges;
    }

    public String getIsOut() {
        return isOut;
    }

    public void setIsOut(String isOut) {
        this.isOut = isOut;
    }

    public String getLocationOn() {
        return locationOn;
    }

    public void setLocationOn(String locationOn) {
        this.locationOn = locationOn;
    }

    public String getWifiOn() {
        return wifiOn;
    }

    public void setWifiOn(String wifiOn) {
        this.wifiOn = wifiOn;
    }

    public String getWifiAddr() {
        return wifiAddr;
    }

    public void setWifiAddr(String wifiAddr) {
        this.wifiAddr = wifiAddr;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getWorkdate() {
        return workdate;
    }

    public void setWorkdate(String workdate) {
        this.workdate = workdate;
    }
}