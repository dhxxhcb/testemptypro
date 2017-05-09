package com.xoa.service.workflow.flowtype;

import com.xoa.model.workflow.FlowFormType;
import com.xoa.util.ToJson;

/**
 * Created by gsb on 2017/5/8.
 */
public interface FlowFormTypeService {

    public ToJson<FlowFormType> selectFlowFormType();
}
