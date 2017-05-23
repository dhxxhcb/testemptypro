package com.xoa.util;


 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月20日 下午2:30:48
 * 类介绍  :    菜单枚举类
 * 构造参数:   
 *
 */
public enum ModuleEnum {
	EMAIL("email",1),WORKFLOW("workflow",2),FILEFLODER("filefolder",3),IM("im",26);
	
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
