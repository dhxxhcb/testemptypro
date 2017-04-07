package com.xoa.service.file;

import java.util.List;

import com.xoa.model.file.File_Sort;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

public interface File_SortService {

	@DynDatasource
	ToJson<File_Sort> getFile_Sort(File_Sort file);

	@DynDatasource
	List<File_Sort> getFile_Sorts(File_Sort file);
	
	@DynDatasource
	ToJson<File_Sort> getFile_SortBySort_id(File_Sort file);
	@DynDatasource
	int addFile_Sorts(File_Sort file);
	@DynDatasource
	int updateFile(File_Sort file);
	@DynDatasource
	int checkSort_No();
}
