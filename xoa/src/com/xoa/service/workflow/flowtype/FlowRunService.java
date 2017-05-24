package com.xoa.service.workflow.flowtype;

import com.xoa.model.workflow.FlowRun;

public interface FlowRunService {
	
	public int getMaxRunId();
	
	public void save(FlowRun flowRun);

}
