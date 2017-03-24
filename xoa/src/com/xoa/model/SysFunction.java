package com.xoa.model;

public class SysFunction {
    private Integer funcId;

    private String menuId;

    private String funcName;

    private String funcCode;

    private String funcExt;

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode == null ? null : funcCode.trim();
    }

    public String getFuncExt() {
        return funcExt;
    }

    public void setFuncExt(String funcExt) {
        this.funcExt = funcExt == null ? null : funcExt.trim();
    }
}