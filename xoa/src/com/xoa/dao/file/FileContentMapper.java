package com.xoa.dao.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.FileContentModel;
import org.apache.ibatis.annotations.Param;

public interface FileContentMapper {
	int deleteBySort_id(int sort_id);

	List<FileContentModel> getFileConBySortid(int tempNo);

	FileContentModel getFileConByContentId(String contentId);

	int saveContent(FileContentModel fileContentModel);

	int deleteByConId(Map<String, Object> fileConMap);

	int updateFileCon(FileContentModel fcm);
	int batchDeleteConId(Integer conId[]);

    List<FileContentModel> queryBySearchValue(@Param("sortId") Integer sortId, String subjectName, String[] creater, Integer contentNo, String contentValue1, String contentValue2, String contentValue3, String atiachmentDesc, String atiachmentName, String atiachmentCont, String crStartDate, String crEndDate);
}
