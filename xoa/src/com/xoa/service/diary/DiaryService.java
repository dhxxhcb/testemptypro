package com.xoa.service.diary;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xoa.model.diary.DiaryModel;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;
import com.xoa.util.page.PageParams;
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
	@DynDatasource
	int saveDiary(DiaryModel diaryModel);
   /**
    * 
    * 创建作者:   杨 胜
    * 创建日期:   2017-4-19 下午3:39:29
    * 方法介绍:   工作日志编辑操作
    * 参数说明:   @param diaryModel
    * 参数说明:   @return
    * @return   int
    */
	@DynDatasource
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
	@DynDatasource
	ToJson<DiaryModel> getDiaryIndex(DiaryModel diaryModel,PageParams pageParams );
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午6:58:23
	 * 方法介绍:   取得全部共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return   ToJson<DiaryModel>
	 */
	@DynDatasource
	ToJson<DiaryModel> getDiaryAll(DiaryModel diaryModel,PageParams pageParams );
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 下午7:36:19
	 * 方法介绍:   取得他人共享日志
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return     ToJson<DiaryModel>
	 */
	@DynDatasource
	ToJson<DiaryModel> getDiaryOther(DiaryModel diaryModel,PageParams pageParams);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-3 下午2:13:55
	 * 方法介绍:    通过id获取详情
	 * 参数说明:   @param diaryModel
	 * 参数说明:   @return
	 * @return     ToJson<DiaryModel>
	 */
	@DynDatasource
	ToJson<DiaryModel> getDiaryByDiaId(DiaryModel diaryModel);
}
