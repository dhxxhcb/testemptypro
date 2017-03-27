package com.xoa.controller.news;

import com.alibaba.fastjson.JSON;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.ToJson;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@Controller
@Scope(value="prototype")
public class NewsController {
	private Logger loger = Logger.getLogger(NewsController.class);
	@Resource
	private NewService newService;

	/**
	 * 信息展示 返回json demo
	 * @return 
	 */
//	@RequestMapping(value="/shownew")
//	public @ResponseBody Map<String, String> showNew() {
//		loger.info("进入显示信息页面");
//		ToJson<News> toJson = newService.showNews();
//		Map<String, String> map = new HashMap<String, String>();
////		map.put("showNews", JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
//		map.put("showNews", JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
////		map.put("showNews", "123");
//		System.out.println(map.get("showNews"));
////		return new ModelAndView("news/newsShow", map);
//		return map;
//	}
	
	@RequestMapping(value="/shownew",produces={"application/json;charset=UTF-8"})
	public @ResponseBody String showNew(){
		ToJson<News> toJson = newService.showNews();
		loger.info("结果信息："+ JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
	Map<String, String> map = new HashMap<String, String>();
	map.put("showNews", JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss");
	}
	
	
}
