package com.xoa.model.workflow;

public class FlowTimerWithBLOBs extends FlowTimer {
    private String userStr;

	private String deptStr;

	private String privStr;

	public String getUserStr() {
		return userStr;
	}

	public void setUserStr(String userStr) {
		this.userStr = userStr == null ? null : userStr.trim();
	}

	public String getDeptStr() {
		return deptStr;
	}

	public void setDeptStr(String deptStr) {
		this.deptStr = deptStr == null ? null : deptStr.trim();
	}

	public String getPrivStr() {
		return privStr;
	}

	public void setPrivStr(String privStr) {
		this.privStr = privStr == null ? null : privStr.trim();
	}


}