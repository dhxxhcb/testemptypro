package com.xoa.dao.workflow;

import com.xoa.model.workflow.FlowSort;
import com.xoa.model.workflow.FlowSortExample;
import java.util.List;
import java.util.Map;

import com.xoa.model.workflow.FormSort;
import com.xoa.model.workflow.FormSortExample;
import org.apache.ibatis.annotations.Param;

public interface FlowSortMapper {
    int countByExample(FlowSortExample example);

    int deleteByExample(FlowSortExample example);

    int deleteByPrimaryKey(Integer sortId);

    int insert(FlowSort record);

    int insertSelective(FlowSort record);

    List<FlowSort> selectByExample(FlowSortExample example);

    List<FlowSort> selectAllFlowSort();

    int getChildNumber(Integer sortId);

    int  selectflowSortNum(Integer flowId);
    List<FlowSort> getChildDatas(Integer sortId);

    int selectNoflowSort();

    FlowSort selectByPrimaryKey(Integer sortId);

    int updateByExampleSelective(@Param("record") FlowSort record, @Param("example") FlowSortExample example);

    int updateByExample(@Param("record") FlowSort record, @Param("example") FlowSortExample example);

    int updateByPrimaryKeySelective(FlowSort record);

    int updateByPrimaryKey(FlowSort record);

    List<FlowSort> selectFlowSortByAuth(Map<String,Object> map);
}