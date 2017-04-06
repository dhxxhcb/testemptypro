package com.xoa.service.menu;

import java.util.List;

import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.model.worldnews.News;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

public interface MenuService {
	
	@DynDatasource
	public List<SysMenu> getAll();
	
	@DynDatasource
	public List<SysFunction> getDadMenu(String menuId,String id);
	

}
