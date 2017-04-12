package com.xoa.service.file;

import java.util.List;

import com.xoa.model.file.File_Content;
import com.xoa.util.dataSource.DynDatasource;

public interface File_ContentService {
	@DynDatasource
	int fileContentDeleBySort_id(int sort_id);
	@DynDatasource
	List<File_Content>   getFileConBySortid(int tempNo);
}
