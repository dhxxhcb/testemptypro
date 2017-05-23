package com.xoa.service.workflow.flowtype;

import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.util.ToJson;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

        /**
         * 创建作者:   张勇
         * 创建日期:   2017/5/23 17:30
         * 方法介绍:   自定义属性所有查询，根据flowId
         * 参数说明:
         * @return
         */
        public  ToJson<FlowTypeModel> selectAllFlow(Map<String, Object> maps);

        /**
         * 创建作者:   张勇
         * 创建日期:   2017/5/23 19:35
         * 方法介绍:   自定义属性根据flowId修改
         * 参数说明:
         * @return
         */
        public ToJson<FlowTypeModel> updateFlow(FlowTypeModel flowTypeModel);


        public ToJson<FlowTypeModel> quertBySortId(Integer flowId);

        ToJson<FlowTypeModel> flowBySearch(String searchValue, Integer flowId);
        ToJson<FlowTypeModel> selectFlowAuthOrSearch(HttpServletRequest request, String searchValue, Integer sortId);
}
