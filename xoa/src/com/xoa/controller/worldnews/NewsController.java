package com.xoa.controller.worldnews;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailBody;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.DateFormat;
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
	public String clickNews() {
		return "/app/news/newsShow";
	}
	
	/**
	 * 信息展示 返回json demo
	 * 
	 * @return
	 * @throws Exception
	 */
@RequestMapping(value = "/showNewsManage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
  public @ResponseBody String selectNewsManage(){
		Map<String, Object> maps = new HashMap<String, Object>();
		String returnReslt = null;
		String err="";
		try {
			List<News> list =newService.selectNewsManage(maps, 1, 5, true);
			System.out.println(list.size()+"11111111111");
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
			List<News> list = newService.selectNews(maps, page, pageSize,
					useFlag, name);
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
	 * @author wyq
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
			List<News> list = newService.unreadNews(maps, page, pageSize,
					useFlag, name);
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

	/**
	 * 保存新闻
	 */
	@RequestMapping(value = "/sendNews", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String insertNews(
			@RequestParam("subject") String subject,
			@RequestParam("provider") String provider,
			@RequestParam("newsTime") String newsTime,
			@RequestParam("clickCount") Integer clickCount,
			@RequestParam("anonymityYn") String anonymityYn,
			@RequestParam("format") String format,
			@RequestParam("typeId") String typeId,
			@RequestParam("publish") String publish,
			@RequestParam("top") String top,
			@RequestParam("lastEditor") String lastEditor,
			@RequestParam("lastEditTime") String lastEditTime,
			@RequestParam("subjectColor") String subjectColor,
			@RequestParam("keyword") String keyword,
			@RequestParam("topDays") String topDays,
			@RequestParam("content") String content,
			@RequestParam("attachmentId") String attachmentId,
			@RequestParam("attachmentName") String attachmentName,
			@RequestParam("toId") String toId,
			@RequestParam("privId") String privId,
			@RequestParam("userId") String userId,
			@RequestParam("readers") String readers,
			@RequestParam("compressContent") String compressContent,
			@RequestParam("summary") String summary) {
		   News news=new News();
		    news.setNewsId(0);
		    news.setSubject(this.returnValue(subject));
		    news.setProvider(this.returnValue(provider));
		    news.setNewsTime(DateFormat.getDate(newsTime));
		    news.setClickCount(Integer.valueOf(clickCount));
		    news.setAnonymityYn(this.returnValue(anonymityYn));
		    news.setFormat(this.returnValue(format));
		    news.setTypeId(this.returnValue(typeId));
		    news.setPublish(this.returnValue(publish));
		    news.setTop(this.returnValue(top));
		    news.setLastEditor(this.returnValue(lastEditor));
		    news.setLastEditTime(DateFormat.getDate(lastEditTime));
		    news.setSubjectColor(this.returnValue(subjectColor));
		    news.setKeyword(this.returnValue(keyword));
		    news.setTopDays(this.returnValue(topDays));
		    news.setContent(this.returnValue(content));
		    news.setAttachmentId(this.returnValue(attachmentId));
		    news.setAnonymityYn(this.returnValue(anonymityYn));
		    news.setToId(this.returnValue(toId));
		    news.setPrivId(this.returnValue(privId));
		    news.setUserId(this.returnValue(userId));
		    news.setReaders(this.returnValue(readers));
		    news.setCompressContent(compressContent.getBytes());
		    news.setSummary(this.returnValue(summary));
		    try {
		    	newService.sendNews(news);
		    	return JSON.toJSONStringWithDateFormat(
						new ToJson<News>(0, ""), "yyyy-MM-dd HH:mm:ss");
			} catch (Exception e) {
				loger.debug("sendNews:" + e);
				return JSON.toJSONStringWithDateFormat(
						new ToJson<News>(1, ""), "yyyy-MM-dd HH:mm:ss");
			}

		}
	/**
	 * 修改新闻
	 */
	@RequestMapping(value = "/updateNews", produces = { "application/json;charset=UTF-8" })
	public String updateNews(@RequestParam("newsId") Integer newsId,
			@RequestParam("subject") String subject,
			@RequestParam("provider") String provider,
			@RequestParam("newsTime") String newsTime,
			@RequestParam("clickCount") Integer clickCount,
			@RequestParam("anonymityYn") String anonymityYn,
			@RequestParam("format") String format,
			@RequestParam("typeId") String typeId,
			@RequestParam("publish") String publish,
			@RequestParam("top") String top,
			@RequestParam("lastEditor") String lastEditor,
			@RequestParam("lastEditTime") String lastEditTime,
			@RequestParam("subjectColor") String subjectColor,
			@RequestParam("keyword") String keyword,
			@RequestParam("topDays") String topDays,
			@RequestParam("content") String content,
			@RequestParam("attachmentId") String attachmentId,
			@RequestParam("attachmentName") String attachmentName,
			@RequestParam("toId") String toId,
			@RequestParam("privId") String privId,
			@RequestParam("userId") String userId,
			@RequestParam("readers") String readers,
			@RequestParam("compressContent") String compressContent,
			@RequestParam("summary") String summary){
		 News news=new News();
		    news.setNewsId(newsId);
		    news.setSubject(this.returnValue(subject));
		    news.setProvider(this.returnValue(provider));
		    news.setNewsTime(DateFormat.getDate(newsTime));
		    news.setClickCount(Integer.valueOf(clickCount));
		    news.setAnonymityYn(this.returnValue(anonymityYn));
		    news.setFormat(this.returnValue(format));
		    news.setTypeId(this.returnValue(typeId));
		    news.setPublish(this.returnValue(publish));
		    news.setTop(this.returnValue(top));
		    news.setLastEditor(this.returnValue(lastEditor));
		    news.setLastEditTime(DateFormat.getDate(lastEditTime));
		    news.setSubjectColor(this.returnValue(subjectColor));
		    news.setKeyword(this.returnValue(keyword));
		    news.setTopDays(this.returnValue(topDays));
		    news.setContent(this.returnValue(content));
		    news.setAttachmentId(this.returnValue(attachmentId));
		    news.setAnonymityYn(this.returnValue(anonymityYn));
		    news.setToId(this.returnValue(toId));
		    news.setPrivId(this.returnValue(privId));
		    news.setUserId(this.returnValue(userId));
		    news.setReaders(this.returnValue(readers));
		    news.setCompressContent(compressContent.getBytes());
		    news.setSummary(this.returnValue(summary));
		    try {
		    	newService.updateNews(news);
		    	return JSON.toJSONStringWithDateFormat(
						new ToJson<EmailBody>(0, ""), "yyyy-MM-dd HH:mm:ss");
			} catch (Exception e) {
				loger.debug("sendNews:" + e);
				return JSON.toJSONStringWithDateFormat(
						new ToJson<EmailBody>(1, ""), "yyyy-MM-dd HH:mm:ss");
			}
	}
	/**
	 * 根据ID删除新闻
	 * 返回json demo
	 * 
	 * @author wyq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteNews", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String deleteNews(@RequestParam("newsId") Integer newsId){
		ToJson<News> toJson=new ToJson<News>(0, "");
		loger.debug("传过来的ID"+newsId);
		
		try {
			newService.deleteByPrimaryKey(newsId);
			toJson.setMsg("成功");
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			toJson.setMsg("失败");
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		}
	}
	/**
	 * 根据详情删除新闻
	 */
	@RequestMapping(value = "/queryNews",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String queryNews(@RequestParam("newsId") Integer newsId){
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("newsId", newsId);
		ToJson<News> toJson=new ToJson<News>(0, "");
		String name="wangyun";
		loger.debug("传过来的ID"+newsId);
	try {
			News news=newService.queryById(maps, 1, 5, false, name);
			toJson.setMsg("成功");
			toJson.setObject(news);
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			toJson.setMsg("失败");
			loger.debug("ERROR:"+e);
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		}
	}
	
	
	/**
	 * 为null时转换为""
	 * 
	 * @param value
	 * @return
	 */
	public static String returnValue(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}
	
	

}
