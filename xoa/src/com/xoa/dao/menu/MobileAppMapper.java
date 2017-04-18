package com.xoa.dao.menu;

import java.util.List;

import com.xoa.model.menu.MobileAppModel;

public interface MobileAppMapper {
	
    /**
     * 
     * @Title: getMobileAppList
     * @Description: 获得全部移动端菜单
     * @author(作者):      wyq
     * @param: @return   
     * @return: List<MobileApp>   
     * @throws
     */
	
	public List<MobileAppModel> getMobileAppList();
}