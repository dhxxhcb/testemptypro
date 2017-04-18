package com.xoa.model.file;
/**
 * 
 * @ClassName (类名):  FileScoreModel
 * @Description(简述): 公共文件柜文档打分表
 * @author(作者):      ys
 * @date(日期):        2017-4-17 下午4:15:02
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
	 * @Title: getScoreId
	 * @Description: 唯一自增ID
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public int getScoreId() {
		return scoreId;
	}
	/**
	 * 
	 * @Title: setScoreId
	 * @Description: 唯一自增ID
	 * @author(作者):      ys
	 * @param: @param scoreId   
	 * @return: void   
	 * @throws
	 */
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
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
	 * @Description: 打分用户的USERID
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
	 * @Description: 打分用户的USERID
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
	 * @Title: getSendTime
	 * @Description: 打分用户的USERID
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
	 * @Description: 打分用户的USERID
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
	 * @Title: getFraction
	 * @Description: 分数
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public int getFraction() {
		return fraction;
	}
	/**
	 * 
	 * @Title: setFraction
	 * @Description: 分数
	 * @author(作者):      ys
	 * @param: @param fraction   
	 * @return: void   
	 * @throws
	 */
	public void setFraction(int fraction) {
		this.fraction = fraction;
	}
	
}
