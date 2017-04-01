package com.xoa.model.file;

public class File_Content {
       int content_id;//自增唯一ID
       int sort_id;//目录ID
       String subject;//文件名称
       String content;//文件内容
       String send_time;//保存时间
       String attachment_id;//附件ID串 ATTACHMENT_ID
       String attachment_name;//附件名称串
       String attachment_desc;//附件描述
       String user_id;//有访问权限的用户ID串
       int content_no;//文件排序号
       String new_person;//文件转发人
       String readers;//阅读人员
       String creater;//创建人
       String logs;//对该文件所做主要操作的日志
       
	public int getContent_id() {
		return content_id;
	}
	public int getSort_id() {
		return sort_id;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getSend_time() {
		return send_time;
	}
	public String getAttachment_id() {
		return attachment_id;
	}
	public String getAttachment_name() {
		return attachment_name;
	}
	public String getAttachment_desc() {
		return attachment_desc;
	}
	public String getUser_id() {
		return user_id;
	}
	public int getContent_no() {
		return content_no;
	}
	public String getNew_person() {
		return new_person;
	}
	public String getReaders() {
		return readers;
	}
	public String getCreater() {
		return creater;
	}
	public String getLogs() {
		return logs;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public void setAttachment_id(String attachment_id) {
		this.attachment_id = attachment_id;
	}
	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}
	public void setAttachment_desc(String attachment_desc) {
		this.attachment_desc = attachment_desc;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}
	public void setNew_person(String new_person) {
		this.new_person = new_person;
	}
	public void setReaders(String readers) {
		this.readers = readers;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public void setLogs(String logs) {
		this.logs = logs;
	}
}
