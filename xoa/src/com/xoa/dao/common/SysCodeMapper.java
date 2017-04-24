package com.xoa.dao.common;

import com.xoa.model.common.SysCode;

/**
 * 
 * 创建作者:   张丽军
 * 创建日期:   2017-4-19 下午4:10:16
 * 类介绍  :   公告类型接口
 * 构造参数:   无
 *
 */
public interface SysCodeMapper {
    /**
     * 
     * 创建作者:  张丽军
     * 创建日期:   2017-4-19 下午6:35:53
     * 方法介绍:   get方法
     * 参数说明:   @return
     * @return    String
     */
    public SysCode getSysCode(String codeOrder);
    
    public SysCode getSysCode1(String codeNo);
}