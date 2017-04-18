package com.xoa.dao.menu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xoa.model.menu.SysMenu;

public interface SysMenuMapper {
    
	public List<SysMenu> getDatagrid();
	
	
}