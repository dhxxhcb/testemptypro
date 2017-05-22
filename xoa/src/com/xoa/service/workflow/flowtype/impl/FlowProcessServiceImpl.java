package com.xoa.service.workflow.flowtype.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xoa.dao.workflow.FlowProcessMapper;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.model.workflow.FlowProcessList;
import com.xoa.service.workflow.flowtype.FlowProcessService;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;

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
	@Transactional
	public ToJson<FlowProcess> updateByPrimaryKeySelective(FlowProcess record) {
		ToJson<FlowProcess> tojson= new ToJson<FlowProcess>();
		try{
			flowProcessMapper.updateByPrimaryKeySelective(record);
			tojson.setFlag(0);
			tojson.setMsg("OK");
		}catch(Exception e){
			e.printStackTrace();
			tojson.setFlag(1);
			tojson.setMsg("error");
		}
		return tojson;	
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
	@Override
	public FlowProcessList flowView(int flowId) {
		//定义用于返回的流程信息
		FlowProcessList f=new FlowProcessList();
		Map<String, String> map=null;
		//定义
		List<Map<String, String>> lm=new ArrayList<Map<String,String>>();
		//根据flowId获取流程信息
		List<FlowProcess> list=flowProcessMapper.findF(flowId);
		//f.setFlowName(list.get(0).getFlowName());
		for (int i=0;i<list.size();i++){
			Integer prId=list.get(i).getPrcsId();
			String prceTo=list.get(i).getPrcsTo();
			if(StringUtils.checkNull(prceTo)){
				map=new HashMap<String, String>();
				map.put("from", Integer.toString(prId));
				if(i<list.size()-1){
					if(list.get(i+1).getPrcsId()==prId+1){
				map.put("to", Integer.toString(list.get(i+1).getPrcsId()));
					}
				}else{
					map.put("to", "end");
				}
				lm.add(map);
			}else{				
			String [] p=prceTo.split(",");			
			for(String a:p){
				map=new HashMap<String, String>();
				map.put("from", Integer.toString(prId));
				map.put("to",a.toString());
				lm.add(map);
			}
			}
		}
		f.setConnections(lm);
		f.setDesigndata(list);
		f.setMax(list.size());
		return f;
	}

	@Override
	@Transactional
	public void insertSelective(FlowProcess record) {
		flowProcessMapper.insertSelective(record);
	}

}
