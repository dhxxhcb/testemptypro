package com.xoa.dao.menu;

import java.util.List;

import com.xoa.model.menu.SysFunction;

/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:29:08
 * 类介绍  :    子类菜单DAO
 * 构造参数:    无
 *
 */
public interface SysFunctionMapper {
     /**
      * 
      * 创建作者:   王曰岐
      * 创建日期:   2017-4-19 下午3:29:43
      * 方法介绍:   根据菜单Id得到子类菜单
      * 参数说明:   @param menuId
      * 参数说明:   @return
      * @return     List<SysFunction>
      */
	 public List<SysFunction> getDatagrid(String menuId);
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:29:54
	 * 方法介绍:   根据二级菜单Id得到子类菜单
	 * 参数说明:   @param id
	 * 参数说明:   @return
	 * @return     List<SysFunction>
	 */
	 public List<SysFunction> childMenu(String id);
	  /**
	   * 
	   * 创建作者:   王曰岐
	   * 创建日期:   2017-4-19 下午3:30:08
	   * 方法介绍:   获取全部子类菜单
	   * 参数说明:   @return
	   * @return     List<SysFunction>
	   */
	 public List<SysFunction> getAll();
}