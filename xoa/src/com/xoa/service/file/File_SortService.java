package com.xoa.service.file;

import java.util.List;

import com.xoa.model.file.File_Sort;
import com.xoa.util.ToJson;

public interface File_SortService {

	ToJson<File_Sort> getFile_Sort();

	List<File_Sort> getFile_Sorts();

}
