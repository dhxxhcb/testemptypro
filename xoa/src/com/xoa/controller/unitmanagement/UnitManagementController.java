package com.xoa.controller.unitmanagement;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.controller.worldnews.NewsController;
import com.xoa.model.unitmanagement.UnitManage;
import com.xoa.service.unitmanagement.UnitManageService;

@Controller
@Scope(value = "prototype")
public class UnitManagementController {
	private Logger loger = Logger.getLogger(NewsController.class);
	@Resource
	private UnitManageService unitManageService;

	/**
	 * 信息展示 返回
	 * 
	 * @return
	 */
	@RequestMapping(value = "/showUnitManage", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String showUnitManage() {
		UnitManage um = unitManageService.showUnitManage();
		loger.info("结果信息：" + JSON.toJSONStringWithDateFormat(um, "yyyy-MM-dd HH:mm:ss"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("showNews", JSON.toJSONStringWithDateFormat(um, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(um, "yyyy-MM-dd HH:mm:ss");
	}


	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addUnitMnaage", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody void addUnitMnaage(UnitManage unitManage) {
		
		unitManageService.addUnitManage(unitManage);
	}
}
