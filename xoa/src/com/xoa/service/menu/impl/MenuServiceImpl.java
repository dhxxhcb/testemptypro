package com.xoa.service.menu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.xoa.dao.menu.MobileAppMapper;
import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.menu.SysMenuMapper;
import com.xoa.model.menu.MobileApp;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.menu.MenuService;

/**
 * 
 * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:44:26 类介绍 : 菜单ServiceImpl 构造参数:
 * 
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private SysMenuMapper sysMenuMapper;// 父类菜单DAO

	@Resource
	private SysFunctionMapper sysFunctionMapper;// 子类菜单DAO

	/**
	 * 
	 * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:43:57 方法介绍: 获取全部菜单 参数说明: @return
	 * 
	 * @return List<SysMenu>
	 */
	@Override
	public List<SysMenu> getAll(String locale) {
		List<SysMenu> list = sysMenuMapper.getDatagrid();
		for (SysMenu sysMenu : list) {
			if (locale.equals("zh_CN")) {
				sysMenu.setName(sysMenu.getName());
			} else if (locale.equals("en_US")) {
				sysMenu.setName(sysMenu.getName1());
			}else if (locale.equals("zh_TW")) {
				sysMenu.setName(sysMenu.getName2());
			}
			List<SysFunction> list1 = sysFunctionMapper.getDatagrid(sysMenu
					.getId());
			for (SysFunction sysFunction : list1) {
				if (locale.equals("zh_CN")) {
					sysFunction.setName(sysFunction.getName());
				} else if (locale.equals("en_US")) {
					sysFunction.setName(sysFunction.getName1());
				} else if (locale.equals("zh_TW")) {
					sysFunction.setName(sysFunction.getName2());
				}
				List<SysFunction> list2 = sysFunctionMapper
						.childMenu(sysFunction.getId());
				 for (SysFunction sysFunction2 : list2) {
					 if (locale.equals("zh_CN")) {
						 sysFunction2.setName(sysFunction2.getName());
						} else if (locale.equals("en_US")) {
							sysFunction2.setName(sysFunction2.getName1());
						}else if (locale.equals("zh_TW")) {
							sysFunction2.setName(sysFunction2.getName2());
						}
					 
				}
				 sysFunction.setChild(list2);
				
			}
			sysMenu.setChild(list1);
		}
		return list;
	}

	/**
	 * 
	 * 创建作者: 王曰岐 创建日期: 2017-4-19 下午3:44:08 方法介绍: 获取子类菜单 参数说明: @param menuId
	 * 参数说明: @return
	 * 
	 * @return List<SysFunction>
	 */
	@Override
	public List<SysFunction> getDadMenu(String menuId) {
		List<SysFunction> list = sysFunctionMapper.getDatagrid(menuId);
		for (SysFunction sysFunction : list) {
			List<SysFunction> list1 = sysFunctionMapper.childMenu(sysFunction
					.getId());
			sysFunction.setChild(list1);
		}
		return list;
	}

    /**
     * @param sysMenu
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 12:50
     * @函数介绍: 修改一级菜单
     * @参数说明: @param SysMenu
     * @return: void
     */
    @Override
    public void updateSysMenu(SysMenu sysMenu) {
        sysMenuMapper.updateSysMenu(sysMenu);
    }

    /**
     * @param sysMenu
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/26 13:03
     * @函数介绍: 添加一级菜单
     * @参数说明: @param paramname paramintroduce
     * @return: void
     */
    @Override
    public void addSysMenu(SysMenu sysMenu) {
        sysMenuMapper.addSysMenu(sysMenu);
    }

}
