package com.xoa.service.file.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.common.wrapper.BaseWrappers;
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


	@Override
	public int updateFileCon(FileContentModel fcm) {
		return file_ContentMapper.updateFileCon(fcm);
	}

	@Override
	public BaseWrapper batchDeleteConId(Integer[] conId) {
		BaseWrapper wrapper =new BaseWrapper();
		if(conId==null||conId.length<1){
			wrapper.setMsg("无效的请求参数");
			wrapper.setStatus(true);
			wrapper.setFlag(false);
			return wrapper;
		}
		int res = file_ContentMapper.batchDeleteConId(conId);
    if(res>0){
		wrapper.setMsg("请求成功");
		wrapper.setStatus(true);
		wrapper.setFlag(true);

	}else{
		wrapper.setMsg("操作失败");
		wrapper.setStatus(true);
		wrapper.setFlag(false);
	}
		return wrapper;
	}

	@Override
	public BaseWrappers queryBySearchValue(Integer sortId, String subjectName, String[] creater, Integer contentNo, String contentValue1, String contentValue2, String contentValue3, String atiachmentDesc, String atiachmentName, String atiachmentCont, String crStartDate, String crEndDate,Integer pageNo,Integer pageSize) {
		BaseWrappers wrappers =new BaseWrappers();
		wrappers.setFlag(false);
		wrappers.setStatus(true);
		if(pageNo==null){
			pageNo=0;
		}
		StringBuffer createrArray=null;
		String createrArrayStr=null;
		if(creater!=null){
			createrArray =new StringBuffer();
			for(String value:creater){
				createrArray.append(value);
				createrArray.append(",");
			}
			createrArrayStr=createrArray.toString();

		}
		List<FileContentModel> datas =file_ContentMapper.queryBySearchValue(sortId,subjectName,createrArrayStr,contentNo,contentValue1,contentValue2,contentValue3,atiachmentDesc,atiachmentName,atiachmentCont,crStartDate,crEndDate,pageNo,pageSize);
		if(datas.size()>0){
			wrappers.setDatas(datas);
			wrappers.setFlag(true);
			wrappers.setMsg("获取数据成功");
		}else{
			wrappers.setFlag(false);
			wrappers.setMsg("查询无结果");
		}
		return wrappers;
	}


}
