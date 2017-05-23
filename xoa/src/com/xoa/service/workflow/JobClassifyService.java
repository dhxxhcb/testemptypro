package com.xoa.service.workflow;

import com.xoa.dao.workflow.FlowSortMapper;
import com.xoa.dao.workflow.FormSortMapper;
import com.xoa.model.department.Department;
import com.xoa.model.users.Users;
import com.xoa.model.workflow.FlowSort;
import com.xoa.model.workflow.FormSort;
import com.xoa.model.workflow.FormSortExample;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.workflow.wrapper.JobSelectorModel;
import com.xoa.service.workflow.wrapper.JobSelectorWrapper;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

   /**
    * 
    * @作者 韩东堂
    * @创建日期 2017-5-9 下午4:24:21 
    * @方法介绍 添加表单服务
    * @参数说明 @param parentId 表单父分类Id
    * @参数说明 @param sortNo 序号
    * @参数说明 @param formName 表单分类名称
    * @参数说明 @param departmentId 部门id
    * @参数说明 @return
    * @return
    */
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

    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:25:26 
     * @方法介绍 流程分类添加
     * @参数说明 @param parentId  父id
     * @参数说明 @param sortNo  序号
     * @参数说明 @param flowName  分类名字
     * @参数说明 @param departmentId 部门Id
     * @参数说明 @return
     * @return
     */

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
  
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:26:24 
     * @方法介绍 表单分类更新
     * @参数说明 @param formId 表单ID
     * @参数说明 @param parentId 父id
     * @参数说明 @param sortNo 序号
     * @参数说明 @param formName 表单名称
     * @参数说明 @param departmentId 部门id
     * @参数说明 @return
     * @return
     */
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

        //移动的父分类是否有儿子
        if(parentId!=0){
            Integer childSize=  sortMapper.getChildNumber(parentId);
            if(childSize==0){
                FormSort sortParent=new FormSort();
                sortParent.setHaveChild("1");
                sortParent.setSortId(parentId);
                Integer parRes  =  sortMapper.updateByPrimaryKeySelective(sortParent);
                if(parRes<1) throw  new JobClassifyException("表单更新失败");
            }
        }


        wrapper.setFlag(true);
        wrapper.setStatus(true);
        wrapper.setMsg("更新成功");
        return  wrapper;
    }

    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:29:39 
     * @方法介绍 流程分类修改
     * @参数说明 @param flowId 流程id
     * @参数说明 @param parentId 父Id
     * @参数说明 @param sortNo 序号
     * @参数说明 @param flowName 流程分类名称
     * @参数说明 @param departmentId 部门Id
     * @参数说明 @return
     * @return
     */

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
        //移动的父分类是否有儿子
        if(parentId!=0){
            Integer childSize=  flowSortMapper.getChildNumber(parentId);
            if(childSize==0){
                FlowSort sortParent=new FlowSort();
                sortParent.setHaveChild("1");
                sortParent.setSortId(parentId);
                Integer parRes  =  flowSortMapper.updateByPrimaryKeySelective(sortParent);
                if(parRes<1) throw  new JobClassifyException("表单更新失败");
            }
        }
        wrapper.setFlag(true);
        wrapper.setStatus(true);
        wrapper.setMsg("更新成功");
        return  wrapper;
    }
    
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:32:39 
     * @方法介绍 删除流程分类
     * @参数说明 @param flowId 流程分类Id
     * @参数说明 @return
     * @return
     */
    @Transactional(rollbackFor = JobClassifyException.class)
    public BaseWrapper deleteFlow(Integer flowId) {
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        try{
            if(flowId==null){
                wrapper.setMsg("流程id不能为空");
                return wrapper;
            }
            FlowSort exeSort=flowSortMapper.selectByPrimaryKey(flowId);
            if(exeSort==null){
                wrapper.setMsg("无效的请求id");
                return wrapper;
            }
            //判断有没有儿子元素
            Integer childSize=  flowSortMapper.getChildNumber(flowId);
            if(childSize>0){
                wrapper.setMsg("请先删除子分类");
                return wrapper;
            }
            //判断有没有流程
            Integer  flowSize =  flowSortMapper.selectflowSortNum(flowId);
            if(flowSize>0){
                wrapper.setMsg("请先删除流程");
                return wrapper;
            }
            //删除流程分类
            int deleteRes=  flowSortMapper.deleteByPrimaryKey(flowId);
            if(deleteRes>0){
                wrapper.setFlag(true);
                wrapper.setStatus(true);
                wrapper.setMsg("操作成功");
            }else {
                throw  new JobClassifyException("流程删除失败");
            }
            //判断父类有没有儿子
            if(exeSort.getSortParent()!=0){
                //判断父表单是否还有儿子有不操作，没有更新成无儿子
                Integer pchildSize=  flowSortMapper.getChildNumber(exeSort.getSortParent());
                L.w("o==||===========================>"+pchildSize);
                if(pchildSize>2){
                    //不用更新
                }else{
                    FlowSort sortParent=new FlowSort();
                    sortParent.setHaveChild("0");
                    sortParent.setSortId(exeSort.getSortParent());
                    Integer parRes  =  flowSortMapper.updateByPrimaryKeySelective(sortParent);
                    if(parRes<1) throw  new JobClassifyException("流程删除失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  new JobClassifyException("流程删除失败");
        }

        return wrapper;
    }
    
    
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-9 下午4:33:12 
     * @方法介绍  删除表单分类流程
     * @参数说明 @param formId 表单分类Id
     * @参数说明 @return
     * @return
     */
    @Transactional(rollbackFor = JobClassifyException.class)
    public BaseWrapper deleteForm(Integer formId) {
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        try{
            if(formId==null){
                wrapper.setMsg("表单id不能为空");
                return wrapper;
            }
            FormSort exeSort=sortMapper.selectByPrimaryKey(formId);
            if(exeSort==null){
                wrapper.setMsg("无效的请求id");
                return wrapper;
            }
            //判断有没有儿子元素
            Integer childSize=  sortMapper.getChildNumber(formId);
            if(childSize>0){
                wrapper.setMsg("请先删除子分类");
                return wrapper;
            }
            //判断有没有流程
            Integer  flowSize =  sortMapper.selectflowSortNum(formId);
            if(flowSize>0){
                wrapper.setMsg("请先删除表单");
                return wrapper;
            }
            //删除流程分类
            int deleteRes=  sortMapper.deleteByPrimaryKey(formId);
            if(deleteRes>0){
                wrapper.setFlag(true);
                wrapper.setStatus(true);
                wrapper.setMsg("操作成功");
            }else {
                throw  new JobClassifyException("流程删除失败");
            }
            //判断父类有没有儿子
            if(exeSort.getSortParent()!=0){
                //判断父表单是否还有儿子有不操作，没有更新成无儿子
                Integer pchildSize=  sortMapper.getChildNumber(exeSort.getSortParent());
                L.w("o==||===========================>"+pchildSize);
                if(pchildSize>2){
                    //不用更新
                }else{
                    FormSort sortParent=new FormSort();
                    sortParent.setHaveChild("0");
                    sortParent.setSortId(exeSort.getSortParent());
                    Integer parRes  =  sortMapper.updateByPrimaryKeySelective(sortParent);
                    if(parRes<1) throw  new JobClassifyException("流程删除失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  new JobClassifyException("流程删除失败");
        }

        return wrapper;
    }




    
  /**
   * 
   * @作者 韩东堂
   * @创建日期 2017-5-9 下午4:33:36 
   * @方法介绍  检查用户信息十分课考
   * @参数说明 @param parentId  父Id
   * @参数说明 @param departmentId 部门id
   * @参数说明 @param type
   * @参数说明 @return
   * @return
   */
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

      /**
       * 
       * @作者 韩东堂
       * @创建日期 2017-5-12 上午10:41:24 
       * @方法介绍  表单设计文件格式数据
       * @参数说明 @return
       * @return
       */
     public JobSelectorWrapper easyFormTree(){
         JobSelectorWrapper wrapper =new JobSelectorWrapper();
         List<FormSort>  resultdatas =new ArrayList<FormSort>();
         List<FormSort> nosortDatas= sortMapper.selectAllFormSort();
         Integer noform=sortMapper.selectNoformSort();
         FormSort formSort =new FormSort();
         formSort.setSortName("未定义");
         formSort.setFormcounts(noform);
         formSort.setHaveChild("0");
         formSort.setSortNo(0);
         formSort.setSortId(-1);
         formSort.setSortParent(0);
         FormSort formSortP =new FormSort();
         formSortP.setSortName("表单分类");
         formSortP.setFormcounts(noform);
         formSortP.setHaveChild("0");
         formSortP.setSortNo(0);
         formSortP.setSortId(0);
         resultdatas.add(formSortP);
         resultdatas.add(formSort);
         resultdatas.addAll(nosortDatas);
         wrapper.setDatas(resultdatas);
         wrapper.setFlag(true);
         wrapper.setStatus(true);
         wrapper.setMsg("获取数据成功");
         return wrapper;
     }
     /**
      * 
      * @作者 韩东堂
      * @创建日期 2017-5-15 上午9:43:14 
      * @方法介绍 流程设计文件格式数据
      * @参数说明 @return
      * @return
      */
    public JobSelectorWrapper easyFlowTree(){
        JobSelectorWrapper wrapper =new JobSelectorWrapper();
        List<FlowSort> nosortDatas= flowSortMapper.selectAllFlowSort();
        Integer noform=flowSortMapper.selectNoflowSort();
        List<FlowSort>  resultdatas =new ArrayList<FlowSort>();
        FlowSort flowSort =new FlowSort();
        flowSort.setSortName("未定义");
        flowSort.setFlowcounts(noform);
        flowSort.setHaveChild("0");
        flowSort.setSortNo(0);
        flowSort.setSortParent(0);
        flowSort.setSortId(-1);
        FlowSort flowSortP =new FlowSort();
        flowSortP.setSortName("流程分类");
        flowSortP.setFlowcounts(noform);
        flowSortP.setHaveChild("0");
        flowSortP.setSortNo(0);
        flowSortP.setSortId(0);
        resultdatas.add(flowSortP);
        resultdatas.add(flowSort);
        resultdatas.addAll(nosortDatas);
        wrapper.setDatas(resultdatas);
        wrapper.setFlag(true);
        wrapper.setStatus(true);
        wrapper.setMsg("获取数据成功");
        return  wrapper;
    }

    /**
     *
     * @作者 韩东堂
     * @创建日期 2017-5-23 上午10:01:23
     * @方法介绍 流程分类根据登录用户展示接口
     * @参数说明 @return
     * @return
     */
    public JobSelectorWrapper getFlowsortByAuth(HttpServletRequest request) {

        JobSelectorWrapper wrapper =new JobSelectorWrapper();
        wrapper.setStatus(true);
        wrapper.setFlag(false);
        Users user= SessionUtils.getSessionInfo(request.getSession(),Users.class,new Users());
        if(user.getUid()==null){
            wrapper.setMsg("无法获取用户信息");
            return wrapper;
        }
        Map<String,Object> param =new HashMap<String,Object>();
        String privOther= user.getUserPrivOther()==null?"":user.getUserPrivOther();//辅助角色
        String privIds[] =privOther.split(",");
        String deptOther = user.getDeptIdOther()==null?"":user.getDeptIdOther();//辅助部门
        String deptIds[] =deptOther.split(",");
        param.put("user", user.getUserId()==null?"":user.getUserId());
        param.put("deptId",user.getDeptId()==null?"":user.getDeptId());
        param.put("privId", user.getUserPriv()==null?"":user.getUserPriv());
        if(privIds!=null&&privIds.length>0){
            param.put("privIds",privIds);
        }
        if(deptIds!=null&&deptIds.length>0){
            param.put("deptIds",deptIds);
        }
        List<FlowSort> nosortDatas= flowSortMapper.selectAllFlowSort();
        List<FlowSort> authdatas=flowSortMapper.selectFlowSortByAuth(param);

        List<FlowSort> authdatasSort= sortDatasAuthFlow(authdatas,0,nosortDatas);
        if(authdatasSort!=null&&authdatasSort.size()>0){
            wrapper.setFlag(true);
            wrapper.setMsg("获取成功");
            wrapper.setDatas(authdatasSort);
        }else{
            wrapper.setFlag(false);
            wrapper.setMsg("没有数据");
        }

        return  wrapper;
    }


    private List<FlowSort> sortDatasAuthFlow(List<FlowSort> authdatas,Integer sortIda,List<FlowSort> alldata) {
        if(authdatas==null) return null;
        List<FlowSort> datas = new ArrayList<FlowSort>();
        for(FlowSort sort:authdatas ){
            if(sort!=null) {
                if(sort.getSortParent()!=0){
                    int checkRes=0;
                    for(FlowSort need:authdatas){
                        if(need.getSortId()!=sort.getSortParent()){
                            checkRes++;
                        }
                    }
                    if(checkRes==authdatas.size()){
                        for(FlowSort all:alldata){
                            if(all.getSortId()==sort.getSortParent()){
                                authdatas.add(all);
                            }
                        }
                    }
                }
                if (sort.getSortParent() == sortIda) {
                    sort.setChilds(sortDatasAuthFlow(authdatas, sort.getSortId(),alldata));
                    datas.add(sort);
                }
            }
        }
        return datas;
    }
}
