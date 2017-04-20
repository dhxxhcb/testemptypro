package com.xoa.dao.common;

import com.xoa.model.common.Sys_code;
/**
 * 
 * 创建作者:   张丽军
 * 创建日期:   2017-4-19 下午4:10:16
 * 类介绍  :   公告类型接口
 * 构造参数:   无
 *
 */
public interface Sys_codeMapper {
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-19 下午4:32:34
	 * 方法介绍:   删除代码ID(主键)
	 * 参数说明:   @param codeId
	 * 参数说明:   @return
	 * @return     int
	 */
    int deleteByPrimaryKey(Integer codeId);
   
    int insert(Sys_code record);

    int insertSelective(Sys_code record);

    Sys_code selectByPrimaryKey(Integer codeId);

    int updateByPrimaryKeySelective(Sys_code record);

    int updateByPrimaryKey(Sys_code record);
    /**
     * 
     * 创建作者:  张丽军
     * 创建日期:   2017-4-19 下午6:35:53
     * 方法介绍:   get方法
     * 参数说明:   @return
     * @return    String
     */
    public String getSysCode();
}