package com.xoa.model.file;
/**
 * 
 * @ClassName (类名):  FileCommentModel
 * @Description(简述): 公共文件柜文档评论表
 * @author(作者):      ys
 * @date(日期):        2017-4-17 下午4:17:21
 *
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
	  * @Title: getCommentId
	  * @Description: 唯一自增ID
	  * @author(作者):      ys
	  * @param: @return   
	  * @return: int   
	  * @throws
	  */
	public int getCommentId() {
		return commentId;
	}
	/**
	 * 
	 * @Title: setCommentId
	 * @Description: 唯一自增ID
	 * @author(作者):      ys
	 * @param: @param commentId   
	 * @return: void   
	 * @throws
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	/**
	 * 
	 * @Title: getFileId
	 * @Description: 文件ID
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public int getFileId() {
		return fileId;
	}
	/**
	 * 
	 * @Title: setFileId
	 * @Description: 文件ID
	 * @author(作者):      ys
	 * @param: @param fileId   
	 * @return: void   
	 * @throws
	 */
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	/**
	 * 
	 * @Title: getUserId
	 * @Description: 点评用户的USERID
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
	 * @Description: 点评用户的USERID
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
	 * @Title: getContent
	 * @Description: 点评内容 
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
	 * @Description: 点评内容 
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
	 * @Description: 点评保存时间
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
	 * @Description: 点评保存时间
	 * @author(作者):      ys
	 * @param: @param sendTime   
	 * @return: void   
	 * @throws
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
}
