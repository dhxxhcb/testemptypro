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
	public ToJson<File_Sort> getFile_Sort() {
		ToJson<File_Sort> toJson = new ToJson<File_Sort>(0,"显示结果");
		List<File_Sort> list=file_SortMapper.getFile_Sort();
		      toJson.setObj(list);
		return toJson;
	
	}
	@Override
	public List<File_Sort> getFile_Sorts() {
		
		return file_SortMapper.getFile_Sort();
	}
	
}
