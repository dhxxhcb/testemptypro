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

    @RequestMapping("/flowclassify/formSave")
    public BaseWrapper insertForm(@RequestParam(defaultValue = "0",required = false) Integer parentId, Integer sortNo, String formName, @RequestParam(defaultValue = "0",required = false)Integer departmentId){
        return  service.insertForm(parentId,sortNo,formName,departmentId);
    }

    @RequestMapping("/flowclassify/flowSave")
    public BaseWrapper insertFlow(@RequestParam(defaultValue = "0",required = false)Integer parentId,Integer sortNo,String flowName,@RequestParam(defaultValue = "0",required = false)Integer departmentId){
        return  null;
    }

    @RequestMapping("/flowclassify/FormUpdate")
    public BaseWrapper updateForm(@RequestParam(defaultValue = "0",required = false)Integer parentId,Integer sortNo,String formName,@RequestParam(defaultValue = "0",required = false)Integer departmentId){
        return  null;
    }
    @RequestMapping("/flowclassify/flowUpdate")
    public BaseWrapper updateFlow(@RequestParam(defaultValue = "0",required = false)Integer parentId,Integer sortNo,String formName,@RequestParam(defaultValue = "0",required = false)Integer departmentId){
        return  null;
    }



}
