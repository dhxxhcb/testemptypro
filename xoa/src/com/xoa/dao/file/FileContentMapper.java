package com.xoa.dao.file;

import java.util.List;

import com.xoa.model.file.FileContentModel;

public interface FileContentMapper {
	int fileContentDeleBySort_id(int sort_id);

	List<FileContentModel> getFileConBySortid(int tempNo);
}
