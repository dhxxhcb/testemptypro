package com.xoa.service.workflow.flowtype;

import java.util.List;

import com.xoa.model.workflow.FlowProcess;
import com.xoa.util.ToJson;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月9日 下午4:24:07
 * 类介绍  :    流程设计
 * 构造参数:   无
 *
 */
public interface FlowProcessService {
	public FlowProcess find(int id);
	public ToJson<FlowProcess> updateByPrimaryKeySelective(FlowProcess record);
	public List<FlowProcess> findFlowId(int flowId);
	public void delete(int id);
	public FlowProcess flowView(int flowId);
	public int insertSelective(FlowProcess record);
	
	
}
