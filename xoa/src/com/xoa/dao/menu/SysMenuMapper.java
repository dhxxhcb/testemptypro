package com.xoa.dao.menu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xoa.model.menu.SysMenu;
/**
 * 
 * @ClassName (类名):  SysMenuMapper
 * @Description(简述): 父类菜单
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午5:55:45
 *
 */
public interface SysMenuMapper {
	
    /**
     * 
     * @Title: getDatagrid
     * @Description: 获取全部一级菜单
     * @author(作者):      wyq
     * @param: @return   
     * @return: List<SysMenu>   
     * @throws
     */
	public List<SysMenu> getDatagrid();
	
	
}