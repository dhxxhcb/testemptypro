package com.xoa.service.netdisk;

import java.util.List;

import com.xoa.model.netdisk.Netdisk;
import com.xoa.util.dataSource.DynDatasource;
/**
 * 
 * @ClassName (类名):  NetdiskService
 * @Description(简述): 网络硬盘设置接口
 * @author(作者):      张丽军
 * @date(日期):        2017-5-8 下午4:02:04
 *
 */

public interface NetdiskService {
	
	/**
	 * 
	 * @Title: addNetdisk
	 * @Description: 新建
	 * @author(作者): 张丽军
	 * @param: @param netdisk   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
	public void addNetdisk(Netdisk netdisk);
	
	/**
	 * 
	 * @Title: selectNetdisk
	 * @Description: 查询
	 * @author(作者): 张丽军
	 * @param: @return   
	 * @return: List<Netdisk>   
	 * @throws
	 */
	@DynDatasource
	public List<Netdisk> selectNetdisk();
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @author(作者): 张丽军
	 * @param: @param diskId   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
	public void delete(Integer diskId);
    
	/**
	 * 
	 * @Title: editNetdisk
	 * @Description: 编辑
	 * @author(作者): 张丽军
	 * @param: @param netdisk   
	 * @return: void   
	 * @throws
	 */
	@DynDatasource
	public void editNetdisk(Netdisk netdisk);

}
