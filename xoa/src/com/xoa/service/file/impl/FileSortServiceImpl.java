package com.xoa.service.file.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.file.FileSortMapper;
import com.xoa.model.file.FileSortModel;
import com.xoa.service.file.FileSortService;
import com.xoa.util.ToJson;

/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午9:24:55
 * 类介绍  :    文件柜service实现类
 * 构造参数:   默认
 *
 */
@Service
public class FileSortServiceImpl  implements FileSortService{
	@Resource
	FileSortMapper file_SortMapper;
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:30:51
	 * 方法介绍:   动态查询File_Sort返回json数据
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   ToJson<FileSortModel>
	 */
	public ToJson<FileSortModel> getFileSortJson(FileSortModel file) {
		ToJson<FileSortModel> toJson = new ToJson<FileSortModel>(0,"显示结果");
		List<FileSortModel> list=file_SortMapper.getFileSort(file);
		toJson.setObj(list);
		return toJson;
	
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:07
	 * 方法介绍:   动态查询 File_Sort返回<FileSortModel> list数组
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getFileSortList(FileSortModel file) {
		return file_SortMapper.getFileSort(file);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:20
	 * 方法介绍:   动态查询  File_Sort
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     ToJson<FileSortModel>
	 */
	@Override
	public ToJson<FileSortModel> getFileSortBySortId(FileSortModel file) {
		ToJson<FileSortModel> toJson = new ToJson<FileSortModel>(0,"显示结果");
		List<FileSortModel> list=file_SortMapper.getFileSort(file);
		toJson.setObj(list);
		return toJson;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:34
	 * 方法介绍:   添加目录树文件夹
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     int
	 */
	@Override
	public int saveFileSort(FileSortModel file) {
		return file_SortMapper.saveFileSort(file);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:15
	 * 方法介绍:   修改目录树文件夹信息
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     int
	 */
	@Override
	public int updateFileSort(FileSortModel file) {
		return file_SortMapper.updateFileSort(file);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:26
	 * 方法介绍:   删除目录树文件夹信息
	 * 参数说明:   @param fileParent
	 * 参数说明:   @return
	 * @return     int
	 */
	@Override
	public int deleteBySortId(Map<String, Object> fileParent) {
		return  file_SortMapper.deleteBySortId(fileParent);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:37
	 * 方法介绍:   根据某个父节点信息获取目录树子文件夹信息
	 * 参数说明:   @param tempNo
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getSortChrildren(int tempNo) {
		return file_SortMapper.getSortChrildren(tempNo);
	}
	
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:50
	 * 方法介绍:   获取目录树父文件夹信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return   List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getRootTree(int sortid) {
		return file_SortMapper.getRootTree(sortid);
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:57:07
	 * 方法介绍:   获取所有子文件夹信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getChildTree(List<String> sortidList) {
		return file_SortMapper.getChildTree(sortidList);
	}
	/**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-20 上午9:39:32
     * 方法介绍:   添加子文件夹
     * 参数说明:   @param file
     * 参数说明:   @return
     * @return   int 添加子文件夹影响行
     */
	@Override
	public int saveFileSortChr(FileSortModel file) {
		return file_SortMapper.saveFileSortChr(file);
	}
	
}
