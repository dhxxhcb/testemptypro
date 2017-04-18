package com.xoa.service.menu.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.menu.SysMenuMapper;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;


@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private SysMenuMapper sysMenuMapper;

	@Resource
	private SysFunctionMapper sysFunctionMapper;

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
	public List<SysFunction> getDadMenu(String menuId,String id) {
		List<SysFunction> list=sysFunctionMapper.getDatagrid(menuId);
		List<SysFunction> list1=sysFunctionMapper.childMenu(id);
		if (list1.size()>0) {
			for (SysFunction sysFunction : list1) {
				list.add(sysFunction);
			}
		}
		return list;
	}

	

}
