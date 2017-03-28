package com.xoa.service.menu.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.menu.SysMenuMapper;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.model.worldnews.News;
import com.xoa.service.menu.MenuService;
import com.xoa.util.ToJson;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private SysMenuMapper sysMenuMapper;

	@Resource
	private SysFunctionMapper sysFunctionMapper;

	@Override
	public ToJson<SysMenu> getAll() {
		ToJson<SysMenu> toJson = new ToJson<>(0,"显示结果");
		List<SysMenu> list=sysMenuMapper.getDatagrid();
		      toJson.setObj(list);
		return toJson;
	}

	@Override
	public ToJson<SysFunction> getDadMenu(String menuId,String id) {
		ToJson<SysFunction> toJson=new ToJson<>(0,"显示结果");
		List<SysFunction> list=sysFunctionMapper.getDatagrid(menuId);
		List<SysFunction> list1=sysFunctionMapper.childMenu(id);
		if (list1.size()>0) {
			for (SysFunction sysFunction : list1) {
				list.add(sysFunction);
			}
		}
		
		  toJson.setObj(list);
		return toJson;
	}

	

}
