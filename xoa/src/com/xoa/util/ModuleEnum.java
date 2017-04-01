package com.xoa.util;

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
