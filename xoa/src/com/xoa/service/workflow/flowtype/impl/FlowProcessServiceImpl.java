package com.xoa.service.workflow.flowtype.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
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
	
	public JSONObject flowView(int flowId) {
		JSONObject all=new JSONObject();
		JSONObject fp=new JSONObject();
		JSONObject connections=new JSONObject();
		
		List l=new ArrayList();
		  
		List<FlowProcess> list=flowProcessMapper.findFlowId(flowId);
		for (FlowProcess flowProcess : list){
			int prcsId=flowProcess.getPrcsId();
			String prceTo=flowProcess.getPrcsTo();
			String [] p=prceTo.split(",");
			for(String a:p){
				l.add(prcsId+"=>"+a);
			}
			connections.put("connections",l.toString());
		}
		
	
		int lastPrcsId=0;
		int lastId=0;
		for (FlowProcess flowProcess : list) {
			int prcsId=flowProcess.getPrcsId();
			if(prcsId>lastPrcsId){
				lastId=prcsId;
				lastPrcsId=prcsId;
			}
			JSONObject js=new JSONObject();
			int prcaId=flowProcess.getPrcsId();
			String prcsName=flowProcess.getPrcsName();
			String prcsIn=flowProcess.getPrcsIn();
			String prcsOut=flowProcess.getPrcsOut();
			Byte prcsType=flowProcess.getPrcsType();
			int chidFlow=flowProcess.getChildFlow();
			String syncDeal=flowProcess.getSyncDeal();
			int setLeft=flowProcess.getSetLeft();
			int top=flowProcess.getSetTop();
			js.put("prca_Id", prcaId);
			js.put("prcsName", prcsName);
			js.put("prcsIn", prcsIn);
			js.put("prcsout", prcsOut);
			js.put("prcsType", prcsType);
			js.put("childFlow", chidFlow);
			js.put("syncDeal", syncDeal);
			js.put("setLeft", setLeft);
			js.put("top", top);
			int i=0;
			fp.put(""+i++, js.toJSONString());
			
		}
		all.put("connections", connections);
		all.put("fp", fp);
	
		return all;
	}

}
