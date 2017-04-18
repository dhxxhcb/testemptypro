package com.xoa.dao.menu;

import java.util.List;

import com.xoa.model.menu.SysFunctionModel;
/**
 * 
 * @ClassName (类名):  SysFunctionMapper
 * @Description(简述): 子类菜单
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午5:56:10
 *
 */
public interface SysFunctionMapper {
/**
 * 
 * @Title: getDatagrid
 * @Description: 根据一级菜单Id得到子类菜单
 * @author(作者):      wyq
 * @param: @param menuId
 * @param: @return   
 * @return: List<SysFunction>   
 * @throws
 */
	 public List<SysFunctionModel> getDatagrid(String menuId);
	/**
	 * 
	 * @Title: childMenu
	 * @Description:根据二级菜单Id得到子类菜单
	 * @author(作者):      wyq
	 * @param: @param id
	 * @param: @return   
	 * @return: List<SysFunction>   
	 * @throws
	 */
	 public List<SysFunctionModel> childMenu(String id);
	 /**
	  * 
	  * @Title: getAll
	  * @Description: 获取全部菜单
	  * @author(作者):      wyq
	  * @param: @return   
	  * @return: List<SysFunction>   
	  * @throws
	  */
	 public List<SysFunctionModel> getAll();
}