package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import com.xoa.util.ToJson;
import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowRunPrcsMapper;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;

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
	public ToJson<FlowRunPrcs> selectObject(Map<String, Object> maps) {
		ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();



		return null;
	}

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/24 20:30
	 * 方法介绍:   查询办结工作
	 * 参数说明:
	 * @return
	 */
	@Override
	public ToJson<FlowRunPrcs> selectEnd(Map<String, Object> maps) {
		return null;
	}

}
