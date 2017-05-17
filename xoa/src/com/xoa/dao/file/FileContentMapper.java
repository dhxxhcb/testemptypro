package com.xoa.dao.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.FileContentModel;

public interface FileContentMapper {
	int deleteBySort_id(int sort_id);

	List<FileContentModel> getFileConBySortid(int tempNo);

	FileContentModel getFileConByContentId(String contentId);

	int saveContent(FileContentModel fileContentModel);

	int deleteByConId(Map<String, Object> fileConMap);

	int updateFileCon(FileContentModel fcm);
}
