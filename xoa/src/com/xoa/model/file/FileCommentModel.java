package com.xoa.model.file;

/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-18 下午7:40:09
 * 类介绍  :   公共文件柜文档评论表
 * 构造参数:   
 */
public class FileCommentModel {
	/**
	 * 唯一自增ID
	 */
	 int commentId;
	 /**
	  * 文件ID
	  */
	 int fileId;
	 /**
	  * 点评用户的USERID
	  */
	 String userId;
	 /**
	  * 点评内容 
	  */
	 String content;
	 /**
	  * 点评保存时间
	  */
	 String sendTime;

	 /**
	  * 
	  * 创建作者:   杨 胜
	  * 创建日期:   2017-4-18 下午7:41:37
	  * 方法介绍:    唯一自增ID
	  * 参数说明:   @return
	  * @return     int
	  */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:43:00
	 * 方法介绍:   唯一自增ID
	 * 参数说明:   @param commentId
	 * @return     void
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:43:16
	 * 方法介绍:   文件ID
	 * 参数说明:   @return
	 * @return     int
	 */
	public int getFileId() {
		return fileId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:43:43
	 * 方法介绍:   文件ID
	 * 参数说明:   @param fileId
	 * @return     void
	 */
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:43:59
	 * 方法介绍:   点评用户的USERID
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:44:19
	 * 方法介绍:   点评用户的USERID
	 * 参数说明:   @param userId
	 * @return     void
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:44:57
	 * 方法介绍:   点评内容 
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:45:15
	 * 方法介绍:   点评内容 
	 * 参数说明:   @param content
	 * @return     void
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:45:29
	 * 方法介绍:   点评保存时间
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:45:43
	 * 方法介绍:   点评保存时间
	 * 参数说明:   @param sendTime
	 * @return     void
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
}
