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
 * @ClassName (类名):  MenuService
 * @Description(简述): 菜单
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午5:59:48
 *
 */
public interface MenuService {
	
	/**
	 * 
	 * @Title: getAll
	 * @Description: 获取一级菜单
	 * @author(作者):      wyq
	 * @param: @return   
	 * @return: List<SysMenu>   
	 * @throws
	 */
	@DynDatasource
	public List<SysMenu> getAll();
	
	/**
	 * 
	 * @Title: getDadMenu
	 * @Description: 获取子类级菜单
	 * @author(作者):      wyq
	 * @param: @param menuId
	 * @param: @return   
	 * @return: List<SysFunction>   
	 * @throws
	 */
	@DynDatasource
	public List<SysFunction> getDadMenu(String menuId);
	
	

}
