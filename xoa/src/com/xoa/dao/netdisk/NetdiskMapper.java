package com.xoa.dao.netdisk;

import java.util.List;

import com.xoa.model.netdisk.Netdisk;

/**
 * 
 * @ClassName (类名):  NetdiskMapper
 * @Description(简述): TODO
 * @author(作者):      张丽军
 * @date(日期):        2017-5-8 下午4:08:29
 *
 */
public interface NetdiskMapper {


   /**
    * 
    * @Title: addNetdisk
    * @Description: TODO
    * @author(作者): 张丽军
    * @param: @param netdisk   
    * @return: void   
    * @throws
    */
	void addNetdisk(Netdisk netdisk);
   /**
    * 
    * @Title: selectNetdisk
    * @Description: TODO
    * @author(作者): 张丽军
    * @param: @return   
    * @return: List<Netdisk>   
    * @throws
    */
	List<Netdisk> selectNetdisk();
	/**
	 * 
	 * @Title: delete
	 * @Description: TODO
	 * @author(作者): 张丽军
	 * @param: @param diskId   
	 * @return: void   
	 * @throws
	 */
     void delete(Integer diskId);
     /**
      * 
      * @Title: editNetdisk
      * @Description: TODO
      * @author(作者): 张丽军
      * @param: @param netdisk   
      * @return: void   
      * @throws
      */
	void editNetdisk(Netdisk netdisk);
}