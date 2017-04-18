package com.xoa.model.menu;

import java.util.List;

/**
 * @ClassName (类名): 子类菜单实体类
 * @Description(简述): TODO
 * @author(作者): wyq
 * @date(日期): 2017-4-17 下午5:43:33
 * 
 */
public class SysFunctionModel {
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
	/**
	 * 对应二级菜单
	 */
	private List<SysFunctionModel> child;

	/**
	 * 
	 * @Title: getfId
	 * @Description: 子类菜单ID
	 * @author(作者): wyq
	 * @param: @return
	 * @return: Integer
	 * @throws
	 */
	public Integer getfId() {
		return fId;
	}

	/**
	 * 
	 * @Title: setfId
	 * @Description: 子类菜单ID
	 * @author(作者): wyq
	 * @param: @param fId
	 * @return: void
	 * @throws
	 */
	public void setfId(Integer fId) {
		this.fId = fId;
	}

	/**
	 * 
	 * @Title: getId
	 * @Description: 子菜单项代码
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
	 * @Description: 子菜单项代码
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
	 * @Description: 子菜单名称
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
	 * @Description: 子菜单名称
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
	 * @Title: getUrl
	 * @Description: 子菜单模块路径
	 * @author(作者): wyq
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @Title: setUrl
	 * @Description: 子菜单模块路径
	 * @author(作者): wyq
	 * @param: @param url
	 * @return: void
	 * @throws
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @Title: getExt
	 * @Description: 国际版多语言菜单名称
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
	 * @Description: 国际版多语言菜单名称
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