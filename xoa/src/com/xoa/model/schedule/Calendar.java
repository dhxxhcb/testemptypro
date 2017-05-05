package com.xoa.model.schedule;

import java.util.Date;
import java.util.List;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月4日 上午10:50:11
 * 类介绍  :    日程安排表
 * 构造参数:   无
 *
 */
 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月4日 上午10:52:17
 * 类介绍  :   
 * 构造参数:   
 *
 */
 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月4日 上午10:52:18
 * 类介绍  :   
 * 构造参数:   
 *
 */
public class Calendar {
    /**  
     * 唯一自增ID
     */ 
    private Integer calId;

    /**  
     * 用户ID 
     */ 
    private String userId;

    /**  
     * 开始时间:  
     */ 
    private Integer calTime;

    /**  
     * 结束时间
     */ 
    private Integer endTime;

    /**  
     * 事务类型(1-工作事务,2-个人事务)  
     */ 
    private String calType;

    /**  
     * 优先级(1-重要/紧急,2-重要/不紧急,3-不重要/紧急,4-不重要/不紧急)',
     */ 
    private String calLevel;

    /**  
     * 事务内容
     */ 
    private String managerId;

    /**  
     * 安排人的用户ID 
     */ 
    private String overStatus;

    /**  
     * 完成状态(0-未完成,1-已完成)  
     */ 
    private String beforeRemaind;

    /**  
     * 提前提醒时间  
     */ 
    private Date addTime;

    /**  
     * 新建时间  
     */ 
    private Byte allday;

    /**  
     * 从哪个模块添加的日程(1-外出,2-会议申请,3-工作计划,4-人力资源)',
     */ 
    private Byte fromModule;

    /**  
     * 详情url
     */ 
    private String url;

    /**  
     * 关联的模块的id', 
     */ 
    private Integer mId;

    /**  
     * 对应模块id  
     */ 
    private Integer resId;
    
    /**  
     * 事物内容
     */ 
    private String content;

    /**  
     * 所属者
     */ 
    private String owner;

    /**  
     * 参与者
     */ 
    private String taker;
    
    private String calData;
    
    private List<Calendar> calMessage;
    
    

    public String getCalData() {
		return calData;
	}

	public void setCalData(String calData) {
		this.calData = calData;
	}

	public List<Calendar> getCalMessage() {
		return calMessage;
	}

	public void setCalMessage(List<Calendar> calMessage) {
		this.calMessage = calMessage;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getTaker() {
        return taker;
    }

    public void setTaker(String taker) {
        this.taker = taker == null ? null : taker.trim();
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getCalTime() {
        return calTime;
    }

    public void setCalTime(Integer calTime) {
        this.calTime = calTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType == null ? null : calType.trim();
    }

    public String getCalLevel() {
        return calLevel;
    }

    public void setCalLevel(String calLevel) {
        this.calLevel = calLevel == null ? null : calLevel.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getOverStatus() {
        return overStatus;
    }

    public void setOverStatus(String overStatus) {
        this.overStatus = overStatus == null ? null : overStatus.trim();
    }

    public String getBeforeRemaind() {
        return beforeRemaind;
    }

    public void setBeforeRemaind(String beforeRemaind) {
        this.beforeRemaind = beforeRemaind == null ? null : beforeRemaind.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Byte getAllday() {
        return allday;
    }

    public void setAllday(Byte allday) {
        this.allday = allday;
    }

    public Byte getFromModule() {
        return fromModule;
    }

    public void setFromModule(Byte fromModule) {
        this.fromModule = fromModule;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }
}