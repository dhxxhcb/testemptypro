package com.xoa.service.file.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.file.FileContentMapper;
import com.xoa.model.file.FileContentModel;
import com.xoa.service.file.FileContentService;
@Service
public class FileContentServiceImpl implements FileContentService{
	@Resource
	FileContentMapper file_ContentMapper;
	
	
	public int deleteBySortId(int sort_id) {
		return file_ContentMapper.deleteBySort_id(sort_id);
	}
	
	
	public List<FileContentModel> getFileConBySortid(int tempNo) {
		List<FileContentModel>  FileContentList=file_ContentMapper.getFileConBySortid(tempNo);
		for(FileContentModel  fcm:FileContentList){
			System.out.println("--------tempbefore---"+fcm.getSendTime());
			String temp=fcm.getSendTime().substring(0, 19);
			System.out.println("--------temp---"+temp);
			fcm.setSendTime(temp);
		}
		return FileContentList;
	}


	@Override
	public FileContentModel getFileConByContentId(String contentId) {
		FileContentModel fc=file_ContentMapper.getFileConByContentId(contentId);
		String temp=fc.getSendTime().substring(0, 19);
		fc.setSendTime(temp);
		return	fc;
	}


	@Override
	public int saveContent(FileContentModel fileContentModel) {
		return file_ContentMapper.saveContent(fileContentModel);
	}


	@Override
	public int deleteByConId(Map<String, Object> fileConMap) {
		
		return file_ContentMapper.deleteByConId(fileConMap);
	}
}
