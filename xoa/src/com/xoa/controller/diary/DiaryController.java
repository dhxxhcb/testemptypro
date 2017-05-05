package com.xoa.controller.diary;



import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.controller.file.FileController;
import com.xoa.model.diary.DiaryModel;
import com.xoa.service.diary.DiaryService;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.page.PageParams;
import com.xoa.util.treeUtil.HtmlUtil;

@Controller
@RequestMapping("/diary")
public class DiaryController {
	private Logger loger = Logger.getLogger(DiaryController.class);
	@Resource
	DiaryService diaryService;
	
	  
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-24 下午2:39:25
	 * 方法介绍:   跳转主页面
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping("/index")
	public String diaryIndex(DiaryModel diaryModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return "app/diary/index";
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:00:13
	 * 方法介绍:   工作日志添加控制层
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   String  返回数据库操作影响行
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/save")
	@ResponseBody
	public ToJson<DiaryModel> diaryAdd(DiaryModel diaryModel,HttpServletRequest request) throws UnsupportedEncodingException {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		L.a("日志详情"+diaryModel.getContent());
		L.a("日志详情"+diaryModel.getSubject());
		/*String string=new String(diaryModel.getContent().getBytes("ISO-8859-1"),"GBK");
		String stringSubject=new String(diaryModel.getSubject().getBytes("ISO-8859-1"),"GBK");
		diaryModel.setContent(string);
		diaryModel.setSubject(stringSubject);*/
		int temp=diaryService.saveDiary(diaryModel);
		 ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0,temp+"");
		return diaryListToJson;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:01:13
	 * 方法介绍:   工作日志编辑操作
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   String  返回数据库操作影响行
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ToJson<DiaryModel> diaryUpdate(DiaryModel diaryModel,HttpServletRequest request) throws UnsupportedEncodingException {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		L.a("日志详情"+diaryModel.getContent());
		L.a("日志详情"+diaryModel.getSubject());
	   /* String string=new String(diaryModel.getContent().getBytes("ISO-8859-1"),"GBK");
		String stringSubject=new String(diaryModel.getSubject().getBytes("ISO-8859-1"),"GBK");
		diaryModel.setContent(string);
		diaryModel.setSubject(stringSubject);*/
		int temp=diaryService.updateDiary(diaryModel);
		 ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0,temp+"");
		return diaryListToJson;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:34:11
	 * 方法介绍:   动态查询日志操作
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   getAll
	 */
	@RequestMapping(value="/getIndex", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ToJson<DiaryModel>  diaryGet(DiaryModel diaryModel,HttpServletRequest request, 
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		System.out.println("----------getIndex-------------"+useFlag+"----------"+useFlag);
		 PageParams pageParams = new PageParams();  
	        pageParams.setUseFlag(useFlag);  
	        pageParams.setPage(page);  
	        pageParams.setPageSize(pageSize);
		if(diaryModel.getUserId()==null){
			HttpSession	session=request.getSession();
			diaryModel.setUserId(session.getAttribute("userId").toString());
		}
		ToJson<DiaryModel> diaryToJson=diaryService.getDiaryIndex(diaryModel,pageParams);
		return diaryToJson;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 上午9:16:19
	 * 方法介绍:   取得全部共享
	 * 参数说明:   @param diaryModel
	 * @return   void
	 */
	@RequestMapping("/getAll")
	public ToJson<DiaryModel>  diaryGetAll(DiaryModel diaryModel,HttpServletResponse response,HttpServletRequest request,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		  PageParams pageParams = new PageParams();  
	        pageParams.setUseFlag(useFlag);  
	        pageParams.setPage(page);  
	        pageParams.setPageSize(pageSize);
		if(diaryModel.getUserId()==null){
			HttpSession	session=request.getSession();
			diaryModel.setUserId(session.getAttribute("userId").toString());
		}
		ToJson<DiaryModel> diaryToJson=diaryService.getDiaryAll(diaryModel,pageParams);
		return diaryToJson;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-24 下午2:38:34
	 * 方法介绍:   取得他人共享
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @param response
	 * 参数说明:   @return
	 * @return     String
	 */
	@RequestMapping(value="/getOther", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ToJson<DiaryModel>  diaryGetOther(DiaryModel diaryModel,HttpServletRequest request,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("useFlag") Boolean useFlag) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		    PageParams pageParams = new PageParams();  
	        pageParams.setUseFlag(useFlag);  
	        pageParams.setPage(page);  
	        pageParams.setPageSize(pageSize);
		
		if(diaryModel.getUserId()==null){
			HttpSession	session=request.getSession();
			diaryModel.setUserId(session.getAttribute("userId").toString());
		}
		ToJson<DiaryModel> diaryOtherToJson = diaryService.getDiaryOther(diaryModel,pageParams);
		return diaryOtherToJson;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-3 下午2:12:36
	 * 方法介绍:   通过id获取详情
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @param request
	 * 参数说明:   @return
	 * @return     ToJson<DiaryModel>
	 */
	@RequestMapping(value="/getConByDiaId", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ToJson<DiaryModel>  diaryGetOther(DiaryModel diaryModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		if(diaryModel.getUserId()==null || "".equals(diaryModel.getUserId())){
			HttpSession	session=request.getSession();
			diaryModel.setUserId(session.getAttribute("userId").toString());
		 }
		ToJson<DiaryModel> diaryOtherToJson = diaryService.getDiaryByDiaId(diaryModel);
		return diaryOtherToJson;
	}
	@RequestMapping(value="/delete", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ToJson<DiaryModel>  deletDiaById(DiaryModel diaryModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<DiaryModel> diaryResult= new ToJson<DiaryModel>();
		if(diaryModel.getDiaId()==null||"".equals(diaryModel.getDiaId())){
		 diaryResult.setMsg("删除失败");
		 return  diaryResult;
		}
		int i=diaryService.deletDiaById(diaryModel);
		if(i==0){
			diaryResult.setMsg("无该条记录");
			return diaryResult;
		}
		diaryResult.setFlag(0);
		diaryResult.setMsg(i+"");
		return diaryResult;
	}
}
