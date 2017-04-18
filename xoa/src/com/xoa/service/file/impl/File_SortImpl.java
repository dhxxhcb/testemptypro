package com.xoa.service.file.impl;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 动态查询返回json数据
	 * @author 杨  胜
	 * @param file 
	 */
	@Override
	public ToJson<File_Sort> getFile_Sort(File_Sort file) {
		ToJson<File_Sort> toJson = new ToJson<File_Sort>(0,"显示结果");
		List<File_Sort> list=file_SortMapper.getFile_Sort(file);
		toJson.setObj(list);
		return toJson;
	
	}
	/**
	 * 动态查询返回<File_Sort> list数组
	 * @author 杨  胜
	 * @param file 
	 */
	@Override
	public List<File_Sort> getFile_Sorts(File_Sort file) {
		return file_SortMapper.getFile_Sort(file);
	}
	/**
	 * 动态查询  File_Sort
	 * @author 杨  胜
	 * @param file 
	 * @return  返回 树形父节点<File_Sort> list数组
	 */
	@Override
	public ToJson<File_Sort> getFile_SortBySort_id(File_Sort file) {
		ToJson<File_Sort> toJson = new ToJson<File_Sort>(0,"显示结果");
		List<File_Sort> list=file_SortMapper.getFile_Sort(file);
		toJson.setObj(list);
		return toJson;
	}
	
	/**
	 * 添加目录树文件夹
	 * @author 杨  胜
	 * @param file 
	 * @return 返回目录树影响行
	 */
	@Override
	public int addFile_Sorts(File_Sort file) {
		return file_SortMapper.addFile_Sorts(file);
	}
	/**
	 * 修改目录树文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回目录树修改影响行
	 */
	@Override
	public int updateFile(File_Sort file) {
		return file_SortMapper.updateFile_Sorts(file);
	}
	/**
	 * 删除目录树文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回目录树删除影响行
	 */
	@Override
	public int fileDeleteBySort_id(Map<String, Object> fileParent) {
		return  file_SortMapper.fileDeleteBySort_id(fileParent);
	}
	/**
	 * 根据某个父节点信息获取目录树子文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回子目录树List集合
	 */
	@Override
	public List<File_Sort> getSortChrildren(int tempNo) {
		return file_SortMapper.getSortChrildren(tempNo);
	}
	
	/**
	 * 获取目录树父文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回父目录树List集合
	 */
	@Override
	public List<File_Sort> getRootTree(int sortid) {
		return file_SortMapper.getRootTree(sortid);
	}
	/**
	 * 获取所有子文件夹信息 
	 * @author 杨  胜
	 * @param file 
	 * @return 返回所有子目录树List集合
	 */
	@Override
	public List<File_Sort> getChildTree(int sortid) {
		return file_SortMapper.getChildTree(sortid);
	}
	
}
