package com.xoa.controller.im.Model;

/**
 * Im message对象 返回模型
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-5-20 上午9:34:39
 * 类介绍  :   
 * 构造参数:   
 *
 */
public class ImMessageModel{
    private String from_uid;//
    private String to_uid;//

    private String of_from;//

    private String content;//
    private String of_to;

    private String uuid;

    private String type;

    private Files file;
    private String  time;
    
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ImMessageModel(){
    	
    }

	public ImMessageModel(String from_uid, String to_uid, String of_from,
			String content, String of_to, String uuid, String type, Files file,String time) {
		super();
		this.from_uid = from_uid;
		this.to_uid = to_uid;
		this.of_from = of_from;
		this.content = content;
		this.of_to = of_to;
		this.uuid = uuid;
		this.type = type;
		this.file = file;
		this.time = time;
	}

	public String getFrom_uid() {
		return from_uid;
	}

	public void setFrom_uid(String from_uid) {
		this.from_uid = from_uid;
	}

	public String getTo_uid() {
		return to_uid;
	}

	public void setTo_uid(String to_uid) {
		this.to_uid = to_uid;
	}

	public String getOf_from() {
		return of_from;
	}

	public void setOf_from(String of_from) {
		this.of_from = of_from;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOf_to() {
		return of_to;
	}

	public void setOf_to(String of_to) {
		this.of_to = of_to;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Files getFile() {
		return file;
	}

	public void setFile(Files file) {
		this.file = file;
	}

}