package com.xoa.model.file;

/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-18 下午7:39:35
 * 类介绍  :   公共文件柜文档打分表
 * 构造参数:   
 *
 */
public class FileScoreModel {
	/**
	 * 唯一自增ID
	 */
	int scoreId;
	/**
	 * 文件ID
	 */
	int fileId;
	/**
	 * 打分用户的USERID
	 */
	String userId;
	/**
	 * 打分时间
	 */
	String sendTime;
	/**
	 * 分数
	 */
	int fraction;

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:46:11
	 * 方法介绍:    唯一自增ID
	 * 参数说明:   @return
	 * @return     int
	 */
	public int getScoreId() {
		return scoreId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:46:26
	 * 方法介绍:   唯一自增ID
	 * 参数说明:   @param scoreId
	 * @return     void
	 */
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:46:39
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
	 * 创建日期:   2017-4-18 下午7:46:56
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
	 * 创建日期:   2017-4-18 下午7:47:09
	 * 方法介绍:   打分用户的USERID
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:47:22
	 * 方法介绍:   打分用户的USERID
	 * 参数说明:   @param userId
	 * @return     void
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:47:37
	 * 方法介绍:   打分时间
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSendTime() {
		return sendTime;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:47:51
	 * 方法介绍:   打分时间
	 * 参数说明:   @param sendTime
	 * @return     void
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:48:54
	 * 方法介绍:   分数
	 * 参数说明:   @return
	 * @return     int
	 */
	public int getFraction() {
		return fraction;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-18 下午7:49:10
	 * 方法介绍:   分数
	 * 参数说明:   @param fraction
	 * @return     void
	 */
	public void setFraction(int fraction) {
		this.fraction = fraction;
	}
	
}
