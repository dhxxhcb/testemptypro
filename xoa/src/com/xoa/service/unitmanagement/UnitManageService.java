package com.xoa.service.unitmanagement;

import com.xoa.model.unitmanagement.UnitManage;
import com.xoa.util.dataSource.DynDatasource;

/**
 * 
 * @author zlx
 * @version 1.0
 *
 */
public interface UnitManageService {
	/**
     * 单位管理查询，并返回对象
     * 
     */
	@DynDatasource
   public  UnitManage  showUnitManage();
   /**
    * 单位管理保存
    * 
    */
	@DynDatasource
   public void addUnitManage(UnitManage unitManage);
}
