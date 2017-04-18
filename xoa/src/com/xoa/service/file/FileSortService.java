package com.xoa.service.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.FileSortModel;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;
/**
 * 
 * @ClassName (类名):  FileSortService
 * @Description(简述): 文件柜业务层接口
 * @author(作者):      ys
 * @date(日期):        2017-4-17 下午3:55:42
 *
 */
public interface FileSortService {
	
	/**
	 * 
	 * @Title: getFile_Sort
	 * @Description: 动态查询File_Sort返回json数据
	 * @author(作者):      ys
	 * @param: @param file
	 * @param: @return   
	 * @return: ToJson<FileSortModel>   
	 * @throws
	 */
	@DynDatasource
	ToJson<FileSortModel> getFileSortJson(FileSortModel file);
	
	/**
	 * 
	 * @Title: getFile_Sorts
	 * @Description: 动态查询 File_Sort返回<FileSortModel> list数组
	 * @author(作者):      ys
	 * @param: @param file
	 * @param: @return   
	 * @return: List<FileSortModel>   
	 * @throws
	 */
	@DynDatasource
	List<FileSortModel> getFileSortList(FileSortModel file);
	/**
	 * 
	 * @Title: getFile_SortBySort_id
	 * @Description: 动态查询  File_Sort
	 * @author(作者):      ys
	 * @param: @param file
	 * @param: @return   
	 * @return: ToJson<FileSortModel>   树形父节点<File_Sort> list数组
	 * @throws
	 */
	@DynDatasource
	ToJson<FileSortModel> getFileSortBySortId(FileSortModel file);
	
	/**
	 * 
	 * @Title: addFile_Sorts
	 * @Description: 添加目录树文件夹
	 * @author(作者):      ys
	 * @param: @param file
	 * @param: @return   
	 * @return: int   返回目录树影响行
	 * @throws
	 */
	@DynDatasource
	int saveFileSort(FileSortModel file);
	
	/**
	 * 
	 * @Title: updateFile
	 * @Description: 修改目录树文件夹信息
	 * @author(作者):      ys
	 * @param: @param file
	 * @param: @return   
	 * @return: int    返回目录树修改影响行
	 * @throws
	 */
	@DynDatasource
	int updateFileSort(FileSortModel file);
	
	/**
	 * 
	 * @Title: fileDeleteBySort_id
	 * @Description: 删除目录树文件夹信息
	 * @author(作者):      ys
	 * @param: @param fileParent
	 * @param: @return   
	 * @return: int   返回目录树删除影响行
	 * @throws
	 */
	@DynDatasource
	int deleteBySortId(Map<String, Object> fileParent);
	
	/**
	 * 
	 * @Title: getSortChrildren
	 * @Description: 根据某个父节点信息获取目录树子文件夹信息
	 * @author(作者):      ys
	 * @param: @param tempNo
	 * @param: @return   
	 * @return: List<FileSortModel>  返回子目录树List集合 
	 * @throws
	 */
	@DynDatasource
	List<FileSortModel> getSortChrildren(int tempNo);
	
	/**
	 * 
	 * @Title: getRootTree
	 * @Description: 获取目录树父文件夹信息
	 * @author(作者):      ys
	 * @param: @param sortid
	 * @param: @return   
	 * @return: List<FileSortModel>  返回父目录树List集合 
	 * @throws
	 */
	@DynDatasource
	List<FileSortModel> getRootTree(int sortid);
	/**
	 * 
	 * @Title: getChildTree
	 * @Description: 获取所有子文件夹信息
	 * @author(作者):      ys
	 * @param: @param sortid
	 * @param: @return   
	 * @return: List<FileSortModel>   返回所有子目录树List集合
	 * @throws
	 */
	@DynDatasource
	List<FileSortModel> getChildTree(int sortid);
}
