package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import com.xoa.util.DateFormat;
import com.xoa.util.common.StringUtils;
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

	@Override
	public FlowRun find(Integer runId){
		FlowRun f=flowRunMapper.find(runId);
		if(!StringUtils.checkNull(f.getBeginTime())) {
			f.setBeginTime(DateFormat.getStrTime(DateFormat.getTime(f.getBeginTime())));
		}
		return f;
	}

	@Override
	public int update(FlowRun flowRun) {
		int a=flowRunMapper.updateByPrimaryKey(flowRun);
		return  a;
	}


}
