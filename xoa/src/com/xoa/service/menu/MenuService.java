package com.xoa.service.menu;

import java.util.List;

import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;

public interface MenuService {
	
	public List<SysMenu> getAll();
	
	public List<SysFunction> getDadMenu(String menuId);
	
	public List<SysFunction> getChildMenu(String id);

}
