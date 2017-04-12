package com.xoa.model.notify;

import java.util.Date;
import java.util.List;

import com.xoa.model.users.Users;

public class Notify {
	/**
	 * 唯一自增ID
	 */
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
	 * 是否置顶
	 */
    private String top;
	/**
	 * 置顶天数
	 */
    private Integer topDays;
	/**
	 * 公告通知格式
	 */
    private String format;
	/**
	 * 发布标示
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
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Notify no;
	private List<Notify> noL;

    
    
    public Notify getNo() {
		return no;
	}

	public void setNo(Notify no) {
		this.no = no;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getReaders() {
        return readers;
    }

    public void setReaders(String readers) {
        this.readers = readers == null ? null : readers.trim();
    }

    public String getPrivId() {
        return privId;
    }

    public void setPrivId(String privId) {
        this.privId = privId == null ? null : privId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public byte[] getCompressContent() {
        return compressContent;
    }

    public void setCompressContent(byte[] compressContent) {
        this.compressContent = compressContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
    
    public Integer getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Integer notifyId) {
        this.notifyId = notifyId;
    }

    public Integer getFromDept() {
        return fromDept;
    }

    public void setFromDept(Integer fromDept) {
        this.fromDept = fromDept;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print == null ? null : print.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }

    public Integer getTopDays() {
        return topDays;
    }

    public void setTopDays(Integer topDays) {
        this.topDays = topDays;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }

    public String getAuditer() {
        return auditer;
    }

    public void setAuditer(String auditer) {
        this.auditer = auditer == null ? null : auditer.trim();
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download == null ? null : download.trim();
    }

    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor == null ? null : lastEditor.trim();
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getSubjectColor() {
        return subjectColor;
    }

    public void setSubjectColor(String subjectColor) {
        this.subjectColor = subjectColor == null ? null : subjectColor.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getIsFw() {
        return isFw;
    }

    public void setIsFw(String isFw) {
        this.isFw = isFw == null ? null : isFw.trim();
    }
}