package com.xoa.service.menu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.menu.MobileAppMapper;
import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.menu.SysMenuMapper;
import com.xoa.model.menu.MobileApp;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;


/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:44:26
 * 类介绍  :    菜单ServiceImpl
 * 构造参数:   
 *
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private SysMenuMapper sysMenuMapper;//父类菜单DAO

	@Resource
	private SysFunctionMapper sysFunctionMapper;//子类菜单DAO
	
   @Override
	public List<SysMenu> getAll() {
		List<SysMenu> list=sysMenuMapper.getDatagrid();
	  for (SysMenu sysMenu : list) {
		  List<SysFunction> list1=sysFunctionMapper.getDatagrid(sysMenu.getId());
		  for (SysFunction sysFunction : list1) {
			  List<SysFunction> list2=sysFunctionMapper.childMenu(sysFunction.getId());
			  sysFunction.setChild(list2);
		}
		  sysMenu.setChild(list1);
	}
		return list;
	}
	
	
	@Override
	public List<SysFunction> getDadMenu(String menuId) {
		List<SysFunction> list=sysFunctionMapper.getDatagrid(menuId);
		for (SysFunction sysFunction : list) {
			List<SysFunction> list1=sysFunctionMapper.childMenu(sysFunction.getId());
			sysFunction.setChild(list1);
		}
		return list;
	}




	

}
