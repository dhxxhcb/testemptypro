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
import com.xoa.model.workflow.FlowProcessList;
import com.xoa.service.workflow.flowtype.FlowProcessService;
import com.xoa.util.ToJson;

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
	
	public FlowProcess flowView(int flowId) {
		FlowProcess f=new FlowProcess();
		List l=new ArrayList();
		List e=new ArrayList();
		List<FlowProcess> list=flowProcessMapper.findF(flowId);
		for (FlowProcess flowProcess : list){
			int prId=flowProcess.getPrcsId();
			String prceTo=flowProcess.getPrcsTo();
			String [] p=prceTo.split(",");
			
			for(String a:p){
				if(prceTo==""){
					e.add(prId);
				}
				l.add(prId+"=>"+a);
			}
		}
		f.setEnds(e);
		f.setConnections(l);
	
		List<FlowProcessList> l1=new ArrayList<FlowProcessList>();
		for (FlowProcess flowProcess : list) {			
			FlowProcessList fl=new FlowProcessList();
			int prId=flowProcess.getPrcsId();
			String prcsName=flowProcess.getPrcsName()==null?"":flowProcess.getPrcsName();
			String prcsIn=flowProcess.getPrcsIn()==null? "":flowProcess.getPrcsIn().trim();
			String prcsOut=flowProcess.getPrcsOut()==null?"":flowProcess.getPrcsOut();
			Byte prcsType=flowProcess.getPrcsType();
			//int chidFlow=flowProcess.getChildFlow();
			String syncDeal=flowProcess.getSyncDeal()==null?"":flowProcess.getSyncDeal();
			int setLeft=flowProcess.getSetLeft();
			int top=flowProcess.getSetTop();
			fl.setPrcsId(prId);
			fl.setPrcsName(prcsName);
			fl.setPrcsIn(prcsIn);
			fl.setPrcsOut(prcsOut);
			fl.setPrcsType(prcsType);
			fl.setSyncDeal(syncDeal);
			fl.setSetLeft(setLeft);
			fl.setSetTop(top);
			l1.add(fl);
		}
		f.setDesigndata(l1);
		return f;
	}

}
