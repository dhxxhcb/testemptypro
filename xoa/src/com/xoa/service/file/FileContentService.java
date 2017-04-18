package com.xoa.service.file;

import java.util.List;

import com.xoa.model.file.FileContentModel;
import com.xoa.util.dataSource.DynDatasource;

public interface FileContentService {
	@DynDatasource
	int deleteBySortId(int sort_id);
	@DynDatasource
	List<FileContentModel>   getFileConBySortid(int tempNo);
}
