package com.xoa.service.workflow.flowtype.impl;

import com.xoa.dao.workflow.FlowTypeModelMapper;
import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.ToJson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/5/8 16:43
 * 类介绍  :
 * 构造参数:
 */
@Service
public class FlowTypeServiceImpl  implements FlowTypeService{

    @Resource
    private FlowTypeModelMapper flowTypeModelMapper;


    @Transactional
    @Override
    public ToJson<FlowTypeModel> saveFlow(FlowTypeModel flowTypeModel) {
        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
        try{
            flowTypeModelMapper.save(flowTypeModel);
            toJson.setMsg("ok");
            toJson.setFlag(0);
        }catch (Exception e){
            toJson.setMsg("error");
            toJson.setFlag(1);
        }
        return toJson;
    }

    @Override
    public ToJson<FlowTypeModel> quertBySortId(Integer flowId) {
        ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();

        List<FlowTypeModel> datas=flowTypeModelMapper.selectBySortid(flowId);

            toJson.setObj(datas);
            toJson.setFlag(0);
            toJson.setMsg("success");


        return toJson;
    }
}
