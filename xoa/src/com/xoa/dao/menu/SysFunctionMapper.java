package com.xoa.dao.menu;

import java.util.List;

import com.xoa.model.menu.SysFunction;

public interface SysFunctionMapper {

	 public List<SysFunction> getDatagrid(String menuId);
	
	 public List<SysFunction> childMenu(String id);
}