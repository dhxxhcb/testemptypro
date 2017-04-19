package com.xoa.model.department;

import java.util.List;

import com.xoa.model.users.Users;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月19日 上午11:50:52
 * 类介绍  :   
 * 构造参数:   
 *
 */
public class Department {
	/**
	 * 自增唯一ID
	 */
    private Integer deptId;
    /**
	 * 部门名称
	 */
    private String deptName;
    /**
	 * 电话
	 */
    private String telNo;
    /**
	 * 传真
	 */
    private String faxNo;
    /**
	 * 部门地址
	 */
    private String deptAddress;
    /**
	 * 部门排序号
	 */
    private String deptNo;
    /**
	 * 上级部门ID
	 */
    private Integer deptParent;
    /**
	 * 是否是分支机构(0-否,1-是)
	 */
    private String isOrg;
    /**
	 * 机构管理员
	 */
    private String orgAdmin;
    /**
	 * 保密邮件审核人
	 */
    private String deptEmailAuditsIds;
    /**
	 * null
	 */
    private Integer weixinDeptId;
    /**
	 * 叮叮对应部门id
	 */
    private Integer dingdingDeptId;
    /**
	 * 是否全局部门(0-否,1-是)
	 */
    private Byte gDept;
    /**
	 * 部门主管
	 */
    private String manager;
    /**
	 * 部门助理
	 */
    private String assistantId;
    /**
	 * 上级主管领导
	 */
    private String leader1;
    /**
	 * 上级分管领导
	 */
    private String leader2;
    /**
	 * 部门职能
	 */
    private String deptFunc;
    
    private List<Users> users;
 
    public String getManager() {
        return manager;
    }

    public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId == null ? null : assistantId.trim();
    }

    public String getLeader1() {
        return leader1;
    }

    public void setLeader1(String leader1) {
        this.leader1 = leader1 == null ? null : leader1.trim();
    }

    public String getLeader2() {
        return leader2;
    }

    public void setLeader2(String leader2) {
        this.leader2 = leader2 == null ? null : leader2.trim();
    }

    public String getDeptFunc() {
        return deptFunc;
    }

    public void setDeptFunc(String deptFunc) {
        this.deptFunc = deptFunc == null ? null : deptFunc.trim();
    }
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo == null ? null : faxNo.trim();
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress == null ? null : deptAddress.trim();
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }

    public Integer getDeptParent() {
        return deptParent;
    }

    public void setDeptParent(Integer deptParent) {
        this.deptParent = deptParent;
    }

    public String getIsOrg() {
        return isOrg;
    }

    public void setIsOrg(String isOrg) {
        this.isOrg = isOrg == null ? null : isOrg.trim();
    }

    public String getOrgAdmin() {
        return orgAdmin;
    }

    public void setOrgAdmin(String orgAdmin) {
        this.orgAdmin = orgAdmin == null ? null : orgAdmin.trim();
    }

    public String getDeptEmailAuditsIds() {
        return deptEmailAuditsIds;
    }

    public void setDeptEmailAuditsIds(String deptEmailAuditsIds) {
        this.deptEmailAuditsIds = deptEmailAuditsIds == null ? null : deptEmailAuditsIds.trim();
    }

    public Integer getWeixinDeptId() {
        return weixinDeptId;
    }

    public void setWeixinDeptId(Integer weixinDeptId) {
        this.weixinDeptId = weixinDeptId;
    }

    public Integer getDingdingDeptId() {
        return dingdingDeptId;
    }

    public void setDingdingDeptId(Integer dingdingDeptId) {
        this.dingdingDeptId = dingdingDeptId;
    }

    public Byte getgDept() {
        return gDept;
    }

    public void setgDept(Byte gDept) {
        this.gDept = gDept;
    }
}