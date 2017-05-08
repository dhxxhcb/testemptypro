package com.xoa.service.workflow;

import com.xoa.dao.workflow.FlowSortMapper;
import com.xoa.dao.workflow.FormSortMapper;
import com.xoa.model.workflow.FlowSort;
import com.xoa.model.workflow.FormSort;
import com.xoa.model.workflow.FormSortExample;
import com.xoa.service.workflow.wrapper.JobSelectorModel;
import com.xoa.service.workflow.wrapper.JobSelectorWrapper;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
         wrapper.setFlag(true);
         wrapper.setStatus(true);
         wrapper.setMsg("获取数据成功");
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
         wrapper.setFlag(true);
         wrapper.setStatus(true);
         wrapper.setMsg("获取数据成功");
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


    @Transactional(rollbackFor = JobClassifyException.class)
    public BaseWrapper insertForm(Integer parentId,Integer sortNo,String formName,Integer departmentId){
        BaseWrapper wrapper =   new BaseWrapper();
      String res=  StringUtils.checkNullUtils(new CheckCallBack() {
            @Override
            public boolean isNull(Object obj) {
                if (obj instanceof String) {
                    String a = (String) obj;
                    if (a == null || "".equals(a)
                            || a.length() == 0)
                        return true;
                }
                if (obj instanceof Integer) {
                    Integer a = (Integer) obj;
                    if (a == null)
                        return true;
                }
                return false;
            }
        },sortNo,"表单分类序号不能为空",formName,"表单分类名称不能为空");
      if(res!=null){
          wrapper.setFlag(false);
          wrapper.setStatus(true);
          wrapper.setMsg(res);
          return wrapper;
      }
      try{
          FormSort sortParent =new FormSort();
          sortParent.setSortId(parentId);
          sortParent.setHaveChild("1");
          sortMapper.updateByPrimaryKeySelective(sortParent);
          FormSort sort =new FormSort();
          sort.setSortNo(sortNo);
          sort.setSortName(formName);
          sort.setSortParent(parentId);
          sort.setDeptId(departmentId);
          sort.setHaveChild("0");
          Integer insertRes = sortMapper.insertSelective(sort);
          if(insertRes<0) throw new JobClassifyException("数据插入异常，进入回滚");
          wrapper.setStatus(true);
          wrapper.setFlag(true);
          wrapper.setMsg("操作执行成功");

      }catch (Exception e){
          e.printStackTrace();
          L.w("数据回滚");
          throw new JobClassifyException("数据插入异常，执行回滚");
      }
        return  wrapper;

    }



}
