package com.xoa.model.file;

/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-18 下午7:39:53
 * 类介绍  :   文件柜文件表
 * 构造参数:   
 *
 */
public class FileContentModel {
	 /**
	  * 自增唯一ID
	  */
       int contentId;
       /**
        * 目录ID
        */
       int sortId;
       /**
        * 文件名称
        */
       String subject;
       /**
        * 文件内容
        */
       String content;
       /**
        * 保存时间
        */
       String sendTime;
       /**
        * 附件ID串 ATTACHMENTID
        */
       String attachmentId;
       /**
        * 附件名称串
        */
       String attachmentName;
       /**
        * 附件描述
        */
       String attachmentDesc;
       /**
        * 有访问权限的用户ID串
        */
       String userId;
       /**
        * 文件排序号
        */
       int contentNo;
       /**
        * 文件转发人
        */
       String newPerson;
       /**
        * 阅读人员
        */
       String readers;
       /**
        * 创建人
        */
       String creater;
       /**
        * 对该文件所做主要操作的日志
        */
       String logs;
       /**
        * 内容关键词
        */
       String keyword;
       
       /**
        * 
        * 创建作者:   杨 胜
        * 创建日期:   2017-4-18 下午7:49:31
        * 方法介绍:   自增唯一ID
        * 参数说明:   @return
        * @return     int
        */
	public int getContentId() {
		return contentId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:49:45
	 * 方法介绍:   自增唯一ID
	 * 参数说明:   @param contentId
	 * @return     void
	 */
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:49:56
	 * 方法介绍:   目录ID
	 * 参数说明:   @return
	 * @return     int
	 */
	public int getSortId() {
		return sortId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:50:07
	 * 方法介绍:   目录ID
	 * 参数说明:   @param sortId
	 * @return     void
	 */
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:50:19
	 * 方法介绍:   文件名称
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:50:32
	 * 方法介绍:   文件名称
	 * 参数说明:   @param subject
	 * @return     void
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:50:44
	 * 方法介绍:   文件内容
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:50:56
	 * 方法介绍:   文件内容
	 * 参数说明:   @param content
	 * @return     void
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:51:10
	 * 方法介绍:   保存时间
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:51:20
	 * 方法介绍:   保存时间
	 * 参数说明:   @param sendTime
	 * @return     void
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:51:31
	 * 方法介绍:   附件ID串 ATTACHMENTID
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getAttachmentId() {
		return attachmentId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:51:47
	 * 方法介绍:   附件ID串 ATTACHMENTID
	 * 参数说明:   @param attachmentId
	 * @return     void
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:52:36
	 * 方法介绍:   附件名称串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getAttachmentName() {
		return attachmentName;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:52:47
	 * 方法介绍:   附件名称串
	 * 参数说明:   @param attachmentName
	 * @return     void
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:52:58
	 * 方法介绍:   附件描述
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getAttachmentDesc() {
		return attachmentDesc;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:53:10
	 * 方法介绍:   附件描述
	 * 参数说明:   @param attachmentDesc
	 * @return     void
	 */
	public void setAttachmentDesc(String attachmentDesc) {
		this.attachmentDesc = attachmentDesc;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:53:21
	 * 方法介绍:   有访问权限的用户ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:53:32
	 * 方法介绍:   有访问权限的用户ID串
	 * 参数说明:   @param userId
	 * @return     void
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:53:42
	 * 方法介绍:   文件排序号
	 * 参数说明:   @return
	 * @return     int
	 */
	public int getContentNo() {
		return contentNo;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:53:52
	 * 方法介绍:   文件排序号
	 * 参数说明:   @param contentNo
	 * @return     void
	 */
	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:54:04
	 * 方法介绍:   文件转发人
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getNewPerson() {
		return newPerson;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:54:15
	 * 方法介绍:   文件转发人
	 * 参数说明:   @param newPerson
	 * @return     void
	 */
	public void setNewPerson(String newPerson) {
		this.newPerson = newPerson;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:54:24
	 * 方法介绍:   阅读人员
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getReaders() {
		return readers;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:54:35
	 * 方法介绍:   阅读人员
	 * 参数说明:   @param readers
	 * @return     void
	 */
	public void setReaders(String readers) {
		this.readers = readers;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:54:51
	 * 方法介绍:   创建人
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getCreater() {
		return creater;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:55:02
	 * 方法介绍:   创建人
	 * 参数说明:   @param creater
	 * @return     void
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:55:18
	 * 方法介绍:   对该文件所做主要操作的日志
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getLogs() {
		return logs;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:55:34
	 * 方法介绍:   对该文件所做主要操作的日志
	 * 参数说明:   @param logs
	 * @return     void
	 */
	public void setLogs(String logs) {
		this.logs = logs;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:55:48
	 * 方法介绍:   内容关键词
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:55:59
	 * 方法介绍:   内容关键词
	 * 参数说明:   @param keyword
	 * @return     void
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
