package com.xoa.model.file;

public class File_Comment {
	/**
	 * 唯一自增ID
	 */
	 int comment_id;
	 /**
	  * 文件ID
	  */
	 int file_id;
	 /**
	  * 点评用户的USER_ID
	  */
	 String user_id;
	 /**
	  * 点评内容 
	  */
	 String content;
	 /**
	  * 点评保存时间
	  */
	 String send_time;
	 
	public int getComment_id() {
		return comment_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getContent() {
		return content;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
}
