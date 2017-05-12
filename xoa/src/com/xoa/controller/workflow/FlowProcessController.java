package com.xoa.controller.workflow;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.workflow.FlowProcess;
import com.xoa.service.workflow.flowtype.FlowProcessService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

@Controller
@Scope(value = "prototype")
@RequestMapping("/flowProcess")
public class FlowProcessController {
	
	@Resource
	private FlowProcessService flowProcessService; 
	
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
	    		@RequestParam("listType") String listType, 
	    		@RequestParam("flowId") int flowId, 
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
		 * 方法介绍:   编辑
		 * 参数说明:   @param flowProcess 设计流程实体类
		 * 参数说明:   @param request 请求
		 * 参数说明:   @return
		 * @return     ToJson<FlowProcess> 
		 */
		@ResponseBody
	  	@RequestMapping(value = "editFlow",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcess> editFlow(FlowProcess flowProcess,	   
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			ToJson<FlowProcess> json= new ToJson<FlowProcess>(0,null);			
			try {
				//request.setCharacterEncoding("utf-8");
				flowProcessService.updateByPrimaryKeySelective(flowProcess);
		        json.setObject(flowProcess);
		        json.setMsg("OK");
		        json.setFlag(0);
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
		    return json;
		}
		
		
		@ResponseBody
	  	@RequestMapping(value = "doedit",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcess> doedit(int id,	   
	    		HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
			ToJson<FlowProcess> json= new ToJson<FlowProcess>(0,null);			
			try {
				FlowProcess flowProcess=flowProcessService.find(id);
				//request.setCharacterEncoding("utf-8");
				//flowProcessService.updateByPrimaryKeySelective(flowProcess);
		        json.setObject(flowProcess);
		        json.setMsg("OK");
		        json.setFlag(0);
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
		    return json;
		}
		
		
		
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
		
		@ResponseBody
	  	@RequestMapping(value = "delete",produces = {"application/json;charset=UTF-8"})
	    public ToJson<FlowProcess> delete(
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
	
	

		

	  	@RequestMapping(value = "xs",produces = {"application/json;charset=UTF-8"})
		public String xs(){
			
			return "app/workflow/flowprocess/flowProcess";
			
		}
		
		
}
