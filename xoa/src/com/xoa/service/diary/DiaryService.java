package com.xoa.service.diary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xoa.model.diary.DiaryModel;
import com.xoa.util.ToJson;
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
   /**
    * 
    * 创建作者:   杨 胜
    * 创建日期:   2017-4-19 下午3:39:29
    * 方法介绍:   工作日志编辑操作
    * 参数说明:   @param diaryModel
    * 参数说明:   @return
    * @return     int
    */
	int updateDiary(DiaryModel diaryModel);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午4:41:51
	 * 方法介绍:   工作日志首页接口
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return     List<DiaryModel>
	 */
	ToJson<DiaryModel> getDiaryIndex(DiaryModel diaryModel);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午6:58:23
	 * 方法介绍:   取得全部共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel>
	 */
	ToJson<DiaryModel> getDiaryAll(DiaryModel diaryModel);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午7:36:19
	 * 方法介绍:   取得他人共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return     ToJson<DiaryModel>
	 */
	ToJson<DiaryModel> getDiaryOther(DiaryModel diaryModel);
}
