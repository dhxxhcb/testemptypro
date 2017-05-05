package com.xoa.service.workflow;

import com.xoa.dao.workflow.FlowSortMapper;
import com.xoa.dao.workflow.FormSortMapper;
import com.xoa.model.workflow.FlowSort;
import com.xoa.model.workflow.FormSort;
import com.xoa.model.workflow.FormSortExample;
import com.xoa.service.workflow.wrapper.JobSelectorModel;
import com.xoa.service.workflow.wrapper.JobSelectorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-5-5 下午5:56:37 
 * @类介绍  工作流分类 服务类
 * @构造参数 无
 *
 */
@Service
public class JobClassifyService {
    @Autowired
    FormSortMapper sortMapper;

    @Autowired
    FlowSortMapper flowSortMapper;

     /**
      * 
      * @作者 韩东堂
      * @创建日期 2017-5-5 下午5:56:33 
      * @方法介绍  获取表单分类
      * @参数说明 @return
      * @return
      */
	 public JobSelectorWrapper getJobSelector(){
         JobSelectorWrapper wrapper =new JobSelectorWrapper();
         List<FormSort> nosortDatas= sortMapper.selectAllFormSort();
         Integer noform=sortMapper.selectNoformSort();
         List<FormSort>  resultdatas =new ArrayList<FormSort>();
         FormSort formSort =new FormSort();
         formSort.setSortName("未定义");
         formSort.setFormcounts(noform);
         formSort.setHaveChild("0");
         formSort.setSortNo(0);
         resultdatas.add(formSort);
         List<FormSort>  datasMap =   sortDatas(nosortDatas,0);
         resultdatas.addAll(datasMap);
         wrapper.setDatas(resultdatas);
         return  wrapper;
     }
     /**
      * 
      * @作者 韩东堂
      * @创建日期 2017-5-5 下午5:57:20 
      * @方法介绍 获取流程分类
      * @参数说明 @return
      * @return
      */
     public JobSelectorWrapper getFlowsort(){
         JobSelectorWrapper wrapper =new JobSelectorWrapper();
         List<FlowSort> nosortDatas= flowSortMapper.selectAllFlowSort();
         Integer noform=flowSortMapper.selectNoflowSort();
         List<FlowSort>  resultdatas =new ArrayList<FlowSort>();
         FlowSort flowSort =new FlowSort();
         flowSort.setSortName("未定义");
         flowSort.setFlowcounts(noform);
         flowSort.setHaveChild("0");
         flowSort.setSortNo(0);
         resultdatas.add(flowSort);
         List<FlowSort>  datasMap =   sortDatasFlow(nosortDatas,0);
         resultdatas.addAll(datasMap);
         wrapper.setDatas(resultdatas);
         return  wrapper;
     }

   /**
    * 
    * @作者 韩东堂
    * @创建日期 2017-5-5 下午5:57:42 
    * @方法介绍 对流程分类进行组装
    * @参数说明 @param nosortDatas
    * @参数说明 @param sortIda
    * @参数说明 @return
    * @return
    */
    private List<FlowSort> sortDatasFlow(List<FlowSort> nosortDatas,Integer sortIda) {
        if(nosortDatas==null) return null;
        List<FlowSort> datas = new ArrayList<FlowSort>();
        for(FlowSort sort:nosortDatas ){
            if(sort!=null) {
                if (sort.getSortParent() == sortIda) {
                    sort.setChilds(sortDatasFlow(nosortDatas, sort.getSortId()));
                    datas.add(sort);
                }
            }
        }
        return datas;
    }

   /**
    * 
    * @作者 韩东堂
    * @创建日期 2017-5-5 下午5:58:06 
    * @方法介绍 对表单分类进行组装
    * @参数说明 @param nosortDatas
    * @参数说明 @param sortIda
    * @参数说明 @return
    * @return
    */

    private List<FormSort> sortDatas(List<FormSort> nosortDatas,Integer sortIda) {
        if(nosortDatas==null) return null;
        List<FormSort> datas = new ArrayList<FormSort>();
        for(FormSort sort:nosortDatas ){
             if(sort!=null) {
                 if (sort.getSortParent() == sortIda) {
                     sort.setChilds(sortDatas(nosortDatas, sort.getSortId()));
                     datas.add(sort);
                 }
             }
        }
        return datas;
    }



}
