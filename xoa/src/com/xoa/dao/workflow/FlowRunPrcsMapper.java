package com.xoa.dao.workflow;

import com.xoa.model.workflow.FlowRunPrcs;

public interface FlowRunPrcsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlowRunPrcs record);

    int insertSelective(FlowRunPrcs record);

    FlowRunPrcs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowRunPrcs record);

    int updateByPrimaryKey(FlowRunPrcs record);
}