package com.xoa.service.workflow;

import com.xoa.dao.workflow.FlowSortMapper;
import com.xoa.dao.workflow.FormSortMapper;
import com.xoa.model.department.Department;
import com.xoa.model.workflow.FlowSort;
import com.xoa.model.workflow.FormSort;
import com.xoa.model.workflow.FormSortExample;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.workflow.wrapper.JobSelectorModel;
import com.xoa.service.workflow.wrapper.JobSelectorWrapper;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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



    private static final int CHECK_TYPE_FLOW=0x11;
    private static final int CHECK_TYPE_FORM=0x12;

    @Autowired
    private DepartmentService departmentService;

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
        wrapper.setFlag(false);
        wrapper.setStatus(true);
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
            wrapper.setMsg(res);
            return wrapper;
        }
        String  resc=  checkParentOrDepartment(parentId,departmentId,CHECK_TYPE_FORM);
        if(resc!=null){
            wrapper.setMsg(resc);
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



    @Transactional(rollbackFor = JobClassifyException.class)
    public BaseWrapper insertFlow(Integer parentId,Integer sortNo,String flowName,Integer departmentId){
        BaseWrapper wrapper =   new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
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
        },sortNo,"流程分类序号不能为空",flowName,"流程分类名称不能为空");
        if(res!=null){
            wrapper.setMsg(res);
            return wrapper;
        }
        String  resc=  checkParentOrDepartment(parentId,departmentId,CHECK_TYPE_FLOW);
        if(resc!=null){
            wrapper.setMsg(resc);
            return wrapper;
        }
        try{
            FlowSort flowParent =new FlowSort();
            flowParent.setSortId(parentId);
            flowParent.setHaveChild("1");
            flowSortMapper.updateByPrimaryKeySelective(flowParent);
            FlowSort flow =new FlowSort();
            flow.setSortNo(sortNo);
            flow.setSortName(flowName);
            flow.setSortParent(parentId);
            flow.setDeptId(departmentId);
            flow.setHaveChild("0");
            Integer insertRes = flowSortMapper.insertSelective(flow);
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

    @Transactional(rollbackFor = JobClassifyException.class)
    public BaseWrapper formUpdate(Integer formId,Integer parentId,Integer sortNo,String formName,Integer departmentId){
        BaseWrapper wrapper =   new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        if(formId==null){
            wrapper.setMsg("表单id不能为空");
            return wrapper;
        }
        FormSort exeSort=sortMapper.selectByPrimaryKey(formId);
        if(exeSort==null){
            wrapper.setMsg("无效的请求id");
            return wrapper;
        }
        //更新当前表单
        FormSort sortCur=new FormSort();
        sortCur.setDeptId(departmentId);
        sortCur.setSortId(formId);
        sortCur.setSortName(formName);
        sortCur.setSortNo(sortNo);
        sortCur.setSortParent(parentId);
        Integer curRes= sortMapper.updateByPrimaryKeySelective(sortCur);
        if(curRes<0) throw  new JobClassifyException("表单更新失败");
        if(exeSort.getSortParent()!=0){
            //判断父表单是否还有儿子有不操作，没有更新成无儿子
            Integer childSize=  sortMapper.getChildNumber(exeSort.getSortParent());
            L.w("o==||===========================>"+childSize);
            if(childSize>2){
                //不用更新
            }else{
                FormSort sortParent=new FormSort();
                sortParent.setHaveChild("0");
                sortParent.setSortId(exeSort.getSortParent());
                Integer parRes  =  sortMapper.updateByPrimaryKeySelective(sortParent);
                if(parRes<1) throw  new JobClassifyException("表单更新失败");
            }
        }

        wrapper.setFlag(true);
        wrapper.setStatus(true);
        wrapper.setMsg("更新成功");
        return  wrapper;
    }


    @Transactional(rollbackFor = JobClassifyException.class)
    public BaseWrapper flowUpdate(Integer flowId,Integer parentId,Integer sortNo,String flowName,Integer departmentId){
        BaseWrapper wrapper =   new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        if(flowId==null){
            wrapper.setMsg("表单id不能为空");
            return wrapper;
        }
        FlowSort exeSort=flowSortMapper.selectByPrimaryKey(flowId);
        if(exeSort==null){
            wrapper.setMsg("无效的请求id");
            return wrapper;
        }
        //更新当前表单
        FlowSort sortCur=new FlowSort();
        sortCur.setDeptId(departmentId);
        sortCur.setSortId(flowId);
        sortCur.setSortName(flowName);
        sortCur.setSortNo(sortNo);
        sortCur.setSortParent(parentId);
        Integer curRes= flowSortMapper.updateByPrimaryKeySelective(sortCur);
        if(curRes<0) throw  new JobClassifyException("表单更新失败");
        if(exeSort.getSortParent()!=0){
            //判断父表单是否还有儿子有不操作，没有更新成无儿子
            Integer childSize=  flowSortMapper.getChildNumber(exeSort.getSortParent());
            L.w("o==||===========================>"+childSize);
            if(childSize>2){
                //不用更新
            }else{
                FlowSort sortParent=new FlowSort();
                sortParent.setHaveChild("0");
                sortParent.setSortId(exeSort.getSortParent());
                Integer parRes  =  flowSortMapper.updateByPrimaryKeySelective(sortParent);
                if(parRes<1) throw  new JobClassifyException("表单更新失败");
            }
        }

        wrapper.setFlag(true);
        wrapper.setStatus(true);
        wrapper.setMsg("更新成功");
        return  wrapper;
    }







    private String checkParentOrDepartment(Integer parentId,Integer departmentId,Integer type){
        if(departmentId!=0){
            //查询部门是否存在
            Department department =departmentService.getDeptById(departmentId);
            if(department==null||department.getDeptId()==null){
                return "所属部门不存在";
            }
        }
        if(parentId!=0){
            //查询父分类是否存在
            return null;
        }
        switch (type){
            case CHECK_TYPE_FORM:
                    //查询父分类是否存在
                    FormSort formSort =sortMapper.selectByPrimaryKey(parentId);
                    if(formSort==null||formSort.getSortId()==null){
                        return "所属分类不存在";
                    }
                break;
            case CHECK_TYPE_FLOW:
                FlowSort flowSort=flowSortMapper.selectByPrimaryKey(parentId);
                if(flowSort==null||flowSort.getSortId()==null){
                    return "所属分类不存在";
                }
                break;
            default:
                return "发生未知程序错误！";

        }
        return null;
    }


}
