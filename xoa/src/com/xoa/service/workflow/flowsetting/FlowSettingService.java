package com.xoa.service.workflow.flowsetting;

import com.xoa.dao.workflow.FlowPrivMapper;
import com.xoa.dao.workflow.FlowQueryTplMapper;
import com.xoa.dao.workflow.FlowTimerMapper;
import com.xoa.model.users.Users;
import com.xoa.model.workflow.*;
import com.xoa.util.DateFormat;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.common.wrapper.BaseWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 韩东堂 on 2017/5/20.
 */
@Service
public class FlowSettingService {

    @Autowired
    FlowPrivMapper flowPrivMapper;
    @Autowired
    FlowTimerMapper flowTimerMapper;
    @Autowired
    FlowQueryTplMapper flowQueryTplMapper;


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

    /**
     * Created by:   pfl
     * date:   2017/5/23 17:27
     * description:   添加定时任务（根据流程id）
     * @param flowId 流程类型
     * @param type   提醒日期(1-仅此一次，存具体日期,2-按日，为空,3-按周，存星期几,4-按月，存每月几号,5-按年，存每年几月几号,
     * @param date 时间
     * @param user 用户范围
     * @param dept 部门范围
     * @param role 角色范围
     * @return
     */
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

    /**
     *
     * @param timerId
     * @param flowId
     * @param type
     * @param date
     * @param user
     * @param dept
     * @param role
     * @return
     */
    public BaseWrapper updateFlowTimer(Integer timerId, Integer flowId, Integer type, String date, Integer[] user, Integer[] dept, Integer[] role) {
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setStatus(true);
        wrapper.setFlag(false);
        if(timerId==null){
            wrapper.setMsg("timerId不能为空。");
            return wrapper;
        }
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
        flowTimerWithBLOBs.setTid(timerId);
        int res = flowTimerMapper.updateByPrimaryKeySelective(flowTimerWithBLOBs);
        if(res>0){
            wrapper.setFlag(true);
            wrapper.setMsg("更新成功");
        }else{
            wrapper.setMsg("更新失败");
        }
        return wrapper;
    }


    public BaseWrapper deleteFlowTimer(Integer timerId) {
        BaseWrapper wrapper =new BaseWrapper();
        if(timerId==null){
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("timerId不能为空");
            return wrapper;
        }
        int res =flowTimerMapper.deleteByPrimaryKey(timerId);
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
     * date:   2017/5/24 16:27
     * description:   配置查询模板接口查询（根据流程id）
     * @param flowId  流程Id
     */
    public BaseWrappers getFlowQueryTpl(Integer flowId){
        BaseWrappers wrappers = new BaseWrappers();
        wrappers.setStatus(true);
        wrappers.setFlag(false);
        if(flowId==null){
            wrappers.setMsg("缺少必要的请求参数：flowId");
            return wrappers;
        }
        List<FlowQueryTpl> datas = flowQueryTplMapper.queryByFlowId(flowId);
        if(datas!=null&&datas.size()>0){
            wrappers.setDatas(datas);
            wrappers.setFlag(true);
        }else{
            wrappers.setMsg("暂时没有数据");
        }
       return wrappers;
    }

    private String getWeekName(Integer week){
        String[] b={"日","一","二","三","四","五","六"};
        return  b[week];
    }

    /**
     * Created by:   pfl
     * date:   2017/5/24 19:27
     * description:   配置查询模板接口 添加（根据流程id）
     * @param request  从session 中获取 用户ID
     * @param tplName 模板名称
     * @param flowId 流程ID
     * @param viewFields 扩展显示字段
     * @param groupFields 分组字段
     * @param dataConditions 表单数据过滤条件
     * @param flowConditions 流程过滤条件
     * @param dataXml 查询模板内容
     * @param condFormula 查询条件公式
     * @return
     */
    public BaseWrapper newFlowQuertIpl(HttpServletRequest request, String tplName, Integer flowId, String viewFields, String groupFields, String dataConditions, String flowConditions, String dataXml, String condFormula) {
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        Users user= SessionUtils.getSessionInfo(request.getSession(),Users.class,new Users());
        FlowQueryTplWithBLOBs flowQueryTplWithBLOBs =new FlowQueryTplWithBLOBs();
        if(!StringUtils.checkNull(user.getUserId())){
            flowQueryTplWithBLOBs.setUserId(user.getUserId());
        }
        String checkRes=StringUtils.checkNullUtils(new CheckCallBack() {
            @Override
            public boolean isNull(Object obj) {
                if (obj instanceof String) {
                    String a = (String) obj;
                    if (a == null || "".equals(a)
                            || a.length() == 0)
                        return true;
                }
                if (obj instanceof Integer) {
                    Integer a = (Integer) obj;
                    if (a == null)
                        return true;
                }
                return false;
            }
        },tplName,"模板名称不能为空",flowId,"流程ID不能为空",dataXml,"查询模板内容不能为空",condFormula,"查询条件公式不能为空");
        if(checkRes!=null){
            wrapper.setMsg(checkRes);
            return wrapper;
        }
        flowQueryTplWithBLOBs.setDataConditions(dataConditions);
        flowQueryTplWithBLOBs.setDataXml(dataXml);
        flowQueryTplWithBLOBs.setFlowConditions(flowConditions);
        flowQueryTplWithBLOBs.setGroupByFields(groupFields);
        flowQueryTplWithBLOBs.setCondFormula(condFormula);
        flowQueryTplWithBLOBs.setTplName(tplName);
        flowQueryTplWithBLOBs.setFlowId(flowId);
        flowQueryTplWithBLOBs.setViewExtFields(viewFields);
        Integer res = flowQueryTplMapper.insertSelective(flowQueryTplWithBLOBs);
        if(res>0){
            wrapper.setFlag(true);
            wrapper.setMsg("成功");
        }else{
            wrapper.setMsg("添加失败");
        }
        return wrapper;
    }


    /**
     * Created by:   pfl
     * date:   2017/5/24 19:27
     * description:   配置查询模板接口 更新（根据流程id）
     * @param tplId
     * @param request
     * @param tplName
     * @param flowId
     * @param viewFields
     * @param groupFields
     * @param dataConditions
     * @param flowConditions
     * @param dataXml
     * @param condFormula
     * @return
     */
    public BaseWrapper updateFlowQuertTpl(Integer tplId, HttpServletRequest request, String tplName, Integer flowId, String viewFields, String groupFields, String dataConditions, String flowConditions, String dataXml, String condFormula) {
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        Users user= SessionUtils.getSessionInfo(request.getSession(),Users.class,new Users());
        FlowQueryTplWithBLOBs flowQueryTplWithBLOBs =new FlowQueryTplWithBLOBs();
        if(!StringUtils.checkNull(user.getUserId())){
            flowQueryTplWithBLOBs.setUserId(user.getUserId());
        }
        String checkRes=StringUtils.checkNullUtils(new CheckCallBack() {
            @Override
            public boolean isNull(Object obj) {
                if (obj instanceof String) {
                    String a = (String) obj;
                    if (a == null || "".equals(a)
                            || a.length() == 0)
                        return true;
                }
                if (obj instanceof Integer) {
                    Integer a = (Integer) obj;
                    if (a == null)
                        return true;
                }
                return false;
            }
        },tplId,"tplId不能为空",tplName,"模板名称不能为空",flowId,"流程ID不能为空",dataXml,"查询模板内容不能为空",condFormula,"查询条件公式不能为空");
        if(checkRes!=null){
            wrapper.setMsg(checkRes);
            return wrapper;
        }
        flowQueryTplWithBLOBs.setSeqId(tplId);
        flowQueryTplWithBLOBs.setDataConditions(dataConditions);
        flowQueryTplWithBLOBs.setDataXml(dataXml);
        flowQueryTplWithBLOBs.setFlowConditions(flowConditions);
        flowQueryTplWithBLOBs.setGroupByFields(groupFields);
        flowQueryTplWithBLOBs.setCondFormula(condFormula);
        flowQueryTplWithBLOBs.setTplName(tplName);
        flowQueryTplWithBLOBs.setFlowId(flowId);
        flowQueryTplWithBLOBs.setViewExtFields(viewFields);
        Integer res = flowQueryTplMapper.updateByPrimaryKeySelective(flowQueryTplWithBLOBs);
        if(res>0){
            wrapper.setFlag(true);
            wrapper.setMsg("成功");
        }else{
            wrapper.setMsg("添加失败");
        }
        return wrapper;


    }

    /**
     * Created by:   pfl
     * date:   2017/5/24 20:27
     * description:   根据Id获取对应的模板信息
     * @param tplId
     * @return
     */
      public BaseWrapper queryFlowQuertTplById(Integer tplId) {
        BaseWrapper wrapper =new BaseWrapper();
        wrapper.setFlag(false);
        wrapper.setStatus(true);
        if(tplId==null){
            wrapper.setMsg("tplId不能为空");
            return wrapper;
        }
        FlowQueryTplWithBLOBs flowQueryTplWithBLOBs = flowQueryTplMapper.selectByPrimaryKey(tplId);
        if(flowQueryTplWithBLOBs!=null){
            wrapper.setFlag(true);
            wrapper.setMsg("数据获取成功");
            wrapper.setData(flowQueryTplWithBLOBs);
        }else{
            wrapper.setMsg("没有数据");
        }
        return wrapper;
    }

    public BaseWrapper deleteFlowQuertTpl(Integer tplId) {
        BaseWrapper wrapper =new BaseWrapper();
        if(tplId==null){
            wrapper.setFlag(false);
            wrapper.setStatus(true);
            wrapper.setMsg("tplId不能为空");
            return wrapper;
        }
        int res =flowQueryTplMapper.deleteByPrimaryKey(tplId);
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
}
