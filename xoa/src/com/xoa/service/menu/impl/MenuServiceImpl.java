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
		
		return sysMenuMapper.getDatagrid();
	}

	@Override
	public List<SysFunction> getDadMenu(String menuId) {
		// TODO Auto-generated method stub
		return sysFunctionMapper.getDatagrid(menuId);
	}

	@Override
	public List<SysFunction> getChildMenu(String id) {
		// TODO Auto-generated method stub
		return sysFunctionMapper.childMenu(id);
	}

}
