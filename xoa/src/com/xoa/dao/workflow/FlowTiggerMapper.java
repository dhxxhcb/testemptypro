package com.xoa.dao.workflow;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.workflow.FlowTiggerModel;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 张勇 on 2017/6/5.
 */
public interface FlowTiggerMapper  extends BaseMapper<FlowTiggerModel>{

    /**
     * 根据flowId和步骤 查询触发器信息
     * @param flowId
     * @param flowPrcs
     * @return
     */
    public  FlowTiggerModel selectFlowTigger(@Param("flowId") Integer flowId,@Param("flowPrcs") Integer flowPrcs);

}
