package com.xoa.service.menu;

import java.util.List;

import com.xoa.model.menu.MobileApp;
import com.xoa.util.dataSource.DynDatasource;

    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午6:22:38
     * 类介绍  :    APP端菜单Service
     * 构造参数:   
     *
     */
public interface MobileAppService {
	
	 /**
	  * 
	  * 创建作者:   王曰岐
	  * 创建日期:   2017-4-18 下午6:23:33
	  * 方法介绍:   获得APP端菜单
	  * 参数说明:   @return
	  * @return     List<MobileApp> 返回APP菜单集合
	  */
	@DynDatasource
	public List<MobileApp> getMobileAppList();

}