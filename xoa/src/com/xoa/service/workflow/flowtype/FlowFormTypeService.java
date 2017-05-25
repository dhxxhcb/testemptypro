package com.xoa.service.workflow.flowtype;

import com.xoa.model.workflow.FlowFormType;
import com.xoa.model.workflow.TMacroCtrl;
import com.xoa.util.ToJson;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gsb on 2017/5/8.
 */
public interface FlowFormTypeService {

     public ToJson<FlowFormType> qureyItemMax(Integer formId);

     public  ToJson<TMacroCtrl>  qureyCtrl(String controlId,String option,HttpServletRequest request);

}
