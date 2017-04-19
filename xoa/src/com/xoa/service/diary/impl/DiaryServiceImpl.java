package com.xoa.service.diary.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.diary.DiaryModelMapper;
import com.xoa.model.diary.DiaryModel;
import com.xoa.service.diary.DiaryService;
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
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 下午3:10:17
     * 方法介绍:   工作日志添加操作
     * 参数说明:   @param diaryModel
     * 参数说明:   @return
     * @return     int
     */
	@Override
	public int addDiary(DiaryModel diaryModel) {
		diaryModelMapper.addDiary(diaryModel);
		return 0;
	}
	
	
}
