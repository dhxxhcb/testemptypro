package com.xoa.controller.workflow;

import com.xoa.model.workflow.FlowTiggerModel;
import com.xoa.service.workflow.flowtigger.FlowTiggerService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/6/7 14:35
 * 类介绍  :   触发器
 * 构造参数:
 */
@Controller
@RequestMapping("/tigger")
public class FlowTiggerControlle {

    @Resource
    private FlowTiggerService flowTiggerService;

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/7 14:45
     * 方法介绍:   新建触发器
     * 参数说明:    触发器实体类
     * @return
     */
    @RequestMapping(value = "saveTigger",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public @ResponseBody ToJson<FlowTiggerModel> saveTigger(
            FlowTiggerModel flowTiggerModel,
            HttpServletRequest request){
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return flowTiggerService.saveTigger(flowTiggerModel);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/7 14:50
     * 方法介绍:   修改触发器
     * 参数说明:    触发器实体类
     * @return
     */
    @RequestMapping(value = "updateTigger" ,produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public ToJson<FlowTiggerModel> updateTigger(FlowTiggerModel flowTiggerModel,
                HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return flowTiggerService.updateTigger(flowTiggerModel);
    }








}
