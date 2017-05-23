package com.xoa.model.workflow;

public class FlowTimerWithBLOBs extends FlowTimer {
//	 <result column="USER_NAME" javaType="java.lang.String" property="userName" />
//    <result column="TYPE_NAME" javaType="java.lang.String" property="typeName" />
//    <result column="DEPT_NAME" javaType="java.lang.String" property="deptName" />
//    <result column="ROLE_NAME" javaType="java.lang.String" property="roleName" />
    private String userStr;

	private String deptStr;

	private String privStr;

	private String userName;

	private String typeName;

	private String deptName;

	private String roleName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

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