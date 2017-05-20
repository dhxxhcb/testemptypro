package com.xoa.service.workflow.flowsetting;

import com.xoa.dao.workflow.FlowPrivMapper;
import com.xoa.model.workflow.FlowPriv;
import com.xoa.model.workflow.FlowPrivExample;
import com.xoa.model.workflow.FlowPrivWithBLOBs;
import com.xoa.util.common.wrapper.BaseWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 韩东堂 on 2017/5/20.
 */
@Service
public class FlowPrivService {

    @Autowired
    FlowPrivMapper flowPrivMapper;

    public BaseWrappers queryFlowPriv(Integer flowId){
        BaseWrappers wrappers = new BaseWrappers();
        wrappers.setStatus(true);
//        List<FlowPriv>
//        FlowPrivWithBLOBs
        if(flowId==null){
            wrappers.setMsg("缺少必要的请求参数：flowId");
            wrappers.setFlag(false);
            return wrappers;
        }
        List<FlowPrivWithBLOBs> datas =  flowPrivMapper.queryByFlowId(flowId);
        if(datas==null||datas.size()<1){
            wrappers.setMsg("暂时没有数据，请联系管理员。");
            wrappers.setFlag(false);
        }else{
            wrappers.setMsg("数据请求成功");
            wrappers.setFlag(true);
            wrappers.setDatas(datas);
        }
        return wrappers;
    };

}
