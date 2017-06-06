package com.xoa.service.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.FileContentModel;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.common.wrapper.BaseWrappers;

public interface FileContentService {
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-5 上午11:18:51
	 * 方法介绍:   通过SortId删除一条文件
	 * 参数说明:   @param sort_id
	 * 参数说明:   @return
	 * @return     int
	 */
    int deleteBySortId(int sort_id);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-5 上午11:21:19
	 * 方法介绍:   通过Sortid获取文件列表
	 * 参数说明:   @param tempNo
	 * 参数说明:   @return
	 * @return     List<FileContentModel>
	 */
    List<FileContentModel>   getFileConBySortid(int tempNo);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-5 上午11:21:29
	 * 方法介绍:   通过ContentId获取一条文件信息
	 * 参数说明:   @param contentId
	 * 参数说明:   @return
	 * @return     FileContentModel
	 */
    FileContentModel getFileConByContentId(String contentId);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-5 上午11:21:33
	 * 方法介绍:   保存一条文件信息
	 * 参数说明:   @param fileContentModel
	 * 参数说明:   @return
	 * @return     int  返回影响行
	 */
    int saveContent(FileContentModel fileContentModel);
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-5-5 上午11:21:33
	 * 方法介绍:   删除一条信息
	 * 参数说明:   @param fileContentModel
	 * 参数说明:   @return
	 * @return     int  返回影响行
	 */
    int deleteByConId(Map<String, Object> fileConMap);
	int updateFileCon(FileContentModel fcm);

	BaseWrapper batchDeleteConId(Integer conId[]);

    BaseWrappers queryBySearchValue(Integer sortId, String subjectName, String[] creater, Integer contentNo, String contentValue1, String contentValue2, String contentValue3, String atiachmentDesc, String atiachmentName, String atiachmentCont, String crStartDate, String crEndDate,Integer pageNo,Integer pageSize);
}
