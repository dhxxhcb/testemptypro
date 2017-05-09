package com.xoa.service.workflow.flowtype;

import com.xoa.model.workflow.FlowProcess;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月9日 下午4:24:07
 * 类介绍  :    流程设计
 * 构造参数:   无
 *
 */
public interface FlowProcessService {
	
	public FlowProcess find(int flowId,int id);
	
	
	
}
