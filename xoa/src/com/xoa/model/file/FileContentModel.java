package com.xoa.model.file;

/**
 * 
 * @ClassName (类名):  FileContentModel
 * @Description(简述): 文件柜文件表
 * @author(作者):      ys
 * @date(日期):        2017-4-17 下午4:16:59
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
      * @Title: getContentId
      * @Description: 自增唯一ID
      * @author(作者):      ys
      * @param: @return   
      * @return: int   
      * @throws
      */
	public int getContentId() {
		return contentId;
	}
	/**
	 * 
	 * @Title: setContentId
	 * @Description: 自增唯一ID
	 * @author(作者):      ys
	 * @param: @param contentId   
	 * @return: void   
	 * @throws
	 */
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	/**
	 * 
	 * @Title: getSortId
	 * @Description: 目录ID
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public int getSortId() {
		return sortId;
	}
	/**
	 * 
	 * @Title: setSortId
	 * @Description: 目录ID
	 * @author(作者):      ys
	 * @param: @param sortId   
	 * @return: void   
	 * @throws
	 */
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	/**
	 * 
	 * @Title: getSubject
	 * @Description: 文件名称
	 * @author(作者):      ys
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
	 * @Description: 文件名称
	 * @author(作者):      ys
	 * @param: @param subject   
	 * @return: void   
	 * @throws
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 
	 * @Title: getContent
	 * @Description: 文件内容
	 * @author(作者):      ys
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
	 * @Description: 文件内容
	 * @author(作者):      ys
	 * @param: @param content   
	 * @return: void   
	 * @throws
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 
	 * @Title: getSendTime
	 * @Description: 保存时间
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getSendTime() {
		return sendTime;
	}
	/**
	 * 
	 * @Title: setSendTime
	 * @Description: 保存时间
	 * @author(作者):      ys
	 * @param: @param sendTime   
	 * @return: void   
	 * @throws
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 
	 * @Title: getAttachmentId
	 * @Description: 附件ID串 ATTACHMENTID
	 * @author(作者):      ys
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
	 * @Description: 附件ID串 ATTACHMENTID
	 * @author(作者):      ys
	 * @param: @param attachmentId   
	 * @return: void   
	 * @throws
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	/**
	 * 
	 * @Title: getAttachmentName
	 * @Description: 附件名称串
	 * @author(作者):      ys
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
	 * @Description: 附件名称串
	 * @author(作者):      ys
	 * @param: @param attachmentName   
	 * @return: void   
	 * @throws
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	/**
	 * 
	 * @Title: getAttachmentDesc
	 * @Description: 附件描述
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getAttachmentDesc() {
		return attachmentDesc;
	}
	/**
	 * 
	 * @Title: setAttachmentDesc
	 * @Description: 附件描述
	 * @author(作者):      ys
	 * @param: @param attachmentDesc   
	 * @return: void   
	 * @throws
	 */
	public void setAttachmentDesc(String attachmentDesc) {
		this.attachmentDesc = attachmentDesc;
	}
	/**
	 * 
	 * @Title: getUserId
	 * @Description: 有访问权限的用户ID串
	 * @author(作者):      ys
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
	 * @Description: 有访问权限的用户ID串
	 * @author(作者):      ys
	 * @param: @param userId   
	 * @return: void   
	 * @throws
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 
	 * @Title: getContentNo
	 * @Description: 文件排序号
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public int getContentNo() {
		return contentNo;
	}
	/**
	 * 
	 * @Title: setContentNo
	 * @Description: 文件排序号
	 * @author(作者):      ys
	 * @param: @param contentNo   
	 * @return: void   
	 * @throws
	 */
	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}
	/**
	 * 
	 * @Title: getNewPerson
	 * @Description: 文件转发人
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getNewPerson() {
		return newPerson;
	}
	/**
	 * 
	 * @Title: setNewPerson
	 * @Description: 文件转发人
	 * @author(作者):      ys
	 * @param: @param newPerson   
	 * @return: void   
	 * @throws
	 */
	public void setNewPerson(String newPerson) {
		this.newPerson = newPerson;
	}
	/**
	 * 
	 * @Title: getReaders
	 * @Description: 阅读人员
	 * @author(作者):      ys
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
	 * @Description: 阅读人员
	 * @author(作者):      ys
	 * @param: @param readers   
	 * @return: void   
	 * @throws
	 */
	public void setReaders(String readers) {
		this.readers = readers;
	}
	/**
	 * 
	 * @Title: getCreater
	 * @Description: 创建人
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getCreater() {
		return creater;
	}
	/**
	 * 
	 * @Title: setCreater
	 * @Description: 创建人
	 * @author(作者):      ys
	 * @param: @param creater   
	 * @return: void   
	 * @throws
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	/**
	 * 
	 * @Title: getLogs
	 * @Description: 对该文件所做主要操作的日志
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getLogs() {
		return logs;
	}
	/**
	 * 
	 * @Title: setLogs
	 * @Description: 对该文件所做主要操作的日志
	 * @author(作者):      ys
	 * @param: @param logs   
	 * @return: void   
	 * @throws
	 */
	public void setLogs(String logs) {
		this.logs = logs;
	}
	/**
	 * 
	 * @Title: getKeyword
	 * @Description: 内容关键词
	 * @author(作者):      ys
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
	 * @Description: 内容关键词
	 * @author(作者):      ys
	 * @param: @param keyword   
	 * @return: void   
	 * @throws
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
