package com.xoa.dao.workflow;

import com.xoa.model.workflow.FlowRun;

public interface FlowRunMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(FlowRun record);

    int insertSelective(FlowRun record);

    FlowRun selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(FlowRun record);

    int updateByPrimaryKeyWithBLOBs(FlowRun record);

    int updateByPrimaryKey(FlowRun record);
    
    int getMaxRunId();
}