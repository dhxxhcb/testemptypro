package com.xoa.dao.workflow;

import com.xoa.model.workflow.FlowTimer;
import com.xoa.model.workflow.FlowTimerExample;
import com.xoa.model.workflow.FlowTimerWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowTimerMapper {
    int countByExample(FlowTimerExample example);

	int deleteByExample(FlowTimerExample example);

	int deleteByPrimaryKey(Integer tid);

	int insert(FlowTimerWithBLOBs record);

	int insertSelective(FlowTimerWithBLOBs record);

	List<FlowTimerWithBLOBs> selectByExampleWithBLOBs(FlowTimerExample example);

	List<FlowTimer> selectByExample(FlowTimerExample example);

	FlowTimerWithBLOBs selectByPrimaryKey(Integer tid);

	int updateByExampleSelective(@Param("record") FlowTimerWithBLOBs record,
			@Param("example") FlowTimerExample example);

	int updateByExampleWithBLOBs(@Param("record") FlowTimerWithBLOBs record,
			@Param("example") FlowTimerExample example);

	int updateByExample(@Param("record") FlowTimer record,
			@Param("example") FlowTimerExample example);

	int updateByPrimaryKeySelective(FlowTimerWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(FlowTimerWithBLOBs record);

	int updateByPrimaryKey(FlowTimer record);

	List<FlowTimerWithBLOBs> queryByFlowId(Integer flowId);


    int deleteBatchKey(Integer[] timerId);
}