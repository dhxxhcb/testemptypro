package com.xoa.dao.unitmanagement;

import com.xoa.model.unitmanagement.UnitManage;

public interface UnitManageMapper {
    /**
     * 单位管理查询，并返回对象
     * 
     */
    UnitManage  showUnitManage();
    /**
     * 单位管理保存
     * 
     */
    void  addUnitManage(UnitManage unitManage);
   
}