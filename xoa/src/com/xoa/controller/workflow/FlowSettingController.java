package com.xoa.controller.workflow;

import com.xoa.service.workflow.flowsetting.FlowSettingService;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.common.wrapper.BaseWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 韩东堂 on 2017/5/20.
 */
@RestController
@RequestMapping("/flowSetDatas")
public class FlowSettingController {
    @Autowired
    FlowSettingService privService;

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



    /**
     * Created by:   pfl
     * date:   2017/5/22 14:47
     * description:   新建权限管理（
     * @param privType 授权类型(1-管理,2-监控,3-查询,4-编辑,5-点评)
     * @param scope [SELF_ORG-本机构 对应 -3,ALL_DEPT-所有部门 对应 -2,SELF_DEPT-本部门 对应 -1,部门ID串 直接拼写数组 1，2，3]
     * @param user  授权用户id串 [1,2,3,4,5]
     * @param role  授权角色id串 [1,2,3,4,5]
     * @param dept  授权部门id串 [1,2,3,4,5]
     * @param flowId 所属流程
     * @return
     */
    @RequestMapping("/newFlowPriv")
    public BaseWrapper newFlowPrivData(Integer privType, @RequestParam("scope[]") Integer scope[],
                                       @RequestParam("user[]") Integer user[], @RequestParam("role[]")Integer role[],
                                       @RequestParam("dept[]")Integer dept[],Integer flowId){
        return privService.newFlowPriv(privType,scope,user,role,dept,flowId);
    }


    /**
     * Created by:   pfl
     * date:   2017/5/22 19:10
     * description:   编辑权限管理（
     * @param privType 授权类型(1-管理,2-监控,3-查询,4-编辑,5-点评)
     * @param scope [SELF_ORG-本机构 对应 -3,ALL_DEPT-所有部门 对应 -2,SELF_DEPT-本部门 对应 -1,部门ID串 直接拼写数组 1，2，3]
     * @param user  授权用户id串 [1,2,3,4,5]
     * @param role  授权角色id串 [1,2,3,4,5]
     * @param dept  授权部门id串 [1,2,3,4,5]
     * @param flowId 所属流程
     * @param privId 要编辑的权限
     * @return
     */
    @RequestMapping("/updateFlowPriv")
    public BaseWrapper updateFlowPriv(Integer privType,@RequestParam("scope[]")Integer scope[], @RequestParam("user[]")Integer user[],@RequestParam("role[]")Integer role[],@RequestParam("dept[]")Integer dept[],Integer flowId,Integer privId){
        return privService.updateFlowPriv(privType,scope,user,role,dept,flowId,privId);
    }


    /**
     * Created by:   pfl
     * date:   2017/5/22 17:28
     * description:   删除权限
     * @param privId  权限Id
     * @return
     */
    @RequestMapping("/deleteFlowPriv")
    public BaseWrapper deleteFlowPriv(Integer privId){
        return privService.deleteFlowPriv(privId);
    }



    /**
     * Created by:   pfl
     * date:   2017/5/22 17:44
     * description:   获取所选流程的定时任务（根据流程id）
     * @param flowId  流程Id
     * @return
     */
    @RequestMapping("/getFlowTimerList")
    public BaseWrappers getFlowTimerDatas(Integer flowId){
        return privService.queryFlowTimer(flowId);
    }


    @RequestMapping("/newFlowTimer")
    public BaseWrapper newFlowTimer(Integer flowId,Integer type,String date,@RequestParam("user[]")Integer user[],@RequestParam("dept[]")Integer dept[],@RequestParam("role[]")Integer role[]){
        return privService.newFlowTimer(flowId,type,date,user,dept,role);
    }

    @RequestMapping("/updateFlowTimer")
    public BaseWrapper updateFlowTimer(Integer timerId,Integer flowId,Integer type,String date,@RequestParam("user[]")Integer user[],@RequestParam("dept[]")Integer dept[],@RequestParam("role[]")Integer role[]){
        return privService.updateFlowTimer(timerId,flowId,type,date,user,dept,role);
    }


    @RequestMapping("/deleteFlowTimer")
    public BaseWrapper deleteFlowTimer(Integer timerId){
        return privService.deleteFlowTimer(timerId);
    }

    @RequestMapping("/getFlowQueryTplList")
    public BaseWrappers getFlowQueryTpl(Integer flowId){
        return  privService.getFlowQueryTpl(flowId);
    }


    /**
     * Created by:   pfl
     * date:   2017/5/24 19:27
     * description:   配置查询模板接口 添加（根据流程id）
     * @param request  从session 中获取 用户ID
     * @param tplName 模板名称
     * @param flowId 流程ID
     * @param viewFields 扩展显示字段
     * @param groupFields 分组字段
     * @param dataConditions 表单数据过滤条件
     * @param flowConditions 流程过滤条件
     * @param dataXml 查询模板内容
     * @param condFormula 查询条件公式
     * @return
     */
   @RequestMapping("/newFlowQuertTpl")
    public BaseWrapper newFlowQuertTpl(HttpServletRequest request,String tplName,Integer flowId,String viewFields,
       String groupFields,String dataConditions,String flowConditions,String dataXml,String condFormula
       ){
        return privService.newFlowQuertIpl(request,tplName,flowId,viewFields,groupFields,dataConditions,flowConditions,dataXml,condFormula);
   }


    /**
     * Created by:   pfl
     * date:   2017/5/24 19:27
     * description:   配置查询模板接口 更新
     * @param tplId 要修改的模板Id
     * @param request  从session 中获取 用户ID
     * @param tplName 模板名称
     * @param flowId 流程ID
     * @param viewFields 扩展显示字段
     * @param groupFields 分组字段
     * @param dataConditions 表单数据过滤条件
     * @param flowConditions 流程过滤条件
     * @param dataXml 查询模板内容
     * @param condFormula 查询条件公式
     * @return
     */
    @RequestMapping("/updateFlowQuertTpl")
    public BaseWrapper updateFlowQuertTpl(Integer tplId,HttpServletRequest request,String tplName,Integer flowId,String viewFields,
                                       String groupFields,String dataConditions,String flowConditions,String dataXml,String condFormula
    ){
        return privService.updateFlowQuertTpl(tplId,request,tplName,flowId,viewFields,groupFields,dataConditions,flowConditions,dataXml,condFormula);
    }

    @RequestMapping("/queryFlowQuertTplById")
    public BaseWrapper queryFlowQuertTplById(Integer tplId
    ){
        return privService.queryFlowQuertTplById(tplId);
    }
    @RequestMapping("/deleteFlowQuertTpl")
    public BaseWrapper deleteFlowQuertTpl(Integer tplId
    ){
        return privService.deleteFlowQuertTpl(tplId);
    }
}
