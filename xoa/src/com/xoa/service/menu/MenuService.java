package com.xoa.service.menu;

import java.util.List;

import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;

/**
  * 
  * 创建作者:   王曰岐
  * 创建日期:   2017-4-19 下午3:43:43
  * 类介绍  :    菜单Service
  * 构造参数:   
  *
  */
public interface MenuService {
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:43:57
	 * 方法介绍:   获取全部菜单
	 * 参数说明:   @return
	 * @return     List<SysMenu>
	 */
	public List<SysMenu> getAll(String locale);
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:44:08
	 * 方法介绍:   获取子类菜单
	 * 参数说明:   @param menuId
	 * 参数说明:   @return
	 * @return     List<SysFunction>
	 */
	public List<SysFunction> getDadMenu(String menuId);
	
	

}
