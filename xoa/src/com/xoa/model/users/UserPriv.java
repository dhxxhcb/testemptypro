package com.xoa.model.users;

 /**
 * @ClassName (类名):  UserPriv
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午5:36:41
 *
 */
public class UserPriv {
	/**
	 *角色ID
	 */
    private Integer userPriv;
    /**
	 *角色名称
	 */
    private String privName;
    /**
	 *角色编码
	 */
    private Short privNo;
    /**
	 *角色对应的功能ID串
	 */
    private String funcIdStr;
    /**
	 *所属部门
	 */
    private Integer privDeptId;
    /**
	 *角色类型
	 */
    private Byte privType;
    /**
	 *全局角色
	 */
    private Byte isGlobal;

    public Integer getUserPriv() {
        return userPriv;
    }

    public void setUserPriv(Integer userPriv) {
        this.userPriv = userPriv;
    }

    public String getPrivName() {
        return privName;
    }

    public void setPrivName(String privName) {
        this.privName = privName == null ? null : privName.trim();
    }

    public Short getPrivNo() {
        return privNo;
    }

    public void setPrivNo(Short privNo) {
        this.privNo = privNo;
    }

    public String getFuncIdStr() {
        return funcIdStr;
    }

    public void setFuncIdStr(String funcIdStr) {
        this.funcIdStr = funcIdStr == null ? null : funcIdStr.trim();
    }

    public Integer getPrivDeptId() {
        return privDeptId;
    }

    public void setPrivDeptId(Integer privDeptId) {
        this.privDeptId = privDeptId;
    }

    public Byte getPrivType() {
        return privType;
    }

    public void setPrivType(Byte privType) {
        this.privType = privType;
    }

    public Byte getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(Byte isGlobal) {
        this.isGlobal = isGlobal;
    }
}