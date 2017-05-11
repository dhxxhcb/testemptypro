package com.xoa.service.workflow.flowformtype;

import com.xoa.dao.workflow.FlowFormTypeMapper;
import com.xoa.model.workflow.FlowFormType;
import com.xoa.service.workflow.wrapper.FlowFormWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 王曰岐 on 2017/5/10.
 */
@Service
public class FlowFormService {
    @Autowired
    FlowFormTypeMapper flowFormTypeMapper;
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


}
