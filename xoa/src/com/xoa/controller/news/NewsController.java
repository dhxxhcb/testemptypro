package com.xoa.controller.news;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;




@Controller
@Scope(value="prototype")
public class NewsController {
	private Logger loger = Logger.getLogger(NewsController.class);
	@Resource
	private NewService newService;

	
	/**
	 * 信息展示
	 * @return 
	 */
	@RequestMapping("/shownew")
	@ResponseBody
	public String showNew() {
		loger.info("进入显示信息页面");
		List<News> list = newService.showNews();
		for(News news:list){
			loger.info("结果信息："+JSONArray.toJSONString(news));
//			JSONArray.toJSONString(news);
		}
//		JSONArray.toJSON(list);
//		loger.info(.p);
//		JSONArray.toJSONStringWithDateFormat(list, arg1, arg2)
		return null;
	}
	
	
	
}
