package com.xoa.model.user;

public class UserWithBLOBs extends User {
	/**
	 * 快捷菜单ID串
	 */
	private String shortcut;
	/**
	 * 今日资讯中的网址设置
	 */
	private String myRss;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 用户参数
	 */
	private String userPara;

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut == null ? null : shortcut.trim();
	}

	public String getMyRss() {
		return myRss;
	}

	public void setMyRss(String myRss) {
		this.myRss = myRss == null ? null : myRss.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getUserPara() {
		return userPara;
	}

	public void setUserPara(String userPara) {
		this.userPara = userPara == null ? null : userPara.trim();
	}
}