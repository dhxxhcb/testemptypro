package com.xoa.controller.news;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.worldnews.News;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.dataSource.ContextHolder;

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
/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:51:46
 * 类介绍  :    新闻控制器
 * 构造参数:    无
 *
 */
public class NewsController {
	private Logger loger = Logger.getLogger(NewsController.class);
	@Resource
	private NewService newService;
	private	String err="err";
	private	String  ok="ok";
	

	/**
	 * 新闻显示页面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String clickNews(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "/app/news/center";
	}
	/**
	 * 
	 * 创建作者:  朱振宇
	 * 创建日期:  2017-4-25 上午9:36:04
	 * 方法介绍:  新闻详情页面
	 * 参数说明:  @return
	 * @return    String
	 */
	@RequestMapping("/detail")
	public String News(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "/app/news/newsDetail";
	}
	/**
	 * 
	 * 创建作者:  朱振宇
	 * 创建日期:  2017-4-25 上午9:36:22
	 * 方法介绍:  新闻管理页面
	 * 参数说明:  @return
	 * @return    String
	 */
	@RequestMapping("/manage")
	public String sendNews(HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "/app/news/newsManage";
	}
	
	
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:51:58
	 * 方法介绍:   新闻管理信息展示 返回json 
	 * 参数说明:   @return
	 * @return     String 返回新闻管理列表
	 */
@RequestMapping(value = "/showNewsManage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
  public @ResponseBody ToJson<News> selectNewsManage(
			@RequestParam(value = "format", required = false) String format,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "top", required = false) String top,
			@RequestParam(value = "publish", required = false) String publish,
			@RequestParam(value = "clickCount", required = false) String clickCount,
			@RequestParam(value = "click", required = false) String click,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "newsTime", required = false) String newsTime,
			@RequestParam(value = "lastEditTime", required = false) String lastEditTime,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag,
			HttpServletRequest request, HttpServletResponse response){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("format", format);
		   if (typeId.equals("0")) {
		        typeId=null;
	     }else {
	    	 maps.put("typeId", typeId);
		}
		maps.put("top", top);
		maps.put("publish", publish);
		maps.put("clickCount", clickCount);
		maps.put("click", click);
		maps.put("subject", subject);
		maps.put("newsTime", newsTime);
		maps.put("lastEditTime", lastEditTime);
		maps.put("content", content);
		ToJson<News> returnReslt = new ToJson(1,"");
		try {
			ToJson<News> tojson =newService.selectNewsManage(maps, 1, 5, true);
			if (tojson.getObj().size() > 0) {
				tojson.setMsg(ok);
				returnReslt = tojson;
			} else {
				returnReslt = tojson;
			}
		} catch (Exception e) {
			loger.debug("NewsMessage:" + e);
		}

		return returnReslt;
	}
/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:53:28
 * 方法介绍:   新闻信息展示
 * 参数说明:   @param format
 * 参数说明:   @param typeId
 * 参数说明:   @param subject
 * 参数说明:   @param newsTime
 * 参数说明:   @param lastEditTime
 * 参数说明:   @param keyword
 * 参数说明:   @param page
 * 参数说明:   @param pageSize
 * 参数说明:   @param useFlag
 * 参数说明:   @return
 * @return     String
 */
	@RequestMapping(value = "/newsShow", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	ToJson showNews(
			@RequestParam(value = "format", required = false) String format,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "top", required = false) String top,
			@RequestParam(value = "publish", required = false) String publish,
			@RequestParam(value = "clickCount", required = false) String clickCount,
			@RequestParam(value = "click", required = false) String click,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "newsTime", required = false) String newsTime,
			@RequestParam(value = "nTime", required = false) String nTime,
			@RequestParam(value = "lastEditTime", required = false) String lastEditTime,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value ="read", required = false) String read,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag,
			HttpServletRequest request, HttpServletResponse response) {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		if ("0".equals(typeId)) {
			typeId=null;
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("format", format);
		maps.put("typeId", typeId);
		maps.put("subject", subject);
		maps.put("newsTime", newsTime);
		maps.put("nTime", nTime);
		maps.put("lastEditTime", lastEditTime);
		maps.put("content", content);
		maps.put("top", top);
		maps.put("publish", publish);
		maps.put("clickCount", clickCount);
		maps.put("click", click);
		
		String name = "wwwwww";
		ToJson<News> returnReslt = new ToJson(1,"");
		try {
			 if (read.equals("0")) {
				ToJson<News> tojson= newService.unreadNews(maps, page, pageSize,
						useFlag, name);
				if (tojson.getObj().size() > 0) {
					tojson.setMsg(ok);
					returnReslt = tojson;
				} else {
					returnReslt = tojson;
				}
			}else if (read.equals("1")) {//已读
				ToJson<News> tojson= newService.readNews(maps, page, pageSize,
						useFlag, name);
				if (tojson.getObj().size() > 0) {
					tojson.setMsg(ok);
					returnReslt = tojson;
				} else {
					returnReslt = tojson;
				}
			}
				else 
				{
				ToJson<News> tojson= newService.selectNews(maps, page, pageSize,useFlag, name);
				if (tojson.getObj().size() > 0) {
					tojson.setMsg(ok);
					returnReslt =tojson;
				} else {
					returnReslt = tojson;
				}
			}
		} catch (Exception e) {
			loger.debug("NewsMessage:" + e);
		}

		return returnReslt;
	}

	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:54:11
	 * 方法介绍:   未读信息展示
	 * 参数说明:   @param request
	 * 参数说明:   @param response
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/unreadShow", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	String unreadNews(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		Map<String, Object> maps = new HashMap<String, Object>();
		String name = (String) request.getSession().getAttribute("byname");
		String returnReslt = null;
		try {
			ToJson<News> tojson= newService.unreadNews(maps, page, pageSize,
					useFlag, name);
			if (tojson.getObj().size() > 0) {
				tojson.setMsg(ok);
				returnReslt = JSON.toJSONStringWithDateFormat(tojson,
						"yyyy-MM-dd HH:mm:ss");
			} else {
				returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<News>(
						1, err), "yyyy-MM-dd HH:mm:ss");
			}
		} catch (Exception e) {
			loger.debug("NewsMessage:" + e);
			returnReslt = JSON.toJSONStringWithDateFormat(new ToJson<News>(1,
					""), "yyyy-MM-dd HH:mm:ss");
		}

		return returnReslt;
	}

	
	 /**
	  * 
	  * 创建作者:   王曰岐
	  * 创建日期:   2017-4-19 下午3:54:51
	  * 方法介绍:   添加新闻
	  * 参数说明:   @param subject
	  * 参数说明:   @param provider
	  * 参数说明:   @param newsTime
	  * 参数说明:   @param clickCount
	  * 参数说明:   @param anonymityYn
	  * 参数说明:   @param format
	  * 参数说明:   @param typeId
	  * 参数说明:   @param publish
	  * 参数说明:   @param top
	  * 参数说明:   @param lastEditor
	  * 参数说明:   @param lastEditTime
	  * 参数说明:   @param subjectColor
	  * 参数说明:   @param keyword
	  * 参数说明:   @param topDays
	  * 参数说明:   @param content
	  * 参数说明:   @param attachmentId
	  * 参数说明:   @param attachmentName
	  * 参数说明:   @param toId
	  * 参数说明:   @param privId
	  * 参数说明:   @param userId
	  * 参数说明:   @param readers
	  * 参数说明:   @param compressContent
	  * 参数说明:   @param summary
	  * 参数说明:   @return
	  * @return     String
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
			@RequestParam("summary") String summary,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
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
						new ToJson<News>(0, ok), "yyyy-MM-dd HH:mm:ss");
			} catch (Exception e) {
				loger.debug("sendNews:" + e);
				return JSON.toJSONStringWithDateFormat(
						new ToJson<News>(1, err), "yyyy-MM-dd HH:mm:ss");
			}

		}
	
	 /**
	  * 
	  * 创建作者:   王曰岐
	  * 创建日期:   2017-4-19 下午3:55:20
	  * 方法介绍:   修改新闻
	  * 参数说明:   @param newsId
	  * 参数说明:   @param subject
	  * 参数说明:   @param provider
	  * 参数说明:   @param newsTime
	  * 参数说明:   @param clickCount
	  * 参数说明:   @param anonymityYn
	  * 参数说明:   @param format
	  * 参数说明:   @param typeId
	  * 参数说明:   @param publish
	  * 参数说明:   @param top
	  * 参数说明:   @param lastEditor
	  * 参数说明:   @param lastEditTime
	  * 参数说明:   @param subjectColor
	  * 参数说明:   @param keyword
	  * 参数说明:   @param topDays
	  * 参数说明:   @param content
	  * 参数说明:   @param attachmentId
	  * 参数说明:   @param attachmentName
	  * 参数说明:   @param toId
	  * 参数说明:   @param privId
	  * 参数说明:   @param userId
	  * 参数说明:   @param readers
	  * 参数说明:   @param compressContent
	  * 参数说明:   @param summary
	  * 参数说明:   @return
	  * @return     String
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
			@RequestParam("summary") String summary,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
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
						new ToJson<EmailBodyModel>(0, ok), "yyyy-MM-dd HH:mm:ss");
			} catch (Exception e) {
				loger.debug("sendNews:" + e);
				return JSON.toJSONStringWithDateFormat(
						new ToJson<EmailBodyModel>(1, err), "yyyy-MM-dd HH:mm:ss");
			}
	}
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:55:40
	 * 方法介绍:   根据ID删除新闻
	 * 参数说明:   @param newsId
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/deleteNews", produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String deleteNews(@RequestParam("newsId") Integer newsId,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<News> toJson=new ToJson<News>(0, "");
		try {
			toJson.setMsg(ok);
			newService.deleteByPrimaryKey(newsId);
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			return JSON.toJSONStringWithDateFormat(toJson,
					"yyyy-MM-dd HH:mm:ss");
		}
	}
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:56:10
	 * 方法介绍:   根据ID详情新闻
	 * 参数说明:   @param newsId
	 * 参数说明:   @param request
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value = "/getOneById",method = RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody ToJson<News> queryNews(@RequestParam("newsId") Integer newsId,HttpServletRequest request){
			ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
					"loginDateSouse"));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("newsId", newsId);
		ToJson<News> toJson=new ToJson<News>(0, "");
		String name =(String) request.getSession().getAttribute("byname");
	try {
			News news=newService.queryById(maps, 1, 5, false, name);
			toJson.setMsg(ok);
			toJson.setObject(news);
			return toJson;
		} catch (Exception e) {
			toJson.setMsg(err);
			loger.debug("ERROR:"+e);
			return toJson;
		}
	}
	
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:56:32
	 * 方法介绍:   为null时转换为""
	 * 参数说明:   @param value
	 * 参数说明:   @return
	 * @return     String
	 */
	public static String returnValue(String value) {
		if (value != null) {
			return value;
		} else {
			return "";
		}
	}
	
	

}
