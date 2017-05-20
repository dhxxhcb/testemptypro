package com.xoa.model.workflow;

import java.util.Date;

public class FlowTimer {
    private Integer tid;

	private Integer flowId;

	private String type;

	private String remindDate;

	private Date remindTime;

	private Date lastTime;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getRemindDate() {
		return remindDate;
	}

	public void setRemindDate(String remindDate) {
		this.remindDate = remindDate == null ? null : remindDate.trim();
	}

	public Date getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(Date remindTime) {
		this.remindTime = remindTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}


}