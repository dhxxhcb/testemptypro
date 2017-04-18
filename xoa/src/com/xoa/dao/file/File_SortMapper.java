package com.xoa.dao.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.File_Sort;

public interface File_SortMapper {

	List<File_Sort> getFile_Sort(File_Sort file);

	int addFile_Sorts(File_Sort file);

	int updateFile_Sorts(File_Sort file);

	int checkSort_No();

	int fileDeleteBySort_id(Map<String, Object> fileParent);

	List<File_Sort> getSortChrildren(int tempNo);

	List<File_Sort> getRootTree(int sortid);

	List<File_Sort> getChildTree(int sortid);
}
