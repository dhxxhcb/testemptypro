package com.xoa.service.workflow.flowtype.impl;

import javax.annotation.Resource;

import com.xoa.util.common.StringUtils;
import org.springframework.stereotype.Service;

import com.xoa.dao.workflow.FlowFormTypeMapper;
import com.xoa.model.workflow.FlowFormType;
import com.xoa.service.workflow.flowtype.FlowFormTypeService;
import com.xoa.util.ToJson;

/**
 * Created by gsb on 2017/5/9.
 */
@Service
public class FlowFormTypeServiceImpl implements FlowFormTypeService {
	 @Resource
	 private FlowFormTypeMapper  flowFormTypeMapper;

	@Override
	public ToJson<FlowFormType> qureyItemMax(Integer formId) {
		ToJson<FlowFormType>  toJson=new ToJson<FlowFormType>(0, "");
		if (formId!=null) {
		FlowFormType folw = flowFormTypeMapper.qureyItemMax(formId);
		if(folw!=null){
			toJson.setMsg("ok");
			toJson.setObject(folw);
           }
		/*if (folw!=null) {
		folw.setItemMax(folw.getItemMax()+1);
		int a= flowFormTypeMapper.updateItemMax(folw);
		if(a>0) {
		toJson.setMsg("ok");
		toJson.setObject(folw);
		}else{
			toJson.setMsg("err");
		}
		
		}*/
		
		}else {
			toJson.setMsg("err");
		}
		 
		
		 return toJson;
	}
	 
	


	


   
}
