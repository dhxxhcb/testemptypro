package com.xoa.model.menu;

import java.util.List;

/**
 * 一级菜单实体类
 * @author wyq
 * @version 1.0
 */
public class SysMenu {
	/**
	 * 菜单ID
	 */
	private String id;
	/**
	 *菜单名称
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