package com.xoa.service.menu;

import java.util.List;

import com.xoa.model.menu.MobileAppModel;
import com.xoa.util.dataSource.DynDatasource;
/**
 * 
 * @ClassName (类名):  MobileAppService
 * @Description(简述): 移动端
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午5:59:35
 *
 */
public interface MobileAppService {
	
	/**
	 * 
	 * @Title: getMobileAppList
	 * @Description: 获取移动端所需菜单
	 * @author(作者):      wyq
	 * @param: @return   
	 * @return: List<MobileApp>   
	 * @throws
	 */
	@DynDatasource
	public List<MobileAppModel> getMobileAppList();

}
