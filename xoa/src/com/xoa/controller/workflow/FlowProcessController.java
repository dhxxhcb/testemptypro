package com.xoa.controller.workflow;

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
				FlowProcess flowProcess=flowProcessService.find(flowId, id);
		        json.setObject(flowProcess);
		        json.setMsg("OK");
		        json.setFlag(0);
			} catch (Exception e) {
				json.setMsg(e.getMessage());
			}
		    return json;
	  		
	  	}
	
	

}
