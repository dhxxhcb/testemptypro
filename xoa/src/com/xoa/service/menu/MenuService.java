package com.xoa.service.menu;

import java.util.List;

import com.xoa.model.menu.MobileApp;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.model.worldnews.News;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

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
	@DynDatasource
	public List<SysMenu> getAll();
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:44:08
	 * 方法介绍:   获取子类菜单
	 * 参数说明:   @param menuId
	 * 参数说明:   @return
	 * @return     List<SysFunction>
	 */
	@DynDatasource
	public List<SysFunction> getDadMenu(String menuId);
	
	

}
