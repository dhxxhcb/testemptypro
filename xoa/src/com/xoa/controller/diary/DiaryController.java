package com.xoa.controller.diary;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.controller.file.FileController;
import com.xoa.model.diary.DiaryModel;
import com.xoa.service.diary.DiaryService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import com.xoa.util.treeUtil.HtmlUtil;

@Controller
@RequestMapping("/diary_")
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
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String diaryAdd(DiaryModel diaryModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		int temp=diaryService.saveDiary(diaryModel);
		return temp+"";
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:01:13
	 * 方法介绍:   工作日志编辑操作
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   String  返回数据库操作影响行
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String diaryUpdate(DiaryModel diaryModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		int temp=diaryService.updateDiary(diaryModel);
		return temp+"";
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
	public String diaryGet(DiaryModel diaryModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		System.out.println("-------------diaryGet------------"+diaryModel.getUserId());
		ToJson<DiaryModel> diaryToJson=diaryService.getDiaryIndex(diaryModel);
		return JSON.toJSONStringWithDateFormat(diaryToJson,"yyyy-MM-dd HH:mm:ss");
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
	public void  diaryGetAll(DiaryModel diaryModel,HttpServletResponse response,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		List<DiaryModel> diaryAllToJson=diaryService.getDiaryAll(diaryModel);
		HtmlUtil.writerJson(response, diaryAllToJson);
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
	@RequestMapping("/getOther")
	@ResponseBody
	public String  diaryGetOther(DiaryModel diaryModel,HttpServletRequest request) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<DiaryModel> diaryOtherToJson = diaryService.getDiaryOther(diaryModel);
		return JSON.toJSONStringWithDateFormat(diaryOtherToJson,"yyyy-MM-dd HH:mm:ss");
	}
}
