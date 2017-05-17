package com.xoa.controller.sys;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.controller.news.NewsController;
import com.xoa.model.unitmanagement.UnitManage;
import com.xoa.service.unitmanagement.UnitManageService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

@Controller
@Scope(value = "prototype")
@RequestMapping("/sys")
public class UnitManagementController {
	private Logger loger = Logger.getLogger(NewsController.class);
	@Resource
	private UnitManageService unitManageService;
	@RequestMapping("/companyInfo")
	public String companyInfo(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/sys/companyInfo";
	}
	/**
	 * 信息展示 返回
	 * 
	 * @return
	 */
	@RequestMapping(value = "/showUnitManage", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody ToJson<UnitManage>showUnitManage(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<UnitManage> json=new ToJson<UnitManage>(0, null);
		
		try{
			UnitManage um = unitManageService.showUnitManage();
			json.setObject(um);
			json.setMsg("OK");
			json.setFlag(0);
		}catch(Exception e){
			json.setMsg(e.getMessage());
		}
		return json;
		}

	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addUnitMnaage", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody void addUnitMnaage(UnitManage unitManage,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		
		unitManageService.addUnitManage(unitManage);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateUnit",produces = {"application/json;charset=UTF-8"})
	public ToJson<UnitManage> updateUnit(UnitManage unitManage,HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<UnitManage> json=new ToJson<UnitManage>(0, null);
		try{
			unitManageService.update(unitManage);
			json.setObject(unitManage);
			json.setMsg("OK");
			json.setFlag(0);
		}catch(Exception e){
			json.setMsg(e.getMessage());
		}
		return json;
		}
	
}
