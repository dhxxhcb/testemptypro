package com.xoa.service.menu;

import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;

import java.util.List;

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


    /**
    *@创建作者:  韩成冰
    *@创建日期:  2017/5/26 12:50
    *@函数介绍:  修改一级菜单
    *@参数说明:  @param sysMenu
    *@return:   void
    **/
    void updateSysMenu(SysMenu sysMenu);
}
