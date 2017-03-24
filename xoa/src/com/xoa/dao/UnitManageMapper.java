package com.xoa.dao;

import com.xoa.model.UnitManageWithBLOBs;

public interface UnitManageMapper {
    int insert(UnitManageWithBLOBs record);

    int insertSelective(UnitManageWithBLOBs record);
}