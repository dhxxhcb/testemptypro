package com.xoa.service.diary;

import org.springframework.stereotype.Service;

import com.xoa.model.diary.DiaryModel;
/**
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午9:21:03
 * 类介绍  :   日志操作接口
 * 构造参数:  默认
 */
@Service
public interface DiaryService {
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 下午3:10:17
     * 方法介绍:   工作日志添加操作
     * 参数说明:   @param diaryModel
     * 参数说明:   @return
     * @return     int
     */
	int addDiary(DiaryModel diaryModel);
}
