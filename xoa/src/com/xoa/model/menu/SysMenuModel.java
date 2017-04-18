package com.xoa.model.menu;

import java.util.List;

/**
 * @ClassName (类名): 一级菜单
 * @Description(简述): TODO
 * @author(作者): wyq
 * @date(日期): 2017-4-17 下午5:39:47
 * 
 */
public class SysMenuModel {
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
	private List<SysFunctionModel> child;

	/**
	 * 
	 * @Title: getId
	 * @Description: 菜单ID
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @Title: setId
	 * @Description: 菜单ID
	 * @author(作者): wyq
	 * @param: @param id
	 * @return: void
	 * @throws
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @Title: getName
	 * @Description: 菜单名称
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @Title: setName
	 * @Description: 菜单名称
	 * @author(作者): wyq
	 * @param: @param name
	 * @return: void
	 * @throws
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @Title: getImg
	 * @Description: 菜单图片名
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getImg() {
		return img;
	}

	/**
	 * 
	 * @Title: setImg
	 * @Description: 菜单图片名
	 * @author(作者): wyq
	 * @param: @param img
	 * @return: void
	 * @throws
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * 
	 * @Title: getExt
	 * @Description: 菜单图片名
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getExt() {
		return ext;
	}

	/**
	 * 
	 * @Title: setExt
	 * @Description: 菜单图片名
	 * @author(作者): wyq
	 * @param: @param ext
	 * @return: void
	 * @throws
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}

	/**
	 * 
	 * @Title: getChild
	 * @Description: 对应二级菜单
	 * @author(作者): wyq
	 * @param: @return
	 * @return: List<SysFunction>
	 * @throws
	 */
	public List<SysFunctionModel> getChild() {
		return child;
	}

	/**
	 * 
	 * @Title: setChild
	 * @Description: 对应二级菜单
	 * @author(作者): wyq
	 * @param: @param child
	 * @return: void
	 * @throws
	 */
	public void setChild(List<SysFunctionModel> child) {
		this.child = child;
	}

}