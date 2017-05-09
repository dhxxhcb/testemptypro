package com.xoa.dao.workflow;

import java.util.Map;

import com.xoa.model.workflow.FlowProcess;
public interface FlowProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlowProcess record);

    int insertSelective(FlowProcess record);

    FlowProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowProcess record);

    int updateByPrimaryKeyWithBLOBs(FlowProcess record);

    int updateByPrimaryKey(FlowProcess record);
    
    FlowProcess find(Map<String, Object> maps);
}