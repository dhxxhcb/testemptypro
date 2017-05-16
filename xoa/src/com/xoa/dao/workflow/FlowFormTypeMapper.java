package com.xoa.dao.workflow;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.workflow.FlowFormType;

import java.util.List;
import java.util.Map;

import com.xoa.model.workflow.FlowTypeModel;
import org.apache.ibatis.annotations.Param;


public interface FlowFormTypeMapper extends BaseMapper<FlowFormType> {

	 List<FlowFormType> selectFlowFormType(Map<String, Object> maps);

	 FlowFormType qureyItemMax(@Param("formId")Integer formId);
	 
	 int updateItemMax(FlowFormType flowFormType);


	 List<FlowFormType> selectFormBySort(@Param("sortId")Integer sortId);

	 List<FlowFormType> queryBySearchValue(@Param("searchValue")String searchValue,@Param("sortId")Integer sortId);

	 int insertSelectParam(FlowFormType flowFormType);

	 int updateSelectParam(FlowFormType flowFormType);

}