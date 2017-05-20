package com.xoa.controller.workflow;

import com.xoa.service.workflow.flowsetting.FlowPrivService;
import com.xoa.util.common.wrapper.BaseWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 韩东堂 on 2017/5/20.
 */
@RestController
@RequestMapping("/flowSetDatas")
public class FlowSettingController {
    @Autowired
    FlowPrivService privService;



    @RequestMapping("/getFlowPrivList")
    public BaseWrappers getFlowPrivDatas(Integer flowId){
        return privService.queryFlowPriv(flowId);
    }

}
