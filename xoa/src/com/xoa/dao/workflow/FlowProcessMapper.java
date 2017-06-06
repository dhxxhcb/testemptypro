package com.xoa.dao.workflow;

import java.util.List;
import java.util.Map;

import com.xoa.model.workflow.FlowProcess;
import org.jboss.logging.Param;

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

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/6 19:42
     * 方法介绍:   我的工作中查询流程
     * 参数说明:  
     * @return
     */
    public FlowProcess findProcess(@org.apache.ibatis.annotations.Param("flowId") Integer flowId, @org.apache.ibatis.annotations.Param("prcsId") Integer prcsId);

}