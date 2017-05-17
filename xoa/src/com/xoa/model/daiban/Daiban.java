package com.xoa.model.daiban;

import java.util.List;

import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.notify.Notify;

public class Daiban {
	
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
