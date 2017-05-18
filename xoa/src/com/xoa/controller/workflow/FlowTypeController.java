package com.xoa.controller.workflow;

import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/flowNew")
    public String newflow(HttpServletRequest request){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/workflow/flowtype/flownew";
    }

    @RequestMapping("/flowlistbysort")
    @ResponseBody
    public ToJson<FlowTypeModel> flowListBySort(Integer flowId,HttpServletRequest request){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return flowTypeService.quertBySortId(flowId);
    }

    @RequestMapping("/flowBySearch")
    @ResponseBody
    public ToJson<FlowTypeModel> flowBySearch(String searchValue,Integer flowId,HttpServletRequest request){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return flowTypeService.flowBySearch(searchValue,flowId);
    }


    @RequestMapping("/type/index")
    public String flowTypeIndex(HttpServletRequest request){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/workflow/flowtype/index";
    }
    @RequestMapping("/type/flowdesigner")
    public String flowdesigner(HttpServletRequest request, Model model, Integer formId){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        System.out.println("获取ID："+formId);
        model.addAttribute("formId",formId);
        return "app/workflow/flowtype/flowdesigner";
    }




}
