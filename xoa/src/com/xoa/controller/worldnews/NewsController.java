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
import org.springframework.web.bind.annotation.RequestParam;
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
@Scope(value = "prototype")
@RequestMapping("/news")
public class NewsController {
	private Logger loger = Logger.getLogger(NewsController.class);
	@Resource
	private NewService newService;

	/**
	 * 新闻显示页面
	 * 
	 * @return
	 */
	@RequestMapping("/clicknews")
	public String newsIndexPage() {
		return "/app/news/newsShow";
	}
	/**
	 * 新闻显示页面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String clickNews() {
		return "/app/news/index";
	}
	/**
	 * 信息展示 返回json demo
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsShow", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String showNews(
			@RequestParam(value = "format", required = false) String format,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "newsTime", required = false) String newsTime,
			@RequestParam(value = "lastEditTime", required = false) String lastEditTime,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("format", format);
		maps.put("typeId", typeId);
		maps.put("subject", subject);
		maps.put("newsTime", newsTime);
		maps.put("lastEditTime", lastEditTime);
		maps.put("keyword", keyword);
		String name = "changbai";
		String returnReslt = null;
		String err = null;
		try {
			List<News> list = newService.selectNews(maps, page, pageSize, useFlag, name);
			ToJson<News> tojson = new ToJson<News>(0, "");
			tojson.setObj(list);
			if (list.size() > 0) {
				err = "成功";
				returnReslt = JSON.toJSONStringWithDateFormat(tojson,
						"yyyy-MM-dd HH:mm:ss");
			} else {
				err = "失败";
				returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<News>(
						1, ""), "yyyy-MM-dd HH:mm:ss");
			}

		} catch (Exception e) {
			loger.debug("NewsMessage:" + e);
			returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<News>(1,
					""), "yyyy-MM-dd HH:mm:ss");
		}

		return returnReslt;
	}

	/**
	 * 信息展示 返回json demo
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/unreadShow", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String unreadNews(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
		Map<String, Object> maps = new HashMap<String, Object>();
		String name = "wangyun";
		String returnReslt = null;
		String err = null;
		try {
			List<News> list = newService.unreadNews(maps, page, pageSize, useFlag, name);
			System.out.println(list);
			ToJson<News> tojson = new ToJson<News>(0, err);
			tojson.setObj(list);
			if (list.size() > 0) {
				err = "成功";
				returnReslt = JSON.toJSONStringWithDateFormat(tojson,
						"yyyy-MM-dd HH:mm:ss");
			} else {
				err = "失败";
				returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<News>(
						1, ""), "yyyy-MM-dd HH:mm:ss");
			}
		} catch (Exception e) {
			loger.debug("NewsMessage:" + e);
			returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<News>(1,
					""), "yyyy-MM-dd HH:mm:ss");
		}

		return returnReslt;
	}

}
