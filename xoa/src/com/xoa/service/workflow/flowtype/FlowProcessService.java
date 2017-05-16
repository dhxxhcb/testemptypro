package com.xoa.service.workflow.flowtype;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.util.dataSource.DynDatasource;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月9日 下午4:24:07
 * 类介绍  :    流程设计
 * 构造参数:   无
 *
 */
public interface FlowProcessService {
	@DynDatasource
	public FlowProcess find(int id);
	@DynDatasource
	public void updateByPrimaryKeySelective(FlowProcess record);
	@DynDatasource
	public List<FlowProcess> findFlowId(int flowId);
	@DynDatasource
	public void delete(int id);
	
	@DynDatasource
	public JSONObject flowView(int flowId);
	
	
}
