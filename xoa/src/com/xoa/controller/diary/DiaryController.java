package com.xoa.controller.diary;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xoa.model.diary.DiaryModel;
import com.xoa.service.diary.DiaryService;
import com.xoa.util.ToJson;

@Controller
@RequestMapping("/diary_")
public class DiaryController {
	@Resource
	DiaryService diaryService;
	/**
	 * 
	 * 创建作者:  朱振宇
	 * 创建日期:  2017-4-24 下午7:27:20
	 * 方法介绍:  主页面
	 * 参数说明:  @return
	 * @return    String
	 */
	@RequestMapping("/index")
	public String clickNews() {
		return "/app/diary/index";
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
	public String diaryAdd(DiaryModel diaryModel){
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
	public String diaryUpdate(DiaryModel diaryModel){
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
	@RequestMapping("/getIndex")
	@ResponseBody
	public String diaryGet(DiaryModel diaryModel){
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
	@ResponseBody
	public String  diaryGetAll(DiaryModel diaryModel){
		ToJson<DiaryModel> diaryAllToJson=diaryService.getDiaryAll(diaryModel);
		return JSON.toJSONStringWithDateFormat(diaryAllToJson,"yyyy-MM-dd HH:mm:ss");
	}
	
}
