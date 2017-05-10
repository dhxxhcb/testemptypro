package com.xoa.service.workflow.flowtype.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowProcessMapper;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.service.workflow.flowtype.FlowProcessService;

@Service
public class FlowProcessServiceImpl implements FlowProcessService {

	@Resource
	private FlowProcessMapper flowProcessMapper;
 	
	@Override
	public FlowProcess find(int flowId, int id) {
		Map<String, Object> maps =new HashMap<String, Object>();
		maps.put("flowId", flowId);
		maps.put("id", id);
		FlowProcess flowProcess=flowProcessMapper.find(maps);
		return flowProcess;
	}

	@Override
	public void updateByPrimaryKeySelective(FlowProcess record) {
		flowProcessMapper.updateByPrimaryKeySelective(record);	
	}

}
