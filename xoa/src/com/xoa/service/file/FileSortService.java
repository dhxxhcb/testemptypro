package com.xoa.service.file;

import java.util.List;
import java.util.Map;

import com.xoa.model.file.FileSortModel;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午9:30:25
 * 类介绍  :   文件柜业务层接口
 * 构造参数:   无
 *
 */
public interface FileSortService {

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:30:51
	 * 方法介绍:   动态查询File_Sort返回json数据
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   ToJson<FileSortModel>
	 */
	@DynDatasource
	ToJson<FileSortModel> getFileSortJson(FileSortModel file);
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:07
	 * 方法介绍:   动态查询 File_Sort返回<FileSortModel> list数组
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@DynDatasource
	List<FileSortModel> getFileSortList(FileSortModel file);

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:20
	 * 方法介绍:   动态查询  File_Sort
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     ToJson<FileSortModel>
	 */
	@DynDatasource
	ToJson<FileSortModel> getFileSortBySortId(FileSortModel file);
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:34
	 * 方法介绍:   添加目录树文件夹
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     int
	 */
	@DynDatasource
	int saveFileSort(FileSortModel file);
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:15
	 * 方法介绍:   修改目录树文件夹信息
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     int
	 */
	@DynDatasource
	int updateFileSort(FileSortModel file);
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:26
	 * 方法介绍:   删除目录树文件夹信息
	 * 参数说明:   @param fileParent
	 * 参数说明:   @return
	 * @return     int
	 */
	@DynDatasource
	int deleteBySortId(Map<String, Object> fileParent);
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:37
	 * 方法介绍:   根据某个父节点信息获取目录树子文件夹信息
	 * 参数说明:   @param tempNo
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@DynDatasource
	List<FileSortModel> getSortChrildren(int tempNo);
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:50
	 * 方法介绍:   获取目录树父文件夹信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return   List<FileSortModel>
	 */
	@DynDatasource
	List<FileSortModel> getRootTree(int sortid);

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:57:07
	 * 方法介绍:   获取所有子文件夹信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@DynDatasource
	List<FileSortModel> getChildTree(List<String> sortidList);
     /**
      * 
      * 创建作者:   杨 胜
      * 创建日期:   2017-4-20 上午9:39:32
      * 方法介绍:   添加子文件夹
      * 参数说明:   @param file
      * 参数说明:   @return
      * @return     int
      */
	@DynDatasource
	int saveFileSortChr(FileSortModel file);
}
