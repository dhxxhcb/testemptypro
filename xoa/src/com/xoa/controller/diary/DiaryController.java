package com.xoa.controller.diary;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:00:13
	 * 方法介绍:   工作日志添加控制层
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   String  返回数据库操作影响行
	 */
	@RequestMapping("/add")
	public String diaryAdd(DiaryModel diaryModel){
		int temp=diaryService.addDiary(diaryModel);
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
	 * @return     String
	 */
	@RequestMapping("/getIndex")
	public void diaryGet(DiaryModel diaryModel){
		ToJson<DiaryModel> diaryToJson=diaryService.getDiaryIndex(diaryModel);
	}
	
}
