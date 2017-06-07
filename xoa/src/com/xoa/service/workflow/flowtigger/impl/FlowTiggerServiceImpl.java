package com.xoa.service.workflow.flowtigger.impl;

import com.xoa.dao.workflow.FlowTiggerMapper;
import com.xoa.model.workflow.FlowTiggerModel;
import com.xoa.service.workflow.flowtigger.FlowTiggerService;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import org.apache.axis.client.async.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/6/7 14:10
 * 类介绍  :
 * 构造参数:
 */
@Service
public class FlowTiggerServiceImpl implements FlowTiggerService {

    @Resource
    private FlowTiggerMapper flowTiggerMapper;

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/7 14:11
     * 方法介绍:   新建触发器
     * 参数说明:  触发器参数对象
     * @return
     */
    @Override
    @Transactional
    public ToJson<FlowTiggerModel> saveTigger(FlowTiggerModel flowTiggerModel) {
        ToJson<FlowTiggerModel> toJson = new ToJson<FlowTiggerModel>();
        try {
            flowTiggerMapper.save(flowTiggerModel);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        }catch (Exception e){
            L.e("FlowTiggerModel_SaveError:"+e);
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/7 14:11
     * 方法介绍:   修改触发器内容
     * 参数说明:   触发器参数对象，id必传
     * @return
     */
    @Override
    @Transactional
    public ToJson<FlowTiggerModel> updateTigger(FlowTiggerModel flowTiggerModel) {
        ToJson<FlowTiggerModel> toJson = new ToJson<FlowTiggerModel>();
        try {
            flowTiggerMapper.update(flowTiggerModel);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        }catch (Exception e){
            L.e("FlowTiggerModel_UpdateError:"+e);
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }
}
