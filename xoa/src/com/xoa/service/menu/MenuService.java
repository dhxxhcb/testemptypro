package com.xoa.service.menu;

import java.util.List;

import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.model.worldnews.News;
import com.xoa.util.ToJson;

public interface MenuService {
	
	public ToJson<SysMenu> getAll();
	
	public ToJson<SysFunction> getDadMenu(String menuId,String id);
	

}
