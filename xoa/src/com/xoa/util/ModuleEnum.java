package com.xoa.util;
/**
 * 菜单枚举类（用于获取菜单名称与编号）
  * @author 作者:  zlf
  * @version 版本： 1.0 
  * @parameter 
  * @since 
  * @return 
  */

public enum ModuleEnum {
	EMAIL("email",1),WORKFLOW("workflow",2),FILEFLODER("filefolder",3);
	
	private String name;
	private int index;
	private ModuleEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
