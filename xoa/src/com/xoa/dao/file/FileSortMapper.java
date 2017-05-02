package com.xoa.dao.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.FileSortModel;

public interface FileSortMapper {

	List<FileSortModel> getFileSort(FileSortModel file);

	int saveFileSort(FileSortModel file);

	int updateFileSort(FileSortModel file);
	
	int deleteBySortId(Map<String, Object> fileParent);

	List<FileSortModel> getSortChrildren(int tempNo);

	List<FileSortModel> getRootTree(int sortid);

	List<FileSortModel> getChildTree(List<String> sortidList);

	int saveFileSortChr(FileSortModel file);
}
