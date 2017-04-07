package com.xoa.service.file.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.file.File_SortMapper;
import com.xoa.model.file.File_Sort;
import com.xoa.model.menu.SysMenu;
import com.xoa.service.file.File_SortService;
import com.xoa.util.ToJson;
@Service
public class File_SortImpl  implements File_SortService{
	@Resource
	File_SortMapper file_SortMapper;
	@Override
	public ToJson<File_Sort> getFile_Sort(File_Sort file) {
		ToJson<File_Sort> toJson = new ToJson<File_Sort>(0,"显示结果");
		List<File_Sort> list=file_SortMapper.getFile_Sort(file);
		toJson.setObj(list);
		return toJson;
	
	}
	@Override
	public List<File_Sort> getFile_Sorts(File_Sort file) {
		return file_SortMapper.getFile_Sort(file);
	}
	@Override
	public ToJson<File_Sort> getFile_SortBySort_id(File_Sort file) {
		ToJson<File_Sort> toJson = new ToJson<File_Sort>(0,"显示结果");
		List<File_Sort> list=file_SortMapper.getFile_Sort(file);
		toJson.setObj(list);
		return toJson;
	}
	@Override
	public int addFile_Sorts(File_Sort file) {
		return file_SortMapper.addFile_Sorts();
	}
	@Override
	public int updateFile(File_Sort file) {
		return file_SortMapper.updateFile_Sorts();
	}
	@Override
	public int checkSort_No() {
		return file_SortMapper.checkSort_No();
	}
	
}
