package com.xoa.controller.worldnews;

import com.alibaba.fastjson.JSON;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.ToJson;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	 * @throws Exception 
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
	public @ResponseBody String showNew(HttpServletRequest request,HttpServletResponse response) throws Exception{
//	public void doSerch(HttpServletRequest request,HttpServletResponse response){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		 Integer currentPage = ServletRequestUtils.getIntParameter(request, "currentPage", 0);  
//	     Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 5);
//	     String newsTims = ServletRequestUtils.getStringParameter(request, "newsTimes");
//	     String typeId = ServletRequestUtils.getStringParameter(request, "typeId");
		
		 Integer currentPage = 0;  
	     Integer pageSize = 5;
	     String newsTims = null;
	     String typeId = null;
	     Date date ;
	     if(newsTims != null ){
	    	 date = sdf.parse(newsTims);
	     }else{
	    	 date = null;
	     }
	     Map<String,Object> maps = new HashMap<String, Object>();
	     maps.put("typeId", null);
	     maps.put("newsTime", null);
//		Page<News> page = newService.showNews(typeId, date, currentPage, pageSize);
	    List<News> page = newService.selectNews(maps);
//		loger.info("结果信息："+ JSON.toJSONStringWithDateFormat(toJson, "yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss");
	}
	
	
}
