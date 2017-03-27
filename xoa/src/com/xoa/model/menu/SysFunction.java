package com.xoa.model.menu;
/**
 * 子类菜单实体类
 * @author wyq
 * @version 1.0
 */
public class SysFunction {
	/**
	 * 子类菜单ID
	 */
    private Integer funcId;
    /**
	 * 子菜单项代码
	 */
    private String menuId;
    /**
	 * 子菜单名称
	 */
    private String funcName;
    /**
	 * 子菜单模块路径
	 */
    private String funcCode;
    /**
	 * 国际版多语言菜单名称
	 */
    private String funcExt;
    /**
	 * 子类菜单ID
	 */
    public Integer getFuncId() {
        return funcId;
    }
    /**
	 * 子类菜单ID
	 */
    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }
    /**
 	 * 子菜单项代码
 	 */
    public String getMenuId() {
        return menuId;
    }
    /**
 	 * 子菜单项代码
 	 */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
    /**
   	 * 子菜单名称
   	 */
    public String getFuncName() {
        return funcName;
    }
    /**
   	 * 子菜单名称
   	 */
    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }
    /**
   	 * 子菜单模块路径
   	 */
    public String getFuncCode() {
        return funcCode;
    }
    /**
   	 * 子菜单模块路径
   	 */
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode == null ? null : funcCode.trim();
    }
    /**
   	 * 国际版多语言菜单名称
   	 */
    public String getFuncExt() {
        return funcExt;
    }
    /**
   	 * 国际版多语言菜单名称
   	 */
    public void setFuncExt(String funcExt) {
        this.funcExt = funcExt == null ? null : funcExt.trim();
    }
}