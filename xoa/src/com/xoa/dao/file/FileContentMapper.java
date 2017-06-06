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

    List<FileContentModel> queryBySearchValue(@Param("sortId") Integer sortId,
											  @Param("subjectName")String subjectName,
											  @Param("creater")String creater,
											  @Param("contentNo")Integer contentNo,
											  @Param("contentValue1")String contentValue1,
											  @Param("contentValue2")String contentValue2,
											  @Param("contentValue3")String contentValue3,
											  @Param("atiachmentDesc")String atiachmentDesc,
											  @Param("atiachmentName")String atiachmentName,
											  @Param("atiachmentCont")String atiachmentCont,
											  @Param("crStartDate")String crStartDate,
											  @Param("crEndDate")String crEndDate,
											  @Param("pageNo")Integer pageNo,
											  @Param("pageSize")Integer pageSize);
			;
}
