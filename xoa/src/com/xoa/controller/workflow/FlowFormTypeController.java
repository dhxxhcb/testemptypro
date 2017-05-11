package com.xoa.controller.workflow;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.xoa.service.workflow.flowformtype.FlowFormService;
import com.xoa.service.workflow.wrapper.FlowFormWrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.workflow.FlowFormType;
import com.xoa.service.workflow.flowtype.FlowFormTypeService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

@Controller
@Scope(value = "prototype")
@RequestMapping("/form")
public class FlowFormTypeController {
	@Resource
	private FlowFormTypeService  flowFormTypeService;
	@Autowired
	FlowFormService flowFormService;

	@RequestMapping(value = "formType",produces = {"application/json;charset=UTF-8"})
	public @ResponseBody ToJson<FlowFormType> qureyItemMax(@RequestParam("fromId") String fromId,HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return flowFormTypeService.qureyItemMax(Integer.parseInt(fromId));
	}
	@RequestMapping("/abc")
	public String addboxPage1(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/ArticleEdit/ArticleEdit";
	}
	@RequestMapping("/cba")
	public String addboxPage2(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/ArticleEdit/MyJsp";
	}
	@RequestMapping("/wyq")
	public String addboxPage3(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/ArticleEdit/formDesigner";
	}

	@RequestMapping("/formlistbysort")
	@ResponseBody
	public FlowFormWrappers formBysort(Integer sortId){
		return flowFormService.getFormBySortId(sortId);
	}

}
