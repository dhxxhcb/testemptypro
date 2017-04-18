package com.xoa.service.file.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.file.File_ContentMapper;
import com.xoa.model.file.File_Content;
import com.xoa.service.file.File_ContentService;
@Service
public class File_ContentImpl implements File_ContentService{
	@Resource
	File_ContentMapper file_ContentMapper;
	@Override
	public int fileContentDeleBySort_id(int sort_id) {
		return file_ContentMapper.fileContentDeleBySort_id(sort_id);
	}
	@Override
	public List<File_Content> getFileConBySortid(int tempNo) {
		// TODO Auto-generated method stub
		return file_ContentMapper.getFileConBySortid(tempNo);
	}
}
