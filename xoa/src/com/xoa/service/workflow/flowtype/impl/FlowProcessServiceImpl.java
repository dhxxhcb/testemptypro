package com.xoa.service.workflow.flowtype.impl;

import java.util.HashMap;
import java.util.List;
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
	public FlowProcess find( int id) {
		Map<String, Object> maps =new HashMap<String, Object>();
		maps.put("id", id);
		FlowProcess flowProcess=flowProcessMapper.find(maps);
		return flowProcess;
	}

	@Override
	public void updateByPrimaryKeySelective(FlowProcess record) {
		flowProcessMapper.updateByPrimaryKeySelective(record);	
	}

	@Override
	public List<FlowProcess> findFlowId(int flowId) {
		List<FlowProcess> list=flowProcessMapper.findFlowId(flowId);
		return list;
	}

	@Override
	public void delete(int id) {
		flowProcessMapper.deleteByPrimaryKey(id);
	}
	
	public List<FlowProcess> flowView(int flowId) {
		List<FlowProcess> list=flowProcessMapper.findFlowId(flowId);
		int lastPrcsId=0;
		int lastId=0;
		for (FlowProcess flowProcess : list) {
			int prcsId=flowProcess.getPrcsId();
			if(prcsId>lastPrcsId){
				lastId=prcsId;
				lastPrcsId=prcsId;
			}
			String prcsName=flowProcess.getPrcsName();
			String prcsIn=flowProcess.getPrcsIn();
			String prcsOut=flowProcess.getPrcsOut();
			Byte prcsType=flowProcess.getPrcsType();
			int chidFlow=flowProcess.getChildFlow();
			String syncDeal=flowProcess.getSyncDeal();
			int setLeft=flowProcess.getSetLeft();
			int top=flowProcess.getSetTop();
			
			
			
		}
		
		return list;
	}

}
