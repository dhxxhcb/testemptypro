package com.xoa.service.file;

import java.util.List;

import com.xoa.model.file.File_Sort;
import com.xoa.util.ToJson;

public interface File_SortService {

	ToJson<File_Sort> getFile_Sort(File_Sort file);

	List<File_Sort> getFile_Sorts(File_Sort file);
	
	ToJson<File_Sort> getFile_SortBySort_id(File_Sort file);
}
