package com.xoa.controller.work;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.xoa.util.common.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.users.Users;
import com.xoa.model.workflow.FlowFast;
import com.xoa.model.workflow.FlowFormType;
import com.xoa.model.workflow.FlowRun;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.model.workflow.FlowTypeModel;
import com.xoa.service.workflow.flowtype.FlowFormTypeService;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;
import com.xoa.service.workflow.flowtype.FlowRunService;
import com.xoa.service.workflow.flowtype.FlowTypeService;
import com.xoa.util.CheckTableExist;
import com.xoa.util.ToJson;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.page.PageParams;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月22日 上午11:43:13
 * 类介绍  :    新建工作
 * 构造参数:   
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/workflow/work")
public class WorkController {
	
	@Resource
	private FlowTypeService flowTypeService;
	
	@Resource
	private FlowFormTypeService  flowFormTypeService;
	
	@Resource
	private FlowRunService flowRunService;
	
	@Resource
	private FlowRunPrcsService flowRunPrcsService;
	
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
			int flowId){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		int runId=flowRunService.getMaxRunId();
		String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
		int deptId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getDeptId();
		Map<String, Object> maps=new HashMap<String, Object>();
		 ToJson<FlowFast> tj=new ToJson<FlowFast>();
		 ToJson<FlowTypeModel> toJson = new ToJson<FlowTypeModel>();
	        maps.put("flowId", flowId);
		toJson=flowTypeService.selectAllFlow(maps);
		FlowTypeModel flowTypeModel=(FlowTypeModel) toJson.getObject();
		String flowName=flowTypeModel.getFlowName();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String beginTime=df.format(new Date());
		String runName=flowName+" "+beginTime;
		
		FlowRun flowRun=new FlowRun();
		flowRun.setRunId(runId);
		flowRun.setRunName(runName);
		flowRun.setFlowId(flowId);
		flowRun.setBeginUser(userId);
		flowRun.setBeginTime(beginTime);
		flowRun.setBeginDept(deptId);
		flowRun.setDelFlag("0");
		//flowRun.setDelTime(beginTime);
		flowRunService.save(flowRun);	
		
		FlowRunPrcs flowRunPrcs =new FlowRunPrcs();
		flowRunPrcs.setRunId(runId);
		flowRunPrcs.setPrcsId(1);
		flowRunPrcs.setUserId(userId);
		flowRunPrcs.setPrcsDept(deptId);
		//flowRunPrcs.setPrcsFlag(prcsFlag);
		flowRunPrcs.setCreateTime(beginTime);
		flowRunPrcs.setPrcsTime(beginTime);
		flowRunPrcs.setDeliverTime(beginTime);
		flowRunPrcs.setActiveTime(beginTime);
		flowRunPrcsService.save(flowRunPrcs);
		
		ToJson<FlowFormType> json=new ToJson<FlowFormType>();
		json=flowFormTypeService.qureyItemMax(flowTypeModel.getFormId());
		FlowFormType flowFormType=(FlowFormType) json.getObject();
		FlowFast f=new FlowFast();
		f.setFlowTypeModel(flowTypeModel);
		f.setFlowFormType(flowFormType);
		f.setFlowRun(flowRun);
		f.setFlowRunPrcs(flowRunPrcs);
		
		try {
            tj.setObject(f);
            tj.setMsg("OK");
            tj.setFlag(0);
		} catch (Exception e) {
			tj.setMsg(e.getMessage());
		}
        return tj;		
	}
	
	@RequestMapping("nextwork")
	public String addwork(String str,HttpServletRequest request,
			@RequestParam("flowId") String flowId,
			@RequestParam("json") JSONObject hostObject) throws JSONException{
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		String tableName="flow_data_"+flowId;
		if(!CheckTableExist.haveTable(tableName)){
			//JSONObject json = JSONObject.fromObject(jsonObject);  
			
		}else{
			String sql="run_id,run_name,begin_time,begin_user";
			StringBuffer sb=new StringBuffer();
			sb.append(sql);
			
			     hostObject = new JSONObject();  
			    Iterator<String> sIterator = hostObject.keys();  
			    while(sIterator.hasNext()){  
			        // 获得key  
			        String key = sIterator.next();  
			        // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可  
			        String value = hostObject.getString(key);  
			        sb.append(",").append(key);
			        
			        System.out.println("key: "+key+",value"+value);  
			    }  
			
			
		}
		
		
		return "";
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
		}else {
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
		}else {
			maps.put("userId", flowRunPrcs.getUserId());
		}
		return flowRunPrcsService.selectEnd(maps, page, pageSize, useFlag);
	}

}
