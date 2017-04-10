package com.xoa.model.file;

public class File_Score {
	/**
	 * 唯一自增ID
	 */
	int score_id;
	/**
	 * 文件ID
	 */
	int file_id;
	/**
	 * 打分用户的USER_ID
	 */
	String user_id;
	/**
	 * 打分时间
	 */
	String send_time;
	/**
	 * 分数
	 */
	int fraction;
	public int getScore_id() {
		return score_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getSend_time() {
		return send_time;
	}
	public int getFraction() {
		return fraction;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public void setFraction(int fraction) {
		this.fraction = fraction;
	}
}
