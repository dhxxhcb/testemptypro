package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowRunPrcsMapper;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;
@Service
public class FlowRunPrcsServiceImpl implements FlowRunPrcsService {
	
	@Resource
	private FlowRunPrcsMapper flowRunPrcsMapper;

	@Override
	public void save(FlowRunPrcs flowRunPrcs) {
		flowRunPrcsMapper.insert(flowRunPrcs);
	}

}
