package com.xoa.dao.common;

import com.xoa.model.common.SysPara;

    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午6:18:03
     * 类介绍    :   APP对应DAO
     * 构造参数:   无
     *
     */
public interface SysParaMapper {
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-18 下午6:18:48
	 * 方法介绍:   得到APP端对应的菜单
	 * 参数说明:   @return
	 * @return     String 返回APP对应的菜单串
	 */
    public String getSysPara();
}