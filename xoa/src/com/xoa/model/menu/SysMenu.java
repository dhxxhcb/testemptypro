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
	private String menuId;
	/**
	 *菜单名称
	 */
	private String menuName;
	/**
	 * 菜单图片名
	 */
	private String image;
	/**
	 * 国际版多语言菜单名称
	 */
	private String menuExt;

	private List<SysFunction> functionList;



	public List<SysFunction> getFunctionList() {
		return functionList;
	}
	public void setFunctionList(List<SysFunction> functionList) {
		this.functionList = functionList;
	}
	/**
	 * 菜单ID
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * 菜单ID
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId == null ? null : menuId.trim();
	}
	/**
	 *菜单名称
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 *菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	} 
	/**
	 * 菜单图片名
	 */

	public String getImage() {
		return image;
	}
	/**
	 * 菜单图片名
	 */
	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}
	/**
	 * 国际版多语言菜单名称
	 */
	public String getMenuExt() {
		return menuExt;
	}
	/**
	 * 国际版多语言菜单名称
	 */
	public void setMenuExt(String menuExt) {
		this.menuExt = menuExt == null ? null : menuExt.trim();
	}
}