package com.xoa.dao.workflow;

import com.xoa.model.workflow.FlowQueryTpl;
import com.xoa.model.workflow.FlowQueryTplExample;
import com.xoa.model.workflow.FlowQueryTplWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FlowQueryTplMapper {
    int countByExample(FlowQueryTplExample example);

	int deleteByExample(FlowQueryTplExample example);

	int deleteByPrimaryKey(Integer seqId);

	int insert(FlowQueryTplWithBLOBs record);

	int insertSelective(FlowQueryTplWithBLOBs record);

	List<FlowQueryTplWithBLOBs> selectByExampleWithBLOBs(
			FlowQueryTplExample example);

	List<FlowQueryTpl> selectByExample(FlowQueryTplExample example);

	List<FlowQueryTpl> queryByFlowId(Integer flowId);

	FlowQueryTplWithBLOBs selectByPrimaryKey(Integer seqId);

	int updateByExampleSelective(@Param("record") FlowQueryTplWithBLOBs record,
			@Param("example") FlowQueryTplExample example);

	int updateByExampleWithBLOBs(@Param("record") FlowQueryTplWithBLOBs record,
			@Param("example") FlowQueryTplExample example);

	int updateByExample(@Param("record") FlowQueryTpl record,
			@Param("example") FlowQueryTplExample example);

	int updateByPrimaryKeySelective(FlowQueryTplWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(FlowQueryTplWithBLOBs record);

	int updateByPrimaryKey(FlowQueryTpl record);

}