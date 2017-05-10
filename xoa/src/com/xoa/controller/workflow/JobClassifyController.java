package com.xoa.controller.workflow;

import com.xoa.service.workflow.JobClassifyService;
import com.xoa.service.workflow.wrapper.JobSelectorWrapper;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-5-5 下午5:58:48 
 * @类介绍  流程分类数据接口类
 * @构造参数 无
 *
 */
@RestController
@RequestMapping("/workflow")
public class JobClassifyController {

    @Autowired
    JobClassifyService service;
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-5 下午5:59:08 
     * @方法介绍 表单分类接口
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/form")
    public JobSelectorWrapper getSeletorInfo(){
        return   service.getJobSelector();
    }
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-5 下午5:59:23 
     * @方法介绍 流程分类接口
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/flow")
    public JobSelectorWrapper getFlowInfo(){
        return   service.getFlowsort();
    }
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-8 下午5:32:18 
     * @方法介绍  表单分类添加
     * @参数说明 @param parentId 父分类Id
     * @参数说明 @param sortNo  序号
     * @参数说明 @param formName 分类名称
     * @参数说明 @param departmentId  部门Id
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/formSave")
    public BaseWrapper insertForm(@RequestParam(defaultValue = "0",required = false) Integer parentId, Integer sortNo, String formName, @RequestParam(defaultValue = "0",required = false)Integer departmentId){
        return  service.insertForm(parentId,sortNo,formName,departmentId);
    }
    
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-8 下午5:33:17 
     * @方法介绍 流程分类添加
     * @参数说明 @param parentId 父分类Id
     * @参数说明 @param sortNo 序号
     * @参数说明 @param flowName 分类名称
     * @参数说明 @param departmentId 部门Id
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/flowSave")
    public BaseWrapper insertFlow(@RequestParam(defaultValue = "0",required = false)Integer parentId,Integer sortNo,String flowName,@RequestParam(defaultValue = "0",required = false)Integer departmentId){
        return  service.insertFlow(parentId,sortNo,flowName,departmentId);
    }
    
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:20:16 
     * @方法介绍 表单分类修改
     * @参数说明 @param formId 需要修改的id
     * @参数说明 @param parentId 父Id
     * @参数说明 @param sortNo  序号
     * @参数说明 @param formName 表单名字
     * @参数说明 @param departmentId 部门id
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/formUpdate")
    public BaseWrapper updateForm(Integer formId,Integer parentId,Integer sortNo,String formName,Integer departmentId){
        return  service.formUpdate(formId,parentId,sortNo,formName,departmentId);
    }
    
    
    
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:21:14 
     * @方法介绍 流程分类编辑
     * @参数说明 @param flowId 流程Id
     * @参数说明 @param parentId 父Id
     * @参数说明 @param sortNo 序号
     * @参数说明 @param flowName 流程分类名字
     * @参数说明 @param departmentId 部门Id
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/flowUpdate")
    public BaseWrapper updateFlow(Integer flowId,Integer parentId,Integer sortNo,String flowName,Integer departmentId){
        return  service.flowUpdate(flowId,parentId,sortNo,flowName,departmentId);
    }

    
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:22:11 
     * @方法介绍 删除流程分类
     * @参数说明 @param flowId 流程Id
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/flowDelete")
    public BaseWrapper deleteFlow(Integer flowId){
        return  service.deleteFlow(flowId);
    }
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:22:37 
     * @方法介绍 删除表单分类
     * @参数说明 @param formId 表单Id
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/flowclassify/formDelete")
    public BaseWrapper deleteForm(Integer formId){
        return   service.deleteForm(formId);
    }


}
