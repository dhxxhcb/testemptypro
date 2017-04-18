package com.xoa.service.menu.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.menu.MobileAppMapper;
import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.menu.SysMenuMapper;
import com.xoa.model.menu.MobileAppModel;
import com.xoa.model.menu.SysFunctionModel;
import com.xoa.model.menu.SysMenuModel;
import com.xoa.service.menu.MenuService;

/**
 * 
 * @ClassName (类名):  MenuServiceImpl
 * @Description(简述): 菜单
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午6:01:31
 *
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private SysMenuMapper sysMenuMapper;//父类菜单DAO

	@Resource
	private SysFunctionMapper sysFunctionMapper;//子类菜单DAO
	
/**
 * 
 * <p>Title: getAll</p>
 * <p>Description: </p>
 * @return
 * @author(作者):  wyq
 * @see com.xoa.service.menu.MenuService#getAll()
 */
	@Override
	public List<SysMenuModel> getAll() {
		List<SysMenuModel> list=sysMenuMapper.getDatagrid();
	  for (SysMenuModel sysMenu : list) {
		  List<SysFunctionModel> list1=sysFunctionMapper.getDatagrid(sysMenu.getId());
		  for (SysFunctionModel sysFunction : list1) {
			  List<SysFunctionModel> list2=sysFunctionMapper.childMenu(sysFunction.getId());
			  sysFunction.setChild(list2);
		}
		  sysMenu.setChild(list1);
	}
		return list;
	}
/**
 * 
 * <p>Title: getDadMenu</p>
 * <p>Description: </p>
 * @param menuId
 * @return
 * @author(作者):  wyq
 * @see com.xoa.service.menu.MenuService#getDadMenu(java.lang.String)
 */
	@Override
	public List<SysFunctionModel> getDadMenu(String menuId) {
		List<SysFunctionModel> list=sysFunctionMapper.getDatagrid(menuId);
		for (SysFunctionModel sysFunction : list) {
			List<SysFunctionModel> list1=sysFunctionMapper.childMenu(sysFunction.getId());
			sysFunction.setChild(list1);
		}
		return list;
	}




	

}
