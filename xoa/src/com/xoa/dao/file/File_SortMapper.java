package com.xoa.dao.file;

import java.util.List;

import com.xoa.model.file.File_Sort;

public interface File_SortMapper {

	List<File_Sort> getFile_Sort(File_Sort file);

	int addFile_Sorts();

	int updateFile_Sorts();

	int checkSort_No();
}
