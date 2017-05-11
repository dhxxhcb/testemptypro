package com.xoa.service.workflow.flowtype;

import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.util.ToJson;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/5/8 16:39
 * 类介绍  :   流程设置
 * 构造参数:
 */
public interface FlowTypeService {

        /**
         * 创建作者:   张勇
         * 创建日期:   2017/5/8 16:42
         * 方法介绍:   新建流程
         * 参数说明:   需传递对象参数
         * @return
         */
        public ToJson<FlowTypeModel> saveFlow(FlowTypeModel flowTypeModel);


        public ToJson<FlowTypeModel> quertBySortId(Integer flowId);
}
