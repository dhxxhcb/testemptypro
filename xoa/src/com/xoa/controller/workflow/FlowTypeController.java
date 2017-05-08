package com.xoa.controller.workflow;

import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/5/8 16:51
 * 类介绍  :
 * 构造参数:
 */
@Controller
@RequestMapping("/flow")
public class FlowTypeController {

    @Resource
    private FlowTypeService flowTypeService;

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/8 16:55
     * 方法介绍:   新建流程
     * 参数说明:   获取页面传递对象参数
     * @return
     */
    @RequestMapping(value = "newFlow",produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<FlowTypeModel> saveFlow(FlowTypeModel flowTypeModel, HttpServletRequest request){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return flowTypeService.saveFlow(flowTypeModel);
    }


    @RequestMapping("/flowNews")
    public String flow(HttpServletRequest request){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/workflow/flowtype/flowNews";
    }

}
