package com.xoa.controller.work;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xoa.model.workflow.FlowFast;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

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
	
	public ToJson<FlowFast> fastAdd(HttpServletRequest request,
			int flowId){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		
		return null;
		
	}
	
	@RequestMapping("addFastwork")
	public String addwork(String str,HttpServletRequest request) throws JSONException{
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
	    JSONObject hostObject = new JSONObject();  
	    Iterator<String> sIterator = hostObject.keys();  
	    while(sIterator.hasNext()){  
	        // 获得key  
	        String key = sIterator.next();  
	        // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可  
	        String value = hostObject.getString(key);  
	        System.out.println("key: "+key+",value"+value);  
	    }  
        
		
		
		return "";
	}
}
