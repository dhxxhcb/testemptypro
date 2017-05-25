package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;
import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowRunPrcsMapper;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;

import java.util.List;
import java.util.Map;

@Service
public class FlowRunPrcsServiceImpl implements FlowRunPrcsService {
	
	@Resource
	private FlowRunPrcsMapper flowRunPrcsMapper;

	@Override
	public void save(FlowRunPrcs flowRunPrcs) {
		flowRunPrcsMapper.insert(flowRunPrcs);
	}

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/24 20:29
	 * 方法介绍:   查询代办工作
	 * 参数说明:
	 * @return
	 */
	@Override
	public ToJson<FlowRunPrcs> selectObject(Map<String, Object> maps,Integer page,
											Integer pageSize, boolean useFlag) {
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		List<FlowRunPrcs> list = flowRunPrcsMapper.selectObjcet(maps);
		int len = list.size();
		if(len>0){
			toJson.setFlag(0);
			toJson.setMsg("ok");
			toJson.setObj(list);
		}else{
			toJson.setFlag(1);
			toJson.setMsg("error");
		}
		return toJson;
	}

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/24 20:30
	 * 方法介绍:   查询办结工作
	 * 参数说明:
	 * @return
	 */
	@SuppressWarnings("all")
	@Override
	public ToJson<FlowRunPrcs> selectEnd(Map<String, Object> maps,Integer page,
										 Integer pageSize, boolean useFlag) {
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		List<FlowRunPrcs> list = flowRunPrcsMapper.selectEnd(maps);
		int len = list.size();
		if(len>0){
			toJson.setFlag(0);
			toJson.setMsg("ok");
			toJson.setObj(list);
		}else{
			toJson.setFlag(1);
			toJson.setMsg("error");
		}
		return toJson;
	}

}