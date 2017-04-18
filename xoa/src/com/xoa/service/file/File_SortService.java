package com.xoa.service.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.File_Sort;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

public interface File_SortService {
	/**
	 * 动态查询返回json数据
	 * @author 杨  胜
	 * @param file 
	 */
	@DynDatasource
	ToJson<File_Sort> getFile_Sort(File_Sort file);
	/**
	 * 动态查询返回<File_Sort> list数组
	 * @author 杨  胜
	 * @param file 
	 */
	@DynDatasource
	List<File_Sort> getFile_Sorts(File_Sort file);
	/**
	 * 动态查询  File_Sort
	 * @author 杨  胜
	 * @param file 
	 * @return  返回 树形父节点<File_Sort> list数组
	 */
	@DynDatasource
	ToJson<File_Sort> getFile_SortBySort_id(File_Sort file);
	/**
	 * 添加目录树文件夹
	 * @author 杨  胜
	 * @param file 
	 * @return 返回目录树影响行
	 */
	@DynDatasource
	int addFile_Sorts(File_Sort file);
	/**
	 * 修改目录树文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回目录树修改影响行
	 */
	@DynDatasource
	int updateFile(File_Sort file);
	/**
	 * 删除目录树文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回目录树删除影响行
	 */
	@DynDatasource
	int fileDeleteBySort_id(Map<String, Object> fileParent);
	/**
	 * 根据某个父节点信息获取目录树子文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回子目录树List集合
	 */
	@DynDatasource
	List<File_Sort> getSortChrildren(int tempNo);
	/**
	 * 获取目录树父文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回父目录树List集合
	 */
	@DynDatasource
	List<File_Sort> getRootTree(int sortid);
	/**
	 * 获取所有子文件夹信息
	 * @author 杨  胜
	 * @param file 
	 * @return 返回所有子目录树List集合
	 */
	@DynDatasource
	List<File_Sort> getChildTree(int sortid);
}
