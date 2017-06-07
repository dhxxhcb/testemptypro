package com.xoa.service.workflow.flowtigger;

import com.xoa.dao.workflow.FlowTiggerMapper;
import com.xoa.model.workflow.FlowTiggerModel;
import com.xoa.util.ToJson;
import org.springframework.stereotype.Service;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/6/7 14:04
 * 类介绍  :   触发器
 * 构造参数:
 */
public interface FlowTiggerService {

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/7 14:07
     * 方法介绍:   新建触发器
     * 参数说明:  触发器参数对象
     * @return
     */
    public ToJson<FlowTiggerModel> saveTigger(FlowTiggerModel flowTiggerModel);


    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/7 14:08
     * 方法介绍:   修改触发器内容
     * 参数说明:   触发器参数对象，id必传
     * @return
     */
    public ToJson<FlowTiggerModel> updateTigger(FlowTiggerModel flowTiggerModel);


}
