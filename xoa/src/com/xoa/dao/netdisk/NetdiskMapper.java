package com.xoa.dao.netdisk;

import java.util.List;
import java.util.Map;

import com.xoa.model.netdisk.Netdisk;

/**
 * 
 * @ClassName (类名):  NetdiskMapper
 * @Description(简述): 实现接口
 * @author(作者):      张丽军
 * @date(日期):        2017-5-8 下午4:08:29
 *
 */
public interface NetdiskMapper {


   /**
    * 
    * @Title: addNetdisk
    * @Description: 新建
    * @author(作者): 张丽军
    * @param: @param netdisk   
    * @return: void   
    * @throws
    */
	int addNetdisk(Netdisk netdisk);
   /**
    * 
    * @Title: selectNetdisk
    * @Description: 查询
    * @author(作者): 张丽军
    * @param: @return   
    * @return: List<Netdisk>   
    * @throws
    */
	List<Netdisk> selectNetdisk();
	/**
	 * 
	 * @Title: delete
	 * @Description: 查询
	 * @author(作者): 张丽军
	 * @param: @param diskId   
	 * @return: void   
	 * @throws
	 */
     void delete(Integer diskId);
     /**
      * 
      * @Title: editNetdisk
      * @Description: 编辑
      * @author(作者): 张丽军
      * @param: @param netdisk   
      * @return: void   
      * @throws
      */
	 int editNetdisk(Netdisk netdisk);

	int editNetdiskJurisdiction(Map<String,String> maps);
}