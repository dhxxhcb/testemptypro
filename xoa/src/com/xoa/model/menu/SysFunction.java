package com.xoa.model.menu;

import java.util.List;

/**
 * 子类菜单实体类
 * @author wyq
 * @version 1.0
 */
public class SysFunction {
	/**
	 * 子类菜单ID
	 */
    private Integer fId;
    /**
	 * 子菜单项代码
	 */
    private String id;
    /**
	 * 子菜单名称
	 */
    private String name;
    /**
	 * 子菜单模块路径
	 */
    private String url;
    /**
	 * 国际版多语言菜单名称
	 */
    private String ext;
    
    private List<SysFunction> child;

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public List<SysFunction> getChild() {
		return child;
	}

	public void setChild(List<SysFunction> child) {
		this.child = child;
	}
    
	
}