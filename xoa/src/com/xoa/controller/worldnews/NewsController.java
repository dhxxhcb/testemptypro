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
@RequestMapping("/news")
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
	/**
	 * 新闻显示页面
	 * @return
	 */
	@RequestMapping("/clicknews")
	public String clickNews(){
		return "/app/news/newsShow";
	}
	
	
	@RequestMapping(value="/shownew",produces={"application/json;charset=UTF-8"})
	public @ResponseBody String showNew(HttpServletRequest request,HttpServletResponse response) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	     return null;
	}
	/**
	 * 获取页面条件并进行数据封装
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{  
        Integer currentPage = ServletRequestUtils.getIntParameter(request, "currentPage", 0);  
        Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);  
          
        String empNo = ServletRequestUtils.getStringParameter(request, "empNo");  
        String displayName = ServletRequestUtils.getStringParameter(request, "displayName");  
        String login = ServletRequestUtils.getStringParameter(request, "login");  
        String deptName = ServletRequestUtils.getStringParameter(request, "deptName");  
        String userCategory = ServletRequestUtils.getStringParameter(request, "userCategory");  
//        Page<User> page = userService.showPage(empNo, login,deptName, displayName,  userCategory, currentPage, pageSize);
         loger.info("当前页："+currentPage+"\t\t 当前显示条数："+pageSize+"条件："+displayName);
        request.setAttribute("empNo", empNo);
        request.setAttribute("displayName", displayName);
        request.setAttribute("login", login);
        request.setAttribute("deptName", deptName);
        request.setAttribute("userCategory", userCategory);
//        request.setAttribute("userListDto", page.getResult());  
//        request.setAttribute("pageEntity", page);  
    }

    /**
     * 查询信息展示
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/showNews")  
    public String ajaxSearchUser(HttpServletRequest request, HttpServletResponse response) throws Exception {  
          
        doSearch(request, response);  
          
        return "/page/table";  
    }
	
	
	
	
}
