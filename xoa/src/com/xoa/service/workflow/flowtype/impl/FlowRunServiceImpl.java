package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowRunMapper;
import com.xoa.model.workflow.FlowRun;
import com.xoa.service.workflow.flowtype.FlowRunService;
@Service
public class FlowRunServiceImpl implements FlowRunService{
	@Resource
	private FlowRunMapper flowRunMapper;
	
	@Override
	public int getMaxRunId() {
		int runid=flowRunMapper.getMaxRunId()+1;
		return runid;
	}

	@Override
	public void save(FlowRun flowRun) {
		flowRunMapper.insert(flowRun);
	}

}
