package com.xoa.dao.workflow;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.workflow.FlowFormType;

import java.util.List;
import java.util.Map;


public interface FlowFormTypeMapper extends BaseMapper<FlowFormType> {

	List<FlowFormType> selectFlowFormType(Map<String, Object> maps);
	
        
   
}