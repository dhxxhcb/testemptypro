package com.xoa.dao.common;

import com.xoa.model.common.SysParaModel;
/**
 * 
 * @ClassName (类名):  SysParaMapper
 * @Description(简述): 移动端对应
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午5:52:49
 *
 */
public interface SysParaMapper {
	
	/**
	 * 
	 * @Title: getSysPara
	 * @Description: 查询移动端对应的菜单ID串
	 * @author(作者):      wyq
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
    public String getSysPara();
}