package com.xoa.service.workflow.flowsetting;

import com.xoa.dao.workflow.FlowPrivMapper;
import com.xoa.dao.workflow.FlowTimerMapper;
import com.xoa.model.workflow.*;
import com.xoa.util.DateFormat;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.common.wrapper.BaseWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 韩东堂 on 2017/5/20.
 */
@Service
public class FlowPrivService {

    @Autowired
    FlowPrivMapper flowPrivMapper;
    @Autowired
    FlowTimerMapper flowTimerMapper;

//    提醒日期(1-仅此一次，存具体日期,2-按日，为空,3-按周，存星期几,4-按月，存每月几号,5-按年，存每年几月几号,)

    private static final int ONLY_ONE_TIMES=1;
    private static final int TIMER_BY_DAY =2;
    private static final int TIMER_BY_WEEK=3;
    private static final int TIMER_BY_MOUTH=4;
    private static final int TIMER_BY_YEAR=5;

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
                if(s<0){
                    wrapper.setMsg("数据异常或，请核对接口文档");
                    return wrapper;
                }
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

    /**
     * Created by:   pfl
     * date:   2017/5/22 18:58
     * description:   编辑权限管理（
     * @param privType 授权类型(1-管理,2-监控,3-查询,4-编辑,5-点评)
     * @param scope [SELF_ORG-本机构 对应 -3,ALL_DEPT-所有部门 对应 -2,SELF_DEPT-本部门 对应 -1,部门ID串 直接拼写数组 1，2，3]
     * @param user  授权用户id串 [1,2,3,4,5]
     * @param role  授权角色id串 [1,2,3,4,5]
     * @param dept  授权部门id串 [1,2,3,4,5]
     * @param flowId 所属流程
     * @param privId 要编辑的权限
     * @return
     */
    public BaseWrapper updateFlowPriv(Integer privType,Integer scope[],Integer user[],Integer role[],Integer dept[],Integer flowId,Integer privId){
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        if(flowId==null){
            wrapper.setMsg("所属流程不能为空");
            return wrapper;
        }
        if(privId==null){
            wrapper.setMsg("所选编辑对象Id不能为空");
            return wrapper;
        }
        StringBuffer scopeStr=null; //处理scope字段
        StringBuffer userStr=null; //处理user字段
        StringBuffer roleStr=null; //处理role字段
        StringBuffer deptStr=null; //处理dept字段
        if(scope!=null){
            scopeStr=new StringBuffer();
            if(scope.length>1){
                //自定义
                for(Integer s:scope){
                    if(s<0){
                        wrapper.setMsg("数据异常或，请核对接口文档");
                        return wrapper;
                    }
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
        }

        if(user!=null&&user.length>0){
            userStr =new StringBuffer();
            for(Integer u:user){
                userStr.append(u).append(",");
            }
        }
        if(role!=null&&role.length>0){
            roleStr =new StringBuffer();
            for(Integer r:role){
                roleStr.append(r).append(",");
            }
        }
        if(dept!=null&&dept.length>0){
            deptStr =new StringBuffer();
            for(Integer d:dept){
                deptStr.append(d).append(",");
            }
        }
        FlowPrivWithBLOBs flowPrivWithBLOBs =new FlowPrivWithBLOBs();
        flowPrivWithBLOBs.setFlowId(flowId);
        flowPrivWithBLOBs.setId(privId);
        if(deptStr!=null)
        flowPrivWithBLOBs.setDept(deptStr.toString());
        if(scopeStr!=null)
        flowPrivWithBLOBs.setPrivScope(scopeStr.toString());
        if(roleStr!=null)
        flowPrivWithBLOBs.setRole(roleStr.toString());
        if(userStr!=null)
        flowPrivWithBLOBs.setUser(userStr.toString());
        if(privType!=null)
        flowPrivWithBLOBs.setPrivType(privType);
        int res =flowPrivMapper.updateByPrimaryKeySelective(flowPrivWithBLOBs);
        if(res>0){
            wrapper.setFlag(true);
            wrapper.setStatus(true);
            wrapper.setMsg("数据更新成功");
        }else{
            wrapper.setMsg("数据更新失败");
        }
        return wrapper;
    }

    /**
     * Created by:   pfl
     * date:   2017/5/22 17:28
     * description:   删除权限
     * @param privId  权限Id
     * @return
     */
    public BaseWrapper deleteFlowPriv(Integer privId){
        BaseWrapper wrapper =new BaseWrapper();
        if(privId==null){
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("流程权限Id不能为空");
            return wrapper;
        }
        int res =flowPrivMapper.deleteByPrimaryKey(privId);
         if(res>0){
             wrapper.setFlag(true);
             wrapper.setStatus(true);
             wrapper.setMsg("删除成功");
         }else{
             wrapper.setFlag(false);
             wrapper.setStatus(true);
             wrapper.setMsg("删除失败");
         }
        return wrapper;
    }


    /**
     * Created by:   pfl
     * date:   2017/5/22 17:27
     * description:   获取所选流程的定时任务（根据流程id）
     * @param flowId  流程Id
     * @return
     */
    public BaseWrappers queryFlowTimer(Integer flowId){
        BaseWrappers wrappers = new BaseWrappers();
        wrappers.setStatus(true);
        wrappers.setFlag(false);
        if(flowId==null){
            wrappers.setMsg("缺少必要的请求参数：flowId");

            return wrappers;
        }
        List<FlowTimerWithBLOBs> datas =  flowTimerMapper.queryByFlowId(flowId);
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

    public BaseWrapper newFlowTimer(Integer flowId,Integer type,String date,Integer user[],Integer dept[],Integer role[]){
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setStatus(true);
        wrapper.setFlag(false);
        if(flowId==null){
            wrapper.setMsg("流程Id不能为空。");
            return wrapper;
        }
        if(type==null){
            wrapper.setMsg("定时任务类型不能为空。");
            return wrapper;
        }
        if(StringUtils.checkNull(date)){
            wrapper.setMsg("时间不能为空。");
            return wrapper;
        }
        String dateF="";
        Date time=null;
        try {
            time= DateFormat.getDate(date);
            switch (type){
                case ONLY_ONE_TIMES:
                  dateF =   DateFormat.getFormatByUse("yyyy-MM-dd",date);
                    break;
                case TIMER_BY_DAY:
                    dateF=  "";
                    break;
                case TIMER_BY_WEEK:
                    Calendar calendar =Calendar.getInstance();
                    calendar.setTime(time);
                    int week= calendar.get(Calendar.DAY_OF_WEEK);
                    StringBuffer weekStr=new StringBuffer("星期");
                    dateF=  weekStr.append( getWeekName(week-1)).toString();
                    break;
                case TIMER_BY_MOUTH:
                    dateF = DateFormat.getFormatByUse("每月dd号",date);
                    break;
                case TIMER_BY_YEAR:
                    dateF = DateFormat.getFormatByUse("每年MM月dd号",date);
                    break;
                default:
                    wrapper.setMsg("无效的参数类型");
                    return wrapper;

            }
        }catch (Exception e){
              e.printStackTrace();
            wrapper.setMsg("时间格式异常");
            return wrapper;
        }
        StringBuffer userStr=new StringBuffer(); //处理user字段
        StringBuffer roleStr=new StringBuffer(); //处理role字段
        StringBuffer deptStr=new StringBuffer(); //处理dept字段
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
        FlowTimerWithBLOBs flowTimerWithBLOBs =new FlowTimerWithBLOBs();
        flowTimerWithBLOBs.setDeptStr(deptStr.toString());
        flowTimerWithBLOBs.setPrivStr(roleStr.toString());
        flowTimerWithBLOBs.setUserStr(userStr.toString());
        flowTimerWithBLOBs.setType(String.valueOf(type));
        flowTimerWithBLOBs.setFlowId(flowId);
        flowTimerWithBLOBs.setRemindDate(dateF);
        flowTimerWithBLOBs.setRemindTime(time);
        flowTimerWithBLOBs.setLastTime(new Date());
       int res = flowTimerMapper.insertSelective(flowTimerWithBLOBs);
       if(res>0){
           wrapper.setFlag(true);
           wrapper.setMsg("添加成功");
       }else{
           wrapper.setMsg("添加失败");
       }
        return wrapper;
    }

    private String getWeekName(Integer week){
        String[] b={"日","一","二","三","四","五","六"};
        return  b[week];
    }

}
