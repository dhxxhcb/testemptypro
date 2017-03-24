package com.xoa.dao;

import com.xoa.model.SysFunction;

public interface SysFunctionMapper {
    int deleteByPrimaryKey(Integer funcId);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    SysFunction selectByPrimaryKey(Integer funcId);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);
}