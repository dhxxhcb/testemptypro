package com.xoa.service.diary.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.diary.DiaryModelMapper;
import com.xoa.model.diary.DiaryModel;
import com.xoa.service.diary.DiaryService;
import com.xoa.util.ToJson;
/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午9:23:32
 * 类介绍  :    工作日志
 * 构造参数:   
 *
 */
@Service
public class DiaryServiceImpl implements DiaryService{
	
	@Resource
	DiaryModelMapper diaryModelMapper;
    
	
	/**
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:41:51
	 * 方法介绍:   工作日志首页接口
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel>
	 */
	public ToJson<DiaryModel> getDiaryIndex(DiaryModel diaryModel) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       //用户Id
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("toAll", "0");
	       //我的日志 
		   List<DiaryModel> diaryList=diaryModelMapper.getDiarySelf(diaryMap);
		   //取得共享日志数量
		   int diaryCount=diaryModelMapper.getDiaryCount();
		   Map<String, Object> tempNo=new  HashMap<String, Object>();
	       //用户Id
		   tempNo.put("userId", diaryModel.getUserId());
		   tempNo.put("toAll", "0");
		   int  sharListSelf=diaryModelMapper.getDiarySelfLess(tempNo);
		   
		   ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0, diaryCount+","+diaryList.size()+","+(diaryCount-sharListSelf));
		   diaryListToJson.setObj(diaryList);
		   return diaryListToJson;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午6:58:23
	 * 方法介绍:   取得全部共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel>
	 */
	public ToJson<DiaryModel> getDiaryAll(DiaryModel diaryModel) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
		   List<DiaryModel> diaryAllList=diaryModelMapper.getDiaryList(diaryMap);
		   ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0, "");
		   diaryListToJson.setObj(diaryAllList);
		   return diaryListToJson;
	}
	 
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午6:58:23
	 * 方法介绍:   取得他人共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel>
	 */
	public ToJson<DiaryModel> getDiaryOther(DiaryModel diaryModel) {
	       Map<String, Object> diaryMap=new  HashMap<String, Object>();
	       diaryMap.put("userId", diaryModel.getUserId());
	       diaryMap.put("toAll", "0");
	       //我的日志 
		   List<DiaryModel> diaryList=diaryModelMapper.getDiaryList(diaryMap);
		   ToJson<DiaryModel> diaryListToJson=new ToJson<DiaryModel>(0, "");
		   return diaryListToJson;
	}
	/**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 下午3:10:17
     * 方法介绍:   工作日志添加操作
     * 参数说明:   @param diaryModel
     * 参数说明:   @return
     * @return   int 添加数量影响行
     */
	public int saveDiary(DiaryModel diaryModel) {
		return diaryModelMapper.saveDiary(diaryModel);
	}
	 /**
	    * 
	    * 创建作者:   杨 胜
	    * 创建日期:   2017-4-19 下午3:39:29
	    * 方法介绍:   工作日志编辑操作
	    * 参数说明:   @param diaryModel
	    * 参数说明:   @return
	    * @return   int  修改
	    */
	public int updateDiary(DiaryModel diaryModel) {
		return diaryModelMapper.updateDiary(diaryModel);
	}
}
