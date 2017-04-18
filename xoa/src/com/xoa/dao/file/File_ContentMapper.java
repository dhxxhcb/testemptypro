package com.xoa.dao.file;

import java.util.List;

import com.xoa.model.file.File_Content;

public interface File_ContentMapper {
	int fileContentDeleBySort_id(int sort_id);

	List<File_Content> getFileConBySortid(int tempNo);
}
