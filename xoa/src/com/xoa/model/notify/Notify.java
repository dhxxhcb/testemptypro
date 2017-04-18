package com.xoa.model.notify;

import java.util.Date;
import java.util.List;

import com.xoa.model.users.Users;
   /**
    * 
    * @ClassName (类名):  Notify
    * @Description(简述): 公告管理
    * @author(作者):      张丽军
    * @date(日期):        2017-4-17 下午6:09:31
    *
    */
public class Notify {
	
    private Integer notifyId;
	/**
	 * 发布部门id
	 */
    private Integer fromDept;
	/**
	 * 发布用户USER_ID
	 */
    private String fromId;
	/**
	 * 公告标题
	 */
    private String subject;
	/**
	 * 发布时间
	 */
    private Date sendTime;
	/**
	 * 开始日期
	 */
    private Integer beginDate;
	/**
	 * 结束日期
	 */
    private Integer endDate;
	/**
	 * 是否允许打印office附件
	 */
    private String print;
	/**
	 * 公告类型
	 */
    private String typeId;
	/**
	 * 是否置顶(0-否,1-是)
	 */
    private String top;
	/**
	 * 置顶天数
	 */
    private Integer topDays;
    
	private Integer clickCount;
    /**
	 * 点击数
	 * 
	 * @return
	 */
	public Integer getClickCount() {
		return clickCount;
	}

	/**
	 * 点击数
	 * 
	 * @param clickCount
	 */
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	/**
	 * 公告通知格式(0-普通格式,1-MHT格式,2-超链接)
	 */
    private String format;
	/**
	 * 发布标示(0-未发布,1-已发布,2-已终止)
	 */
    private String publish;
	/**
	 * 审核人用户ID
	 */
    private String auditer;
	/**
	 * 审核时间
	 */
    private Date auditDate;
	/**
	 * 是否允许下载office附件
	 */
    private String download;
	/**
	 * 最后编辑人
	 */
    private String lastEditor;
	/**
	 * 最后编辑时间
	 */
    private Date lastEditTime;
	/**
	 * 公告标题颜色
	 */
    private String subjectColor;
	/**
	 * 内容关键字
	 */
    private String keyword;
	/**
	 * 是否转发
	 */
    private String isFw;
    /**
	 * 按部门发布
	 */
    private String toId;
	/**
	 * 发布通知内容
	 */
    private String content;
	/**
	 * 附件ID串
	 */
    private String attachmentId;
	/**
	 * 附件名称串
	 */
    private String attachmentName;
	/**
	 * 阅读人员用户ID串
	 */
    private String readers;
	/**
	 * 按角色发布
	 */
    private String privId;
	/**
	 * 按人员发布
	 */
    private String userId;
	/**
	 * 审核人不同意的原因
	 */
    private String reason;
	/**
	 * 压缩后的公告通知内容
	 */
    private byte[] compressContent;
	/**
	 * 内容简介 
	 */
    private String summary;
    
    private Users users;
    private String name;
    /**
     * 
     * @Title: getName
     * @Description: 得到用户名
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getName() {
		return name;
	}
   /**
    * 
    * @Title: setName
    * @Description: 设置用户名
    * @author(作者):   张丽军
    * @date(日期):        2017-4-17 下午6:09:31 
    * @param: @param name   
    * @return: void   
    * @throws
    */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * 
     * @Title: getUsers
     * @Description:得到用户
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Users   
     * @throws
     */

	public Users getUsers() {
		return users;
	}
    /**
     * 
     * @Title: setUsers
     * @Description: 设置用户
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param users   
     * @return: void   
     * @throws
     */
	public void setUsers(Users users) {
		this.users = users;
	}
    /**
     * 
     * @Title: getToId
     * @Description: 得到按部门发布信息
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
	public String getToId() {
        return toId;
    }
    /**
     * 
     * @Title: setToId
     * @Description: 设置按部门发布信息
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param toId   
     * @return: void   
     * @throws
     */
    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }
    /**
     * 
     * @Title: getContent
     * @Description: 得到内容信息
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getContent() {
        return content;
    }
     /**
      * 
      * @Title: setContent
      * @Description: 设置没人信息
      * @author(作者):   张丽军
      * @date(日期):        2017-4-17 下午6:09:31
      * @param: @param content   
      * @return: void   
      * @throws
      */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    /**
     * 
     * @Title: getAttachmentId
     * @Description: 得到附件ID串
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getAttachmentId() {
        return attachmentId;
    }
    /**
     * 
     * @Title: setAttachmentId
     * @Description: 设置附件ID串
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param attachmentId   
     * @return: void   
     * @throws
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }
    /**
     * 
     * @Title: getAttachmentName
     * @Description: 得到附件名称串
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getAttachmentName() {
        return attachmentName;
    }
    /**
     * 
     * @Title: setAttachmentName
     * @Description: 设置附件名称串
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param attachmentName   
     * @return: void   
     * @throws
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }
    /**
     * 
     * @Title: getReaders
     * @Description: 得到阅读人员ID
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getReaders() {
        return readers;
    }
    /**
     * 
     * @Title: setReaders
     * @Description: 设置阅读人员ID
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param readers   
     * @return: void   
     * @throws
     */
    public void setReaders(String readers) {
        this.readers = readers == null ? null : readers.trim();
    }
    /**
     * 
     * @Title: getPrivId
     * @Description: 得到按角色发布ID
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getPrivId() {
        return privId;
    }
    /**
     * 
     * @Title: setPrivId
     * @Description: 设置按角色发布ID
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param privId   
     * @return: void   
     * @throws
     */
    public void setPrivId(String privId) {
        this.privId = privId == null ? null : privId.trim();
    }
    /**
     * 
     * @Title: getUserId
     * @Description: 得到用户ID
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getUserId() {
        return userId;
    }
    /**
     * 
     * @Title: setUserId
     * @Description: 设置用户ID
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param userId   
     * @return: void   
     * @throws
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
    /**
     * 
     * @Title: getReason
     * @Description:得到审核人不同意的原因
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getReason() {
        return reason;
    }
    /**
     * 
     * @Title: setReason
     * @Description: 设置审核人不同意的原因
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param reason   
     * @return: void   
     * @throws
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
    /**
     * 
     * @Title: getCompressContent
     * @Description: 得到压缩后的公告通知内容
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: byte[]   
     * @throws
     */
    public byte[] getCompressContent() {
        return compressContent;
    }
    /**
     * 
     * @Title: setCompressContent
     * @Description: 设置压缩后的公告通知内容
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param compressContent   
     * @return: void   
     * @throws
     */
    public void setCompressContent(byte[] compressContent) {
        this.compressContent = compressContent;
    }
    /**
     * 
     * @Title: getSummary
     * @Description: 获取内容简介信息
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getSummary() {
        return summary;
    }
    /**
     * 
     * @Title: setSummary
     * @Description: 设置内容简介信息
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param summary   
     * @return: void   
     * @throws
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
    /**
     * 
     * @Title: getNotifyId
     * @Description: 获取公告ID(主键)
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getNotifyId() {
        return notifyId;
    }
    /**
     * 
     * @Title: setNotifyId
     * @Description: 设置公告ID(主键)
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param notifyId   
     * @return: void   
     * @throws
     */
    public void setNotifyId(Integer notifyId) {
        this.notifyId = notifyId;
    }
    /**
     * 
     * @Title: getFromDept
     * @Description:获取发布部门ID
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getFromDept() {
        return fromDept;
    }
    /**
     * 
     * @Title: setFromDept
     * @Description: 设置发布部门ID
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param fromDept   
     * @return: void   
     * @throws
     */
    public void setFromDept(Integer fromDept) {
        this.fromDept = fromDept;
    }
    /**
     * 
     * @Title: getFromId
     * @Description: 获取发布用户ID(USER_ID)
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getFromId() {
        return fromId;
    }
    /**
     * 
     * @Title: setFromId
     * @Description: 设置发布用户ID(USER_ID)
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param fromId   
     * @return: void   
     * @throws
     */
    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }
    /**
     * 
     * @Title: getSubject
     * @Description:获取公告标题
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getSubject() {
        return subject;
    }
    /**
     * 
     * @Title: setSubject
     * @Description: 设置公告标题
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param subject   
     * @return: void   
     * @throws
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }
    /**
     * 
     * @Title: getSendTime
     * @Description: 获取发布时间
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Date   
     * @throws
     */
    public Date getSendTime() {
        return sendTime;
    }
    /**
     * 
     * @Title: setSendTime
     * @Description: 设置发布时间
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param sendTime   
     * @return: void   
     * @throws
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
    /**
     * 
     * @Title: getBeginDate
     * @Description: 获取开始日期
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getBeginDate() {
        return beginDate;
    }
    /**
     * 
     * @Title: setBeginDate
     * @Description: 设置开始日期
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param beginDate   
     * @return: void   
     * @throws
     */
    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }
    /**
     * 
     * @Title: getEndDate
     * @Description: 获取结束日期
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getEndDate() {
        return endDate;
    }
    /**
     * 
     * @Title: setEndDate
     * @Description: 设置结束日期
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param endDate   
     * @return: void   
     * @throws
     */
    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }
    /**
     * 
     * @Title: getPrint
     * @Description: 获取是否允许打印office附件信息(0-不允许,1-允许)
     * @author(作者):  张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getPrint() {
        return print;
    }
    /**
     * 
     * @Title: setPrint
     * @Description: 设置是否允许打印office附件信息(0-不允许,1-允许)
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param print   
     * @return: void   
     * @throws
     */
    public void setPrint(String print) {
        this.print = print == null ? null : print.trim();
    }
    /**
     * 
     * @Title: getTypeId
     * @Description: 获取公告类型ID
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getTypeId() {
        return typeId;
    }
    /**
     * 
     * @Title: setTypeId
     * @Description:设置公告类型ID
     * @author(作者):   张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param typeId   
     * @return: void   
     * @throws
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
    /**
     * 
     * @Title: getTop
     * @Description: 获取置顶信息
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getTop() {
        return top;
    }
    /**
     * 
     * @Title: setTop
     * @Description: 设置置顶信息
     * @author(作者):      张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param top   
     * @return: void   
     * @throws
     */
    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }
    /**
     * 
     * @Title: getTopDays
     * @Description: 获取置顶天数
     * @author(作者):      张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getTopDays() {
        return topDays;
    }
    /**
     * 
     * @Title: setTopDays
     * @Description: 设置置顶天数
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param topDays   
     * @return: void   
     * @throws
     */
    public void setTopDays(Integer topDays) {
        this.topDays = topDays;
    }
    /**
     * 
     * @Title: getFormat
     * @Description: 获取公告通知格式信息(0-普通格式,1-mht格式,2-超链接)
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getFormat() {
        return format;
    }
    /**
     * 
     * @Title: setFormat
     * @Description: 设置公告通知格式信息(0-普通格式,1-mht格式,2-超链接)
     * @author(作者):      张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param format   
     * @return: void   
     * @throws
     */
    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }
    /**
     * 
     * @Title: getPublish
     * @Description: 获取发布标识信息(0-未发布,1-已发布,2-待审批,3-未通过)
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getPublish() {
        return publish;
    }
    /**
     * 
     * @Title: setPublish
     * @Description: 设置发布标识信息(0-未发布,1-已发布,2-待审批,3-未通过)
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param publish   
     * @return: void   
     * @throws
     */
    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }
    /**
     * 
     * @Title: getAuditer
     * @Description: 获取审核人用户ID
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getAuditer() {
        return auditer;
    }
    /**
     * 
     * @Title: setAuditer
     * @Description: 设置审核人用户ID
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param auditer   
     * @return: void   
     * @throws
     */
    public void setAuditer(String auditer) {
        this.auditer = auditer == null ? null : auditer.trim();
    }
    /**
     * 
     * @Title: getAuditDate
     * @Description: 获取审核时间
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Date   
     * @throws
     */
    public Date getAuditDate() {
        return auditDate;
    }
    /**
     * 
     * @Title: setAuditDate
     * @Description: 设置审核时间
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param auditDate   
     * @return: void   
     * @throws
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
    /**
     * 
     * @Title: getDownload
     * @Description: 获取是否允许下载office附件(0-不允许,1-允许)
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getDownload() {
        return download;
    }
    /**
     * 
     * @Title: setDownload
     * @Description: 设置是否允许下载office附件(0-不允许,1-允许)
     * @author(作者):      张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param download   
     * @return: void   
     * @throws
     */
    public void setDownload(String download) {
        this.download = download == null ? null : download.trim();
    }
    /**
     * 
     * @Title: getLastEditor
     * @Description: 获取最后编辑人
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getLastEditor() {
        return lastEditor;
    }
    /**
     * 
     * @Title: setLastEditor
     * @Description: 设置最后编辑人
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param lastEditor   
     * @return: void   
     * @throws
     */
    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor == null ? null : lastEditor.trim();
    }
    /**
     * 
     * @Title: getLastEditTime
     * @Description: 获取最后编辑时间
     * @author(作者):      张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: Date   
     * @throws
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }
    /**
     * 
     * @Title: setLastEditTime
     * @Description: 设置最后编辑时间
     * @author(作者):      张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param lastEditTime   
     * @return: void   
     * @throws
     */
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
    /**
     * 
     * @Title: getSubjectColor
     * @Description: 获取公告标题颜色
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getSubjectColor() {
        return subjectColor;
    }
    /**
     * 
     * @Title: setSubjectColor
     * @Description: 设置公告标题颜色
     * @author(作者):    张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param subjectColor   
     * @return: void   
     * @throws
     */
    public void setSubjectColor(String subjectColor) {
        this.subjectColor = subjectColor == null ? null : subjectColor.trim();
    }
    /**
     * 
     * @Title: getKeyword
     * @Description: 获取内容关键字
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getKeyword() {
        return keyword;
    }
    /**
     * 
     * @Title: setKeyword
     * @Description: 设置内容关键字
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param keyword   
     * @return: void   
     * @throws
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
    /**
     * 
     * @Title: getIsFw
     * @Description:获取是否转发信息 
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getIsFw() {
        return isFw;
    }
    /**
     * 
     * @Title: setIsFw
     * @Description: 设置是否转发信息
     * @author(作者):     张丽军
     * @date(日期):        2017-4-17 下午6:09:31
     * @param: @param isFw   
     * @return: void   
     * @throws
     */
    public void setIsFw(String isFw) {
        this.isFw = isFw == null ? null : isFw.trim();
    }
}