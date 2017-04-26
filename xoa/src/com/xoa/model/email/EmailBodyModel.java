package com.xoa.model.email;

import java.io.Serializable;
import java.util.List;

import com.xoa.model.users.Users;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:45:51
 * 类介绍  :    发件箱、收件箱内容信息保存
 * 构造参数:   
 *
 */
public class EmailBodyModel implements Serializable {
	private static final long serialVersionUID = 1076969159692234636L;
	
	/**
	 * 时间段区间查询传入的开始时间
	 */
	private Integer startTime;

	/**
	 * 时间段区间查询传入的结束时间
	 */
	private Integer endTime;
	
	/**
	 * 第一个参数
	 */
	private String firstFlag;
	
	/**
	 * 第二个参数
	 */
	private String secondFlag;
	 
	/**
	 * 一对多（一个用户对应多个邮件）
	 */
	private Users users;
	/**
	 * 自增唯一ID
	 */
	private Integer bodyId;

	/**
	 * 发件人USER_ID
	 */
	private String fromId;
	
	/**
	 * 邮件主题
	 */
	private String subject;

	/**
	 * 发送时间
	 */
	private Integer sendTime;

	/**
	 * 是否已发送(0-未发送,1-已发送)
	 */
	private String sendFlag;

	/**
	 * 是否使用短信提醒(0-不提醒,1-提醒)
	 */
	private String smsRemind;

	/**
	 * 重要程度(空-一般邮件,1-重要,2-非常重要)
	 */
	private String important;

	/**
	 * 邮件大小
	 */
	private Long size;

	/**
	 * 从自己的哪个外部邮箱ID对应emailbox中id
	 */
	private Integer fromWebmailId;

	/**
	 * 从自己的哪个外部邮箱向外发送
	 */
	private String fromWebmail;

	/**
	 * 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 */
	private String webmailFlag;

	/**
	 * 接收外部邮箱名称
	 */
	private String recvFromName;
	/**
	 * 接收外部邮箱ID
	 */
	private String recvFrom;
	/**
	 * 发送外部邮件ID
	 */
	private Integer recvToId;
	/**
	 * 发送外部邮箱名称
	 */
	private String recvTo;
	/**
	 * 是否为外部邮件(0-内部邮件,1-外部邮件)
	 */
	private String isWebmail;
	/**
	 * 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 */
	private String isWf;
	/**
	 * 内容关键词
	 */
	private String keyword;
	/**
	 * 邮件密级等级
	 */
	private Integer secretLevel;
	/**
	 * 审核人USER_ID
	 * 
	 */
	private String auditMan;

	/**
	 * 收件人USER_ID串
	 */
	private String toId2;
	
	/**
	 * 收件人姓名
	 */
	private String toName;
	

	/**
	 * 抄送人USER_ID串
	 */
	private String copyToId;
	
	/**
	 * 抄送人姓名
	 */
	private String copyName;
	

	/**
	 * 密送人USER_ID串
	 */
	private String secretToId;
	
	/**
	 * 密送人姓名
	 */
	private String secretToName;

	/**
	 * 邮件内容
	 */
	private String content;

	/**
	 * 附件ID串
	 */
	private String attachmentId;

	/**
	 * 附件文件名串
	 */
	private String attachmentName;

	/**
	 * 外部收件人邮箱串
	 */
	private String toWebmail;

	/**
	 * 压缩后的邮件内容
	 */
	private byte[] compressContent;

	/**
	 * 外部邮件内容
	 */
	private byte[] webmailContent;

	/**
	 * 审核不通过备注
	 */
	private String auditRemark;
	/**
	 * 抄送外部邮箱串
	 */
	private String copyToWebmail;
	/**
	 * 密送外部邮箱串
	 */
	private String secretToWebmail;
	/**
	 * 点赞人user_id串
	 */
	private String praise;
	/**
	 * 一对多关联email
	 */
	private List<EmailModel> emailList;

	/**
	 * 一对多关联email
	 * 
	 * @return
	 */
	public List<EmailModel> getEmailList() {
		return emailList;
	}

	/**
	 * 一对多关联email
	 * 
	 * @param emailList
	 */
	public void setEmailList(List<EmailModel> emailList) {
		this.emailList = emailList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 收件人USER_ID串
	 */
	public String getToId2() {
		return toId2;
	}

	/**
	 * 收件人USER_ID串
	 */
	public void setToId2(String toId2) {
		this.toId2 = toId2;
	}

	/**
	 * 抄送人USER_ID串
	 */
	public String getCopyToId() {
		return copyToId;
	}

	/**
	 * 抄送人USER_ID串
	 */
	public void setCopyToId(String copyToId) {
		this.copyToId = copyToId;
	}

	/**
	 * 密送人USER_ID串
	 */
	public String getSecretToId() {
		return secretToId;
	}

	/**
	 * 密送人USER_ID串
	 */
	public void setSecretToId(String secretToId) {
		this.secretToId = secretToId;
	}

	/**
	 * 邮件内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 一对多（一个用户对应多个邮件）
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * 一对多（一个用户对应多个邮件）
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * 时间段区间查询传入的开始时间
	 */
	public Integer getStartTime() {
		return startTime;
	}

	/**
	 * 时间段区间查询传入的开始时间
	 */
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	/**
	 * 时间段区间查询传入的结束时间
	 */
	public Integer getEndTime() {
		return endTime;
	}

	/**
	 * 时间段区间查询传入的结束时间
	 */
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	/**
	 * 邮件内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 附件ID串
	 */
	public String getAttachmentId() {
		return attachmentId;
	}

	/**
	 * 附件ID串
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * 附件文件名串
	 */
	public String getAttachmentName() {
		return attachmentName;
	}

	/**
	 * 附件文件名串
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	/**
	 * 接收外部邮箱名称
	 */
	public void setRecvFromName(String recvFromName) {
		this.recvFromName = recvFromName;
	}

	/**
	 * 接收外部邮箱名称
	 */
	public String getToWebmail() {
		return toWebmail;
	}

	/**
	 * 外部收件人邮箱串
	 */
	public void setToWebmail(String toWebmail) {
		this.toWebmail = toWebmail;
	}

	/**
	 * 外部收件人邮箱串
	 */
	public byte[] getCompressContent() {
		return compressContent;
	}

	/**
	 * 压缩后的邮件内容
	 */
	public void setCompressContent(byte[] compressContent) {
		this.compressContent = compressContent;
	}

	/**
	 * 压缩后的邮件内容
	 */
	public byte[] getWebmailContent() {
		return webmailContent;
	}

	/**
	 * 外部邮件内容
	 */
	public void setWebmailContent(byte[] webmailContent) {
		this.webmailContent = webmailContent;
	}

	/**
	 * 外部邮件内容
	 */
	public String getAuditRemark() {
		return auditRemark;
	}

	/**
	 * 审核不通过备注
	 */
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	/**
	 * 抄送外部邮箱串
	 */
	public String getCopyToWebmail() {
		return copyToWebmail;
	}

	/**
	 * 抄送外部邮箱串
	 */
	public void setCopyToWebmail(String copyToWebmail) {
		this.copyToWebmail = copyToWebmail;
	}

	/**
	 * 密送外部邮箱串
	 */
	public String getSecretToWebmail() {
		return secretToWebmail;
	}

	/**
	 * 密送外部邮箱串
	 */
	public void setSecretToWebmail(String secretToWebmail) {
		this.secretToWebmail = secretToWebmail;
	}

	/**
	 * 点赞人user_id串
	 */
	public String getPraise() {
		return praise;
	}

	/**
	 * 点赞人user_id串
	 */
	public void setPraise(String praise) {
		this.praise = praise;
	}

	/**
	 * 自增唯一ID
	 */

	public Integer getBodyId() {
		return bodyId;
	}

	/**
	 * 自增唯一ID
	 */
	public void setBodyId(Integer bodyId) {
		this.bodyId = bodyId;
	}

	/**
	 * 自增唯一ID
	 */
	public String getFromId() {
		return fromId;
	}

	/**
	 * 发件人USER_ID
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId == null ? null : fromId.trim();
	}

	/**
	 * 邮件主题
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 邮件主题
	 */
	public void setSubject(String subject) {
		this.subject = subject == null ? null : subject.trim();
	}

	/**
	 * 发送时间
	 */
	public Integer getSendTime() {
		return sendTime;
	}

	/**
	 * 发送时间
	 */
	public void setSendTime(Integer sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * 是否已发送(0-未发送,1-已发送)
	 */
	public String getSendFlag() {
		return sendFlag;
	}

	/**
	 * 是否已发送(0-未发送,1-已发送)
	 */
	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag == null ? null : sendFlag.trim();
	}

	/**
	 * 是否使用短信提醒(0-不提醒,1-提醒)
	 */
	public String getSmsRemind() {
		return smsRemind;
	}

	/**
	 * 是否使用短信提醒(0-不提醒,1-提醒)
	 */
	public void setSmsRemind(String smsRemind) {
		this.smsRemind = smsRemind == null ? null : smsRemind.trim();
	}

	/**
	 * 重要程度(空-一般邮件,1-重要,2-非常重要)
	 */
	public String getImportant() {
		return important;
	}

	/**
	 * 重要程度(空-一般邮件,1-重要,2-非常重要)
	 */
	public void setImportant(String important) {
		this.important = important == null ? null : important.trim();
	}

	/**
	 * 邮件大小
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * 邮件大小
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * 从自己的哪个外部邮箱ID对应emailbox中id
	 */
	public Integer getFromWebmailId() {
		return fromWebmailId;
	}

	/**
	 * 从自己的哪个外部邮箱ID对应emailbox中id
	 */
	public void setFromWebmailId(Integer fromWebmailId) {
		this.fromWebmailId = fromWebmailId;
	}

	/**
	 * 从自己的哪个外部邮箱向外发送
	 */
	public String getFromWebmail() {
		return fromWebmail;
	}

	/**
	 * 从自己的哪个外部邮箱向外发送
	 */
	public void setFromWebmail(String fromWebmail) {
		this.fromWebmail = fromWebmail == null ? null : fromWebmail.trim();
	}

	/**
	 * 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 */
	public String getWebmailFlag() {
		return webmailFlag;
	}

	/**
	 * 外部邮件标记(0-未发送,1-正在准备发送,2-发送成功,3-发送失败)
	 */
	public void setWebmailFlag(String webmailFlag) {
		this.webmailFlag = webmailFlag == null ? null : webmailFlag.trim();
	}

	/**
	 * 接收外部邮箱名称
	 */
	public String getRecvFromName() {
		return recvFromName;
	}

	/**
	 * 接收外部邮箱名称
	 */
	public void From(String recvFromName) {
		this.recvFromName = recvFromName == null ? null : recvFromName.trim();
	}

	/**
	 * 接收外部邮箱ID
	 */
	public String getRecvFrom() {
		return recvFrom;
	}

	/**
	 * 接收外部邮箱ID
	 */
	public void setRecvFrom(String recvFrom) {
		this.recvFrom = recvFrom == null ? null : recvFrom.trim();
	}

	/**
	 * 发送外部邮件ID
	 */
	public Integer getRecvToId() {
		return recvToId;
	}

	/**
	 * 发送外部邮件ID
	 */
	public void setRecvToId(Integer recvToId) {
		this.recvToId = recvToId;
	}

	/**
	 * 发送外部邮箱名称
	 */
	public String getRecvTo() {
		return recvTo;
	}

	/**
	 * 发送外部邮箱名称
	 */
	public void setRecvTo(String recvTo) {
		this.recvTo = recvTo == null ? null : recvTo.trim();
	}

	/**
	 * 是否为外部邮件(0-内部邮件,1-外部邮件)
	 */
	public String getIsWebmail() {
		return isWebmail;
	}

	/**
	 * 是否为外部邮件(0-内部邮件,1-外部邮件)
	 */
	public void setIsWebmail(String isWebmail) {
		this.isWebmail = isWebmail == null ? null : isWebmail.trim();
	}

	/**
	 * 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 */
	public String getIsWf() {
		return isWf;
	}

	/**
	 * 是否同时外发(0-不外发,1-勾选向此人发送外部邮件)
	 */
	public void setIsWf(String isWf) {
		this.isWf = isWf == null ? null : isWf.trim();
	}

	/**
	 * 内容关键词
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 内容关键词
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
	}

	/**
	 * 邮件密级等级
	 */
	public Integer getSecretLevel() {
		return secretLevel;
	}

	/**
	 * 邮件密级等级
	 */
	public void setSecretLevel(Integer secretLevel) {
		this.secretLevel = secretLevel;
	}

	/**
	 * 审核人USER_ID
	 */
	public String getAuditMan() {
		return auditMan;
	}

	/**
	 * 审核人USER_ID
	 */
	public void setAuditMan(String auditMan) {
		this.auditMan = auditMan == null ? null : auditMan.trim();
	}
	
	
	/**
	 * 第一个参数
	 * @return
	 */
	public String getFirstFlag() {
		return firstFlag;
	}

	/**
	 * 第一个参数
	 * @param firstFlag
	 */
	public void setFirstFlag(String firstFlag) {
		this.firstFlag = firstFlag;
	}

	/**
	 * 第二个参数
	 * @return
	 */
	public String getSecondFlag() {
		return secondFlag;
	}

	/**
	 * 第二个参数
	 * @param secondFlag
	 */
	public void setSecondFlag(String secondFlag) {
		this.secondFlag = secondFlag;
	}

	/**
	 * 收件人姓名
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-26 下午6:12:54
	 * 方法介绍:   收件人姓名
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getToName() {
		return toName;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-26 下午6:14:11
	 * 方法介绍:   收件人姓名
	 * 参数说明:   @param toName
	 * @return     void
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-26 下午6:14:33
	 * 方法介绍:   抄送人姓名
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getCopyName() {
		return copyName;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-26 下午6:14:44
	 * 方法介绍:   抄送人姓名
	 * 参数说明:   @param copyName
	 * @return     void
	 */
	public void setCopyName(String copyName) {
		this.copyName = copyName;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-26 下午6:14:54
	 * 方法介绍:   密送人姓名
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSecretToName() {
		return secretToName;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-26 下午6:15:04
	 * 方法介绍:   密送人姓名
	 * 参数说明:   @param secretToName
	 * @return     void
	 */
	public void setSecretToName(String secretToName) {
		this.secretToName = secretToName;
	}
	
	
	
}