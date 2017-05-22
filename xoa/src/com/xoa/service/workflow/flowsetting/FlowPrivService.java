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




    private static final int SELF_ORG =-3;//本机构
    private static final int ALL_DEPT =-2;//所有部门
    private static final int SELF_DEPT =-1;//本部门


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
     * @param flowId 所属流程
     * @return
     */
    public BaseWrapper newFlowPriv(Integer privType,Integer scope[],Integer user[],Integer role[],Integer dept[],Integer flowId){
        BaseWrapper wrapper =new BaseWrapper();
        StringBuffer scopeStr=new StringBuffer(); //处理scope字段
        StringBuffer userStr=new StringBuffer(); //处理user字段
        StringBuffer roleStr=new StringBuffer(); //处理role字段
        StringBuffer deptStr=new StringBuffer(); //处理dept字段
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        if(flowId==null){
            wrapper.setMsg("所属流程不能为空");
            return wrapper;
        }
        if(privType==null){
            wrapper.setMsg("授权类型不能为空");
            return wrapper;
        }
        if(scope.length>1){
            //自定义
            for(Integer s:scope){
                scopeStr.append(s).append(",");
            }
        }else{
            if(scope.length==1){
                int priv_scope=scope[0];
                switch (priv_scope){
                    case SELF_ORG:
                        scopeStr.append("SELF_ORG");
                        break;
                    case ALL_DEPT:
                        scopeStr.append("ALL_DEPT");
                        break;
                    case SELF_DEPT:
                        scopeStr.append("SELF_DEPT");
                        break;
                        default:
                            scopeStr.append(priv_scope).append(",");
                            break;
                }
            }else{
              //异常数据
                wrapper.setMsg("数据异常或，请核对接口文档");
                return wrapper;
            }
        }
        if(user!=null&&user.length>0){
            for(Integer u:user){
                userStr.append(u).append(",");
            }
        }
        if(role!=null&&role.length>0){
            for(Integer r:role){
                roleStr.append(r).append(",");
            }
        }
        if(dept!=null&&dept.length>0){
            for(Integer d:dept){
                deptStr.append(d).append(",");
            }
        }
        FlowPrivWithBLOBs flowPrivWithBLOBs =new FlowPrivWithBLOBs();
        flowPrivWithBLOBs.setFlowId(flowId);
        flowPrivWithBLOBs.setDept(deptStr.toString());
        flowPrivWithBLOBs.setPrivScope(scopeStr.toString());
        flowPrivWithBLOBs.setRole(roleStr.toString());
        flowPrivWithBLOBs.setUser(userStr.toString());
        flowPrivWithBLOBs.setPrivType(privType);
       int res=  flowPrivMapper.insertSelective(flowPrivWithBLOBs);
       if(res>0){
           wrapper.setFlag(true);
           wrapper.setStatus(true);
           wrapper.setMsg("数据插入成功");
       }else{
           wrapper.setMsg("数据插入失败");
       }
        return wrapper;
    }

}
