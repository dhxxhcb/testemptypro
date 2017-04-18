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
 * @ClassName (类名):  FileSortServiceImpl
 * @Description(简述): 文件柜service实现类
 * @author(作者):      ys
 * @date(日期):        2017-4-17 下午4:01:13
 *
 */
@Service
public class FileSortServiceImpl  implements FileSortService{
	@Resource
	FileSortMapper file_SortMapper;
	/**
	 * 
	 * <p>Title: getFile_Sort</p>
	 * <p>Description: 动态查询File_Sort返回json数据</p>
	 * @param file
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#getFile_Sort(com.xoa.model.file.FileSortModel)
	 */
	@Override
	public ToJson<FileSortModel> getFileSortJson(FileSortModel file) {
		ToJson<FileSortModel> toJson = new ToJson<FileSortModel>(0,"显示结果");
		List<FileSortModel> list=file_SortMapper.getFileSort(file);
		toJson.setObj(list);
		return toJson;
	
	}
	/**
	 * 动态查询返回<File_Sort> list数组
	 * @author 杨  胜
	 * @param file 
	 */
	/**
	 * 
	 * <p>Title: getFile_Sorts</p>
	 * <p>Description:动态查询 File_Sort返回<FileSortModel> list数组 </p>
	 * @param file
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#getFile_Sorts(com.xoa.model.file.FileSortModel)
	 */
	@Override
	public List<FileSortModel> getFileSortList(FileSortModel file) {
		return file_SortMapper.getFileSort(file);
	}
	
	/**
	 * 
	 * <p>Title: getFile_SortBySort_id</p>
	 * <p>Description: 动态查询  File_Sort</p>
	 * @param file
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#getFile_SortBySort_id(com.xoa.model.file.FileSortModel)
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
	 * <p>Title: addFile_Sorts</p>
	 * <p>Description: 添加目录树文件夹</p>
	 * @param file
	 * @return int
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#addFile_Sorts(com.xoa.model.file.FileSortModel)
	 */
	@Override
	public int saveFileSort(FileSortModel file) {
		return file_SortMapper.saveFileSort(file);
	}
	
	/**
	 * 
	 * <p>Title: updateFile</p>
	 * <p>Description: 修改目录树文件夹信息</p>
	 * @param file
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#updateFile(com.xoa.model.file.FileSortModel)
	 */
	@Override
	public int updateFileSort(FileSortModel file) {
		return file_SortMapper.updateFileSort(file);
	}
	
	/**
	 * 
	 * <p>Title: fileDeleteBySort_id</p>
	 * <p>Description:删除目录树文件夹信息 </p>
	 * @param fileParent
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#fileDeleteBySort_id(java.util.Map)
	 */
	@Override
	public int deleteBySortId(Map<String, Object> fileParent) {
		return  file_SortMapper.deleteBySortId(fileParent);
	}
	
	/**
	 * 
	 * <p>Title: getSortChrildren</p>
	 * <p>Description:根据某个父节点信息获取目录树子文件夹信息</p>
	 * @param tempNo
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#getSortChrildren(int)
	 */
	@Override
	public List<FileSortModel> getSortChrildren(int tempNo) {
		return file_SortMapper.getSortChrildren(tempNo);
	}
	
	
	/**
	 * 
	 * <p>Title: getRootTree</p>
	 * <p>Description: 获取目录树父文件夹信息</p>
	 * @param sortid
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#getRootTree(int)
	 */
	@Override
	public List<FileSortModel> getRootTree(int sortid) {
		return file_SortMapper.getRootTree(sortid);
	}

	/**
	 * 
	 * <p>Title: getChildTree</p>
	 * <p>Description: 获取所有子文件夹信息 </p>
	 * @param sortid
	 * @return
	 * @author(作者): ys
	 * @see com.xoa.service.file.FileSortService#getChildTree(int)
	 */
	@Override
	public List<FileSortModel> getChildTree(int sortid) {
		return file_SortMapper.getChildTree(sortid);
	}
	
}
