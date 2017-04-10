package com.xoa.service.file;

import com.xoa.util.dataSource.DynDatasource;

public interface File_ContentService {
	@DynDatasource
	int fileContentDeleBySort_id(int sort_id);
}
