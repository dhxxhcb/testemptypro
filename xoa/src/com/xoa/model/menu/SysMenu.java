package com.xoa.model.menu;

import java.util.List;


/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:24:22
 * 类介绍  :   一级菜单
 * 构造参数:   无
 *
 */
public class SysMenu {
	/**
	 * 菜单ID
	 */
	private String id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单图片名
	 */
	private String img;
	/**
	 * 国际版多语言菜单名称
	 */
	private String ext;
	/**
	 * 对应二级菜单
	 */
	private List<SysFunction> child;

	
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

	
	public String getImg() {
		return img;
	}

	
	public void setImg(String img) {
		this.img = img;
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