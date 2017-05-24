package com.xoa.dao.workflow;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.workflow.FlowRunPrcs;

import java.util.List;
import java.util.Map;

public interface FlowRunPrcsMapper extends BaseMapper<FlowRunPrcs>{

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:16
     * 方法介绍:   查询完结工作
     * 参数说明:
     * @return
     */
    public List<FlowRunPrcs>  selectEnd(Map<String,Object> maps);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowRunPrcs record);

    int insertSelective(FlowRunPrcs record);

    FlowRunPrcs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowRunPrcs record);

    int updateByPrimaryKey(FlowRunPrcs record);
}