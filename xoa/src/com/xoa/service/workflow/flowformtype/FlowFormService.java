package com.xoa.service.workflow.flowformtype;

import com.xoa.dao.workflow.FlowFormTypeMapper;
import com.xoa.model.workflow.FlowFormType;
import com.xoa.service.workflow.wrapper.FlowFormWrappers;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 韩东堂 on 2017/5/10.
 */
@Service
public class FlowFormService {

    @Autowired
    FlowFormTypeMapper flowFormTypeMapper;

    /**
     * 创建作者:   韩东堂
     * 创建日期:   2017/5/12 16:55
     * 方法介绍:   根据FormId获取所有表单
     * 参数说明:   获取页面传递对象参数
     * @return
     */
    public FlowFormWrappers getFormBySortId(Integer sortId){
        FlowFormWrappers wrappers =new FlowFormWrappers();
       List<FlowFormType> datas= flowFormTypeMapper.selectFormBySort(sortId);
       if(datas!=null&&datas.size()>0){
           wrappers.setDatas(datas);
           wrappers.setStatus(true);
           wrappers.setFlag(true);
           wrappers.setMsg("数据请求成功");
       }else{
           wrappers.setStatus(true);
           wrappers.setFlag(false);
           wrappers.setMsg("没有数据了，请新建...");
       }
//        wrappers.setDatas();
        return wrappers;
    }


    /**
     * Created by:   韩东堂
     * date:   2017/5/16 09:45
     * description:   模糊搜索（根据表单名称）
     * @param searchValue 搜索关键字
     * @param sortId 所属分类（保留字段）
     * @return
     */
    public FlowFormWrappers seachForm(String searchValue,Integer sortId){
        FlowFormWrappers wrapper =new FlowFormWrappers();

        if(StringUtils.checkNull(searchValue)){
            wrapper.setMsg("搜素字段不能为空");
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            return wrapper;
        }
        List<FlowFormType> datas =  flowFormTypeMapper.queryBySearchValue(searchValue,sortId);
        if(datas!=null&&datas.size()>0){
            wrapper.setDatas(datas);
            wrapper.setStatus(true);
            wrapper.setFlag(true);
            wrapper.setMsg("数据请求成功");
        }else{
            wrapper.setStatus(true);
            wrapper.setFlag(false);
            wrapper.setMsg("没有数据了，请新建...");
        }
        return wrapper;
    }

    /**
     * Created by:   pfl
     * date:   2017/5/16 10:47
     * description:   新建表单（根据表单名称）
     * @param formName 表单名称
     * @param deptId   部门Id
     * @param formSort 表单分类Id
     * @param otherinfo 其他预留信息（导入的时候使用，json串）
     * @return
     */
    public BaseWrapper newForm(String formName,Integer deptId,Integer formSort,String otherinfo){
        BaseWrapper wrapper =new BaseWrapper();
        if(StringUtils.checkNull(formName)){
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("表单名称不能为空");
            return wrapper;
        }
        FlowFormType flowFormType =new FlowFormType();
        flowFormType.setFormName(formName);
        flowFormType.setDeptId(deptId);
        flowFormType.setFormSort(formSort);
        int res = flowFormTypeMapper.insertSelectParam(flowFormType);
        if(res>0){
            wrapper.setFlag(true);
            wrapper.setStatus(true);
            wrapper.setMsg("新建表单成功");
        }else{
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("新建表单失败");
        }

        return wrapper;
    }

    /**
     * Created by:   pfl
     * date:   2017/5/16 15:47
     * description:   更新表单（根据表单id）
     * @param formId  表单Id
     * @param formName 表单名称
     * @param deptId  部门Id
     * @param formSort 分类Id
     * @param otherinfo 其他信息
     * @return
     */
    public BaseWrapper updateForm(Integer formId,String formName,Integer deptId,Integer formSort,String otherinfo){
        BaseWrapper wrapper =new BaseWrapper();
        if(StringUtils.checkNull(formName)){
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("表单名称不能为空");
            return wrapper;
        }
        if(formId==null){
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("表单Id不能为空");
            return wrapper;
        }
        FlowFormType flowFormType =new FlowFormType();
        flowFormType.setFormName(formName);
        flowFormType.setDeptId(deptId);
        flowFormType.setFormSort(formSort);
        flowFormType.setFormId(formId);
        int res =flowFormTypeMapper.updateSelectParam(flowFormType);
        if(res>0){
            wrapper.setFlag(true);
            wrapper.setStatus(true);
            wrapper.setMsg("更新表单成功");
        }else{
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("更新表单失败");
        }

        return wrapper;
    }

    /**
     * Created by:   pfl
     * date:   2017/5/17 09:49
     * description:   删除表单（根据表单id）
     * @param formId  表单Id
     * @return
     */
     public BaseWrapper deleteForm(Integer formId){
         BaseWrapper wrapper =new BaseWrapper();
         if(formId==null){
             wrapper.setFlag(false);
             wrapper.setStatus(true);
             wrapper.setMsg("表单Id不能为空");
             return wrapper;
         }
         //检查表单是非被流程占用
         int useNumber = flowFormTypeMapper.checkFormUserNumber(formId);
         if(useNumber>0){
             wrapper.setFlag(false);
             wrapper.setStatus(true);
             wrapper.setMsg("表单被占用，请先解除关联或删除对于流程");
             return wrapper;
         }
         //是 返回失败操作
         //否 删除表单
         int res= flowFormTypeMapper.deleteForm(formId);

         if(res>0){
             wrapper.setFlag(true);
             wrapper.setStatus(true);
             wrapper.setMsg("删除成功");
         }else{
             wrapper.setFlag(false);
             wrapper.setStatus(true);
             wrapper.setMsg("操作失败");
         }
         return wrapper;
     }




}
