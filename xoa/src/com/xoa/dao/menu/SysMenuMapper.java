package com.xoa.dao.menu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xoa.model.menu.SysMenu;

/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:30:27
 * 类介绍  :    一级菜单DAO
 * 构造参数:    无
 *
 */
public interface SysMenuMapper {
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:30:40
	 * 方法介绍:   获取全部一级菜单
	 * 参数说明:   @return
	 * @return     List<SysMenu>
	 */
	public List<SysMenu> getDatagrid();
	
	
}