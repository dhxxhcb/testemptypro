package com.xoa.dao.workflow;

import com.xoa.model.workflow.FlowPriv;
import com.xoa.model.workflow.FlowPrivExample;
import com.xoa.model.workflow.FlowPrivWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowPrivMapper {
    int countByExample(FlowPrivExample example);

	int deleteByExample(FlowPrivExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(FlowPrivWithBLOBs record);

	int insertSelective(FlowPrivWithBLOBs record);

	List<FlowPrivWithBLOBs> selectByExampleWithBLOBs(FlowPrivExample example);

	List<FlowPriv> selectByExample(FlowPrivExample example);

	FlowPrivWithBLOBs selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") FlowPrivWithBLOBs record,
			@Param("example") FlowPrivExample example);

	int updateByExampleWithBLOBs(@Param("record") FlowPrivWithBLOBs record,
			@Param("example") FlowPrivExample example);

	int updateByExample(@Param("record") FlowPriv record,
			@Param("example") FlowPrivExample example);

	int updateByPrimaryKeySelective(FlowPrivWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(FlowPrivWithBLOBs record);

	int updateByPrimaryKey(FlowPriv record);

	List<FlowPrivWithBLOBs> queryByFlowId(Integer flowId);

	int deleteBatchKey(Integer privId[]);

}