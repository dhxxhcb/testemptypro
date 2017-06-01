package com.xoa.controller.work;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.xoa.util.common.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xoa.model.users.Users;
import com.xoa.model.workflow.FlowFast;
import com.xoa.model.workflow.FlowFormType;
import com.xoa.model.workflow.FlowProcess;
import com.xoa.model.workflow.FlowRun;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.workflow.flowtype.FlowFormTypeService;
import com.xoa.service.workflow.flowtype.FlowProcessService;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;
import com.xoa.service.workflow.flowtype.FlowRunService;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.CheckTableExist;
import com.xoa.util.ToJson;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月22日 上午11:43:13
 * 类介绍  :    新建工作
 * 构造参数:
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/workflow/work")
public class WorkController {

    @Resource
    private FlowTypeService flowTypeService;

    @Resource
    private FlowFormTypeService flowFormTypeService;

    @Resource
    private FlowRunService flowRunService;

    @Resource
    private FlowRunPrcsService flowRunPrcsService;

    @Resource
    private FlowProcessService flowProcessService;

    @RequestMapping("addwork")
    public String work(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/workflow/work/add_work";
    }

    @RequestMapping("workList")
    public String workList(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/workflow/work/workList";
    }

    @RequestMapping("workform")
    public String workform(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/workflow/work/workform";
    }

    @RequestMapping("workform1")
    public String workform1(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/workflow/work/workform1";
    }

    @RequestMapping("workfastAdd")
    @ResponseBody
	public ToJson<FlowFast> fastAdd(HttpServletRequest request,
		            int flowId) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
		"loginDateSouse"));
		int runId = flowRunService.getMaxRunId();
		String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
		int deptId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getDeptId();
		//FlowProcess flowProcess= flowProcessService.findbyprcsId(flowId, prcsId);
		List<FlowProcess> fl=flowProcessService.findFlowId(flowId);
		Map<String, Object> maps = new HashMap<String, Object>();
		ToJson<FlowFast> tj = new ToJson<FlowFast>();
		ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
		maps.put("flowId", flowId);
		toJson = flowTypeService.selectAllFlow(maps);
		FlowTypeModel flowTypeModel = (FlowTypeModel) toJson.getObject();
		String flowName = flowTypeModel.getFlowName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String beginTime = df.format(new Date());
		String runName = flowName + " " + beginTime;
		
		FlowRun flowRun = new FlowRun();
		flowRun.setRunId(runId);
		flowRun.setRunName(runName);
		flowRun.setFlowId(flowId);
		flowRun.setBeginUser(userId);
		flowRun.setBeginTime(beginTime);
		flowRun.setBeginDept(deptId);
		flowRun.setDelFlag("0");
		//flowRun.setDelTime(beginTime);
		flowRunService.save(flowRun);
		
		FlowRunPrcs flowRunPrcs = new FlowRunPrcs();
		flowRunPrcs.setRunId(runId);
		//flowRunPrcs.setPrcsId(flowProcess.getPrcsId());
		flowRunPrcs.setPrcsId(1);
		flowRunPrcs.setUserId(userId);
		flowRunPrcs.setPrcsDept(deptId);
		//flowRunPrcs.setPrcsFlag(prcsFlag);
		flowRunPrcs.setCreateTime(beginTime);
		flowRunPrcs.setPrcsTime(beginTime);
		flowRunPrcs.setDeliverTime(beginTime);
		flowRunPrcs.setActiveTime(beginTime);
		flowRunPrcsService.save(flowRunPrcs);
		
		ToJson<FlowFormType> json = new ToJson<FlowFormType>();
		json = flowFormTypeService.qureyItemMax(flowTypeModel.getFormId());
		FlowFormType flowFormType = (FlowFormType) json.getObject();
		FlowFast f = new FlowFast();
		f.setFlowTypeModel(flowTypeModel);
		f.setFlowFormType(flowFormType);
		f.setFlowRun(flowRun);
		f.setFlowRunPrcs(flowRunPrcs);
		f.setListFp(fl);
		//f.setFlowProcesses(flowProcess);
		
		try {
		tj.setObject(f);
		tj.setMsg("OK");
		tj.setFlag(0);
		} catch (Exception e) {
		tj.setMsg(e.getMessage());
		}
		return tj;
		}


    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月27日 上午9:54:09
     * 方法介绍:   转交保存表单数据
     * 参数说明:   @param request 请求
     * 参数说明:   @param flowId 流程id
     * 参数说明:   @param formdata 表单json串
     * 参数说明:   @param runId  flowRun的流程实例Id
     * 参数说明:   @param runName flowRun的流程实例名称
     * 参数说明:   @param beginTime flowRun流程实例创建时间
     * 参数说明:   @param beginUser  flowRun流程发起人Id
     * 参数说明:   @return
     * 参数说明:   @throws JSONException
     * @return     String 
     */
    @RequestMapping("nextwork")
    @ResponseBody
    public ToJson<FlowFast> nextwork(HttpServletRequest request,
                          @RequestParam(value="flowId",required = false) String flowId,
                          @RequestParam(value="formdata",required = false) String formdata,
                          @RequestParam(value="runId",required = false) int runId,
                          @RequestParam(value="runName",required = false) String runName,
                          @RequestParam(value="beginTime",required =false) String beginTime,
                          @RequestParam(value="beginUser",required =false) String beginUser
                         ) throws JSONException {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<FlowFast> tj = new ToJson<FlowFast>();
        FlowFast f=new FlowFast();
        FlowRunPrcs flowRunPrcs=null;
        String tableName = "flow_data_" + flowId;
        JSONArray json =new JSONArray();
        List<Map<String,Object>> l=json.parseObject(formdata,List.class);
     // Map<String,Object> map =json.parseObject(formdata,Map.class);
        StringBuffer sbcreate=new StringBuffer();
        if (!CheckTableExist.haveTable(tableName)) {
        	String sql = " create table  "+tableName+ ""
        			+ "(`id` int(10) not null auto_increment,"
        			+ "`run_id` int(10) not null default '0', "
        			+ "`run_name` varchar(200) not null default '',"
        			+ "`begin_user` varchar(20) not null default '',"
        			+ "`begin_time` datetime null,"
        			+ "`flow_auto_num` int(11) not null default '0', "
        			+ "`flow_auto_num_year` int(11) not null default '0', "
        			+ "`flow_auto_num_month` int(11) not null default '0',";
        	sbcreate.append(sql.toString());
        	for(Map<String,Object> map: l){        
        		String sql1= ""+ "`"+map.get("key")+"`"+ "text not null default '',";
        		sbcreate.append(sql1);
    		}
        	String sqlprimary=" primary key(id),unique key(run_id) );";
        	sbcreate.append(sqlprimary);
        	CheckTableExist.createSql(sbcreate.toString());
        } else {
        	 String keys = "run_id,run_name,begin_time,begin_user";
             String values = "" +runId + "," +"'"+ runName +"'"+ "," +"'"+ beginTime+"'" + "," +"'"+ beginUser+"'";
             StringBuffer sb = new StringBuffer();
             sb.append(keys);
             StringBuffer sb1 = new StringBuffer();
             sb1.append(values);
        	/*for(Entry<String, Object> m:map.entrySet()){
        		sb.append(",").append(m.getKey());
                sb1.append(",").append(m.getValue());
    		}*/
             for(Map<String,Object> map: l){
            	 sb.append(",").append(map.get("key"));
                 sb1.append(",").append("'").append(map.get("value")).append("'");
             }
            System.out.println(sb1.toString());
            String sqlAll = "insert into " + tableName + "(" + sb.toString() + ") " + "values(" + sb1.toString() + ")";
            System.out.println(sqlAll.toString());
            CheckTableExist.createSql(sqlAll);
            //String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
           // int deptId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getDeptId();
           /* flowRunPrcs = new FlowRunPrcs();
            flowRunPrcs.setRunId(runId);
            flowRunPrcs.setPrcsId(1);
           // flowRunPrcs.setUserId(userId);
            //flowRunPrcs.setPrcsDept(deptId);
            flowRunPrcs.setPrcsTime(beginTime);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            flowRunPrcs.setDeliverTime(df.format(new Date()));
            flowRunPrcs.setPrcsTime(beginTime);
            flowRunPrcs.setCreateTime(beginTime);
            flowRunPrcs.setDeliverTime(beginTime);
            flowRunPrcs.setActiveTime(beginTime);
            flowRunPrcsService.save(flowRunPrcs);*/
        }
        try {
            f.setFlowRunPrcs(flowRunPrcs);
            tj.setObject(f);
            tj.setMsg("OK");
            tj.setFlag(0);
        } catch (Exception e) {
            tj.setMsg(e.getMessage());
        }
        return tj;
    }


    @RequestMapping("saveWork")
    @ResponseBody
    public ToJson<FlowRunPrcs> savework(HttpServletRequest request,
                                        @RequestParam(value="runId",required = false) String runId,
                                        @RequestParam(value="runName",required = false) String runName,
                                        @RequestParam(value="flowId",required = false) String flowId,
                                        @RequestParam(value="prcsId",required = false) String prcsId,
                                        @RequestParam(value="prcsflag",required = false) String prcsFlag,
                                        @RequestParam(value="flowPrcs",required = false) String flowPrcs,
                                        @RequestParam(value="beginTime",required =false) String beginTime,
                                        @RequestParam(value="beginUser",required =false) String beginUser ) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));

        ToJson<FlowRunPrcs> toJson = new ToJson<FlowRunPrcs>();

        FlowRunPrcs flowRunPrcs = new FlowRunPrcs();
        flowRunPrcs.setRunId(Integer.parseInt(runId));
        flowRunPrcs.setPrcsId(Integer.parseInt(prcsId));
        flowRunPrcs.setUserId(beginUser);
        //flowRunPrcs.setPrcsDept(deptId);
        flowRunPrcs.setPrcsFlag(prcsFlag);
        flowRunPrcs.setPrcsTime(beginTime);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        flowRunPrcs.setDeliverTime(df.format(new Date()));
        flowRunPrcs.setCreateTime(beginTime);
        flowRunPrcs.setPrcsTime(beginTime);
        flowRunPrcs.setDeliverTime(beginTime);
        flowRunPrcs.setActiveTime(beginTime);
        flowRunPrcsService.save(flowRunPrcs);
        try {
            toJson.setObject(flowRunPrcs);
            toJson.setMsg("OK");
            toJson.setFlag(0);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }
        return toJson;
    }
    
    
    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:29
     * 方法介绍:   查询代办工作
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "selectWork", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<FlowRunPrcs> selectObject(FlowRunPrcs flowRunPrcs, HttpServletRequest request,
                                     @RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                     @RequestParam(value = "useFlag", required = false) boolean useFlag
    ) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(flowRunPrcs.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("userId", userId);
        } else {
            maps.put("userId", flowRunPrcs.getUserId());
        }
        return flowRunPrcsService.selectObject(maps, page, pageSize, useFlag);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:29
     * 方法介绍:   查询代办工作
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "selectEndWord", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<FlowRunPrcs> selectEnd(FlowRunPrcs flowRunPrcs, HttpServletRequest request,
                                  @RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                  @RequestParam(value = "useFlag", required = false) boolean useFlag
    ) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(flowRunPrcs.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("userId", userId);
        } else {
            maps.put("userId", flowRunPrcs.getUserId());
        }
        return flowRunPrcsService.selectEnd(maps, page, pageSize, useFlag);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:29
     * 方法介绍:   查询挂起工作
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "selectHang", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<FlowRunPrcs> selectEndHang(FlowRunPrcs flowRunPrcs, HttpServletRequest request,
      @RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "pageSize", required = false) Integer pageSize,
      @RequestParam(value = "useFlag", required = false) boolean useFlag) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(flowRunPrcs.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("userId", userId);
        } else {
            maps.put("userId", flowRunPrcs.getUserId());
        }
        return flowRunPrcsService.selectHang(maps, page, pageSize, useFlag);
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:29
     * 方法介绍:   查询所有工作
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "selectAll", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<FlowRunPrcs> selectAll(FlowRunPrcs flowRunPrcs, HttpServletRequest request,
                                  @RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                  @RequestParam(value = "useFlag", required = false) boolean useFlag
    ) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(flowRunPrcs.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("userId", userId);
        } else {
            maps.put("userId", flowRunPrcs.getUserId());
        }
        return flowRunPrcsService.selectAll(maps, page, pageSize, useFlag);
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/1 11:40
     * 方法介绍:  根据runId查询关联办理人的步骤和所在部门
     * 参数说明:
     * @return
     */
    @RequestMapping(value = "findAllNode", produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public @ResponseBody
    ToJson<FlowRunPrcs> findAllNode(HttpServletRequest request,
                                  @RequestParam(value = "runId", required = false) Integer runId) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return flowRunPrcsService.findAllNode(runId);
    }

}
