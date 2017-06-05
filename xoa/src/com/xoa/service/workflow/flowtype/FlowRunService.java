package com.xoa.service.workflow.flowtype;

import com.xoa.model.workflow.FlowRun;

import java.util.Map;

public interface FlowRunService {
	
	public int getMaxRunId();
	
	public void save(FlowRun flowRun);

	public FlowRun find(Integer runId);

	public int update(FlowRun flowRun);

	public int updateTime(Map<String,Object> map);

}
