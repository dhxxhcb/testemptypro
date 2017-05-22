package com.xoa.service.workflow.flowsetting;

import com.xoa.dao.workflow.FlowPrivMapper;
import com.xoa.model.workflow.FlowPriv;
import com.xoa.model.workflow.FlowPrivExample;
import com.xoa.model.workflow.FlowPrivWithBLOBs;
import com.xoa.util.common.wrapper.BaseWrapper;
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



    /**
     * Created by:   pfl
     * date:   2017/5/20 15:47
     * description:   获取所选流程的权限设置（根据流程id）
     * @param flowId  流程Id
     * @return
     */
    public BaseWrappers queryFlowPriv(Integer flowId){
        BaseWrappers wrappers = new BaseWrappers();
        wrappers.setStatus(true);
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
    }

    /**
     * Created by:   pfl
     * date:   2017/5/20 17:47
     * description:   新建权限管理（
     * @param privType 授权类型(1-管理,2-监控,3-查询,4-编辑,5-点评)
     * @param scope [SELF_ORG-本机构 对应 -3,ALL_DEPT-所有部门 对应 -2,SELF_DEPT-本部门 对应 -1,部门ID串 直接拼写数组 1，2，3]
     * @param user  授权用户id串 [1,2,3,4,5]
     * @param role  授权角色id串 [1,2,3,4,5]
     * @param dept  授权部门id串 [1,2,3,4,5]
     * @return
     */
    public BaseWrapper newFlowPriv(Integer privType,Integer scope[],Integer user[],Integer role[],Integer dept[]){
        BaseWrapper wrapper =new BaseWrapper();
        if(scope.length>1){
            //自定义
        }else{
            if(scope.length==1){
                int priv_scope=scope[0];
            }else{
              //异常数据
            }
        }





        return wrapper;
    }

}
