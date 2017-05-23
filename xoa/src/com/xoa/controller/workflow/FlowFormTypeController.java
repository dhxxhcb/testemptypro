package com.xoa.controller.workflow;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.xoa.service.workflow.flowformtype.FlowFormService;
import com.xoa.service.workflow.wrapper.FlowFormWrappers;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/designer")
	public String designer(Model model,HttpServletRequest request, Integer formId) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		model.addAttribute("formId",formId);
		return "app/workflow/formtype/formDesigner";
	}
	@RequestMapping("/previews")
	public String previews(Model model,HttpServletRequest request,Integer formId) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));

		model.addAttribute("formId",formId);
		return "app/workflow/formtype/formUseView";
	}


	/**
	 *
	 * @Createby pfl
	 * @description 根据分类获取此分类下的所有表单
	 * @param sortId 所属分类Id
	 * @return
	 */
	@RequestMapping("/formlistbysort")
	@ResponseBody
	public FlowFormWrappers formBysort(Integer sortId){
		return flowFormService.getFormBySortId(sortId);
	}

	/**
	 * Created by:   韩东堂
	 * date:   2017/5/16 10:09
	 * description:   模糊搜索（根据表单名称）
	 * @param searchValue 搜索关键字
	 * @return
	 */
	@RequestMapping("/formBySearch")
	@ResponseBody
	public FlowFormWrappers formBySearch(String searchValue,Integer sortId){
		return flowFormService.seachForm(searchValue,sortId);
	}


	/**
	 * Created by:   pfl
	 * date:   2017/5/16 10:47
	 * description:   新建表单（根据表单名称）
	 * @param formName 表单名称
	 * @param deptId   部门Id
	 * @param formSort 表单分类Id
	 * @param otherinfo 其他预留信息（导入的时候使用，json串）
	 * @return
	 */
	@RequestMapping("/newForm")
	@ResponseBody
	public BaseWrapper newForm(String formName, Integer deptId, Integer formSort, String otherinfo){
		return flowFormService.newForm(formName,deptId,formSort,otherinfo);
	}
	/**
	 * Created by:   pfl
	 * date:   2017/5/16 15:47
	 * description:   更新表单（根据表单id）
	 * @param formId  表单Id
	 * @param formName 表单名称
	 * @param deptId  部门Id
	 * @param formSort 分类Id
	 * @param otherinfo 其他信息
	 * @return
	 */
	@RequestMapping("/updateForm")
	@ResponseBody
    public BaseWrapper updateForm(Integer formId,String formName,Integer deptId,Integer formSort,String otherinfo){
		return flowFormService.updateForm(formId,formName,deptId,formSort,otherinfo);
	}

	@RequestMapping("/updateFormType")
	@ResponseBody
	public BaseWrapper updateFormType(Integer formId,String formName,Integer deptId,Integer formSort,String printModel){
		return flowFormService.updateFormType(formId,formName,deptId,formSort,printModel);
	}

	/**
	 * Created by:   pfl
	 * date:   2017/5/17 15:58
	 * description:   更新表单（根据表单id）
	 * @param formId  表单Id
	 * @return
	 */
	@RequestMapping("/deleteForm")
	@ResponseBody
	public BaseWrapper deleteForm(Integer formId){
		return flowFormService.deleteForm(formId);
	}


}
