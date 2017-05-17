package com.xoa.model.daiban;

import java.util.List;

import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.notify.Notify;

public class Daiban {
	
	private String emainContent;
	
	private String notifyContent;

	public String getEmainContent() {
		return emainContent;
	}

	public void setEmainContent(String emainContent) {
		this.emainContent = emainContent;
	}

	public String getNotifyContent() {
		return notifyContent;
	}

	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}
	
	private String emailUrl;
	
	private String notifyUrl;
	
	

	public String getEmailUrl() {
		return emailUrl;
	}

	public void setEmailUrl(String emailUrl) {
		this.emailUrl = emailUrl;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	private List<EmailBodyModel> email;
	
	private List<Notify> notify;

	public List<EmailBodyModel> getEmail() {
		return email;
	}

	public void setEmail(List<EmailBodyModel> email) {
		this.email = email;
	}

	public List<Notify> getNotify() {
		return notify;
	}

	public void setNotify(List<Notify> notify) {
		this.notify = notify;
	}
	
	

}
