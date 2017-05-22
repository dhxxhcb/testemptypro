package com.xoa.controller.workflow;

import com.xoa.service.workflow.flowsetting.FlowPrivService;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.common.wrapper.BaseWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 韩东堂 on 2017/5/20.
 */
@RestController
@RequestMapping("/flowSetDatas")
public class FlowSettingController {
    @Autowired
    FlowPrivService privService;

    /**
     * Created by:   pfl
     * date:   2017/5/20 15:47
     * description:   获取所选流程的权限设置（根据流程id）
     * @param flowId  流程Id
     * @return
     */
    @RequestMapping("/getFlowPrivList")
    public BaseWrappers getFlowPrivDatas(Integer flowId){
        return privService.queryFlowPriv(flowId);
    }





    @RequestMapping("/newFlowPriv")
    public BaseWrapper newFlowPrivData(Integer privType, @RequestParam("scope[]") Integer scope[],
                                       @RequestParam("user[]") Integer user[], @RequestParam("role[]")Integer role[],
                                       @RequestParam("dept[]")Integer dept[],Integer flowId){
        return privService.newFlowPriv(privType,scope,user,role,dept,flowId);
    }


}
