package com.xoa.dao.workflow;

import java.util.List;
import java.util.Map;

import com.xoa.model.workflow.FlowProcess;
public interface FlowProcessMapper {
    int deleteByPrimaryKey(Integer id);

    void insert(FlowProcess record);

    int insertSelective(FlowProcess record);

    FlowProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowProcess record);

    int updateByPrimaryKeyWithBLOBs(FlowProcess record);

    int updateByPrimaryKey(FlowProcess record);
    
    FlowProcess find(Map<String, Object> maps);
    
    List<FlowProcess> findFlowId(int flowId);
    
    List<FlowProcess> findF(int flowId);
    
    FlowProcess findbyprcsId(Map<String, Object> maps);

    /**
     * 修改流程节点坐标
     * @param flowProcess
     */
    public  void updateTopAndLeft(FlowProcess flowProcess);

}