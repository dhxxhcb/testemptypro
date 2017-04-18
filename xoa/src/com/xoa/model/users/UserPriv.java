package com.xoa.model.users;

public class UserPriv {
    private Integer userPriv;

    private String privName;

    private Short privNo;

    private String funcIdStr;

    private Integer privDeptId;

    private Byte privType;

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