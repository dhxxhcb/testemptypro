package com.xoa.model.users;

public class UserFunction {
	
	/**
	 * 对应user表的UID
	 */
	private int uid;
	/**
	 * 对应user表的USER_ID
	 */
	private String userId;
	/**
	 * 用户菜单ID串
	 */
	private String userFunCidStr;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserFunCidStr() {
		return userFunCidStr;
	}
	public void setUserFunCidStr(String userFunCidStr) {
		this.userFunCidStr = userFunCidStr;
	}
	
	

}
