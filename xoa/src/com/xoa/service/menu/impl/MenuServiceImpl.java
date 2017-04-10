package com.xoa.service.menu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.menu.SysMenuMapper;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;
import com.xoa.service.users.UserFunctionService;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private SysMenuMapper sysMenuMapper;

	@Resource
	private SysFunctionMapper sysFunctionMapper;
	@Resource
	private UserFunctionService UserFunctionService;

	@Override
	public List<SysMenu> getAll(int fId) {
		List<SysMenu> list = sysMenuMapper.getDatagrid();
		for (SysMenu sysMenu : list) {
			List<SysFunction> list1 = sysFunctionMapper.getDatagrid(sysMenu
					.getId());
			for (SysFunction sysFunction : list1) {
				List<SysFunction> list3 = UserFunctionService.getMenu(fId);
				for (SysFunction sysFunction2 : list3) {
					if (sysFunction.getId().equals(sysFunction2.getId())) {
						List<SysFunction> list2 = sysFunctionMapper
								.childMenu(sysFunction.getId());
						sysFunction.setChild(list2);
						sysMenu.setChild(list1);
					}

				}

			}
			if (sysMenu.getChild() == null) {
				/*sysMenu.setId(null);
				sysMenu.setImg(null);
				sysMenu.setExt(null);
				sysMenu.setName(null);*/
				sysMenu=null;
			}
		}

		System.out.println(list.size());
		return list;
	}
	
}
