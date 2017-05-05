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


@Service
public class JobClassifyService {
    @Autowired
    FormSortMapper sortMapper;

    @Autowired
    FlowSortMapper flowSortMapper;


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
