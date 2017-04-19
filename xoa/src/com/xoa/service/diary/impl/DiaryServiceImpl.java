package com.xoa.service.diary.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.diary.DiaryModelMapper;
import com.xoa.service.diary.DiaryService;
/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午9:23:32
 * 类介绍  :    
 * 构造参数:   
 *
 */
@Service
public class DiaryServiceImpl implements DiaryService{
	
	@Resource
	DiaryModelMapper diaryModelMapper;
}
