package com.xoa.service.file.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.file.FileContentMapper;
import com.xoa.model.file.FileContentModel;
import com.xoa.service.file.FileContentService;
@Service
public class FileContentServiceImpl implements FileContentService{
	@Resource
	FileContentMapper file_ContentMapper;
	@Override
	public int deleteBySortId(int sort_id) {
		return file_ContentMapper.deleteBySort_id(sort_id);
	}
	@Override
	public List<FileContentModel> getFileConBySortid(int tempNo) {
		// TODO Auto-generated method stub
		return file_ContentMapper.getFileConBySortid(tempNo);
	}
}
