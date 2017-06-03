package com.xoa.controller.workflow;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xoa.util.common.CheckCallBack;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.workflow.FlowProcess;
import com.xoa.model.workflow.FlowProcessList;
import com.xoa.service.workflow.flowtype.FlowFormTypeService;
import com.xoa.service.workflow.flowtype.FlowProcessService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

@Controller
@Scope(value = "prototype")
@RequestMapping("/flowProcess")
public class FlowProcessController {
	
	@Resource
	private FlowProcessService flowProcessService; 
	
	@Resource
	private FlowFormTypeService  flowFormTypeService;
	
		/**
		 * 创建作者:   张龙飞
		 * 创建日期:   2017年5月10日 上午9:49:53
		 * 方法介绍:   查询设计流程步骤
		 * 参数说明:   @param listType 
		 * 参数说明:   @param flowId 流程id
		 * 参数说明:   @param id 主键id
		 * 参数说明:   @param request 请求
		 * 参数说明:   @return
		 * @return     ToJson<FlowProcess>  流程步骤信息
		 */
		@ResponseBody
	  	@RequestMapping(value = "findFlow",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcess> findFlow(
//	    		@RequestParam("listType") String listType, 
//	    		@RequestParam("flowId") int flowId, 
	    		@RequestParam("id") int id, 
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			ToJson<FlowProcess> json= new ToJson<FlowProcess>(0,null);
			try {
				FlowProcess flowProcess=flowProcessService.find(id);
		        json.setObject(flowProcess);
		        json.setMsg("OK");
		        json.setFlag(0);
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
		    return json;
	  		
	  	}
		/**
		 * 创建作者:   张龙飞
		 * 创建日期:   2017年5月10日 上午11:18:20
		 * 方法介绍:   修改后保存
		 * 参数说明:   @param flowProcess 设计流程实体类
		 * 参数说明:   @param request 请求
		 * 参数说明:   @return
		 * @return     ToJson<FlowProcess> 
		 */
		@ResponseBody
	  	@RequestMapping(value = "saveFlow",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
	    public ToJson<FlowProcess> saveFlow(FlowProcess flowProcess,
	    		@RequestParam(value = "ITEM_ID",required = false) String itemId,
	    		@RequestParam(value = "AUTO_PRCS_USER",required = false) String autoPrcsUser,
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			L.a("itemId："+itemId);
			L.a("autoPrcsUser："+autoPrcsUser);
			System.out.println("settlementOfCondition:"+flowProcess.getSettlementOfCondition());

			JSONArray.parse(flowProcess.getSettlementOfCondition());

//			JSONArray json=JSON.parseArray(flowProcess.getSettlementOfCondition());
//			J
//			for (int i = 0 ; i <json.size();i++){
//				jsonOne = json.getJSONObject(i);
//			}
//
//			jsonArray.
//			System.out.println("settlementOfCondition:"+ StringUtils.checkNullUtils(new CheckCallBack() {
//				@Override
//				public boolean isNull(Object obj) {
//					if(obj instanceof  String ){
//
//					}
//					return false;
//
//				}
//			},1,"uidasdad"));

//			@RequestParam(value = "settlementOfCondition ",required = false) JSON settlementOfCondition ,
			return flowProcessService.updateByPrimaryKeySelective(flowProcess);
		}


	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月19日 下午6:57:03
	 * 方法介绍:   新增流程
	 * 参数说明:   @param flowProcess
	 * 参数说明:   @param request
	 * 参数说明:   @return
	 * 调优修改
	 * @return ToJson<FlowProcess>
	 */
	@ResponseBody
	@RequestMapping(value = "insert", produces = {"application/json;charset=UTF-8"})
	public ToJson<FlowProcess> insert(FlowProcess flowProcess,
									  HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return flowProcessService.insertSelective(flowProcess);
	}
		
		/**
		 * 创建作者:   张龙飞
		 * 创建日期:   2017年5月20日 上午10:37:09
		 * 方法介绍:   修改
		 * 参数说明:   @param id
		 * 参数说明:   @param request
		 * 参数说明:   @return
		 * @return     ToJson<FlowProcess>
		 */
		@ResponseBody
	  	@RequestMapping(value = "doedit",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcess> doedit(int id,	   
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			ToJson<FlowProcess> json= new ToJson<FlowProcess>(0,null);			
			try {
				FlowProcess flowProcess=flowProcessService.find(id);
		        json.setObject(flowProcess);
		        json.setMsg("OK");
		        json.setFlag(0);
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
		    return json;
		}
		
		
		
		/**
		 * 创建作者:   张龙飞
		 * 创建日期:   2017年5月20日 上午10:37:19
		 * 方法介绍:   查询flowid下所有流程
		 * 参数说明:   @param flowId 流程id
		 * 参数说明:   @param request 请求
		 * 参数说明:   @return
		 * @return     ToJson<FlowProcess> 流程信息
		 */
		@ResponseBody
	  	@RequestMapping(value = "findFlowId",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcess> findFlowId(
	    		@RequestParam("flowId") int flowId, 
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			ToJson<FlowProcess> json= new ToJson<FlowProcess>(0,null);			
			try {
				List<FlowProcess> list=flowProcessService.findFlowId(flowId);
		        json.setObj(list);
		        json.setMsg("OK");
		        json.setFlag(0);
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
		    return json;
		}
		
		/**
		 * 创建作者:   张龙飞
		 * 创建日期:   2017年5月20日 上午10:37:52
		 * 方法介绍:   删除流程
		 * 参数说明:   @param id 流程id
		 * 参数说明:   @param request 请求
		 * 参数说明:   @return
		 * @return     ToJson<FlowProcess>  返回流程信息
		 */
		@ResponseBody
	  	@RequestMapping(value = "delete",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcess> delete(
	    		@RequestParam("id") int id, 
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
				return flowProcessService.delete(id);
		}
	
		/**
		 * 创建作者:   张龙飞
		 * 创建日期:   2017年5月20日 上午10:38:27
		 * 方法介绍:   查询流程
		 * 参数说明:   @param flowId
		 * 参数说明:   @param request
		 * 参数说明:   @return
		 * @return     ToJson<FlowProcess>
		 */
		@ResponseBody
	  	@RequestMapping(value = "flowview",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcessList> flowview(
	    		@RequestParam("flowId") int flowId, 
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			ToJson<FlowProcessList> json= new ToJson<FlowProcessList>(0,null);			
			try {
				FlowProcessList f=flowProcessService.flowView(flowId);
				json.setObject(f);
		        json.setMsg("OK");
		        json.setFlag(0);
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
		    return json;
		}




	  	@RequestMapping(value = "xs",produces = {"application/json;charset=UTF-8"})
		public String xs(){
			return "app/workflow/flowprocess/flowProcess";
		}
		
		
}
