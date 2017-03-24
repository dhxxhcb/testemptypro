package com.xoa.dao.unitmanagement;

import com.xoa.model.unitmanagement.UnitManageWithBLOBs;

public interface UnitManageMapper {
    int insert(UnitManageWithBLOBs record);

    int insertSelective(UnitManageWithBLOBs record);
}