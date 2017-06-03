package com.xoa.dao.common;

import com.xoa.model.common.SysCode;

import java.util.List;

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
    public List<SysCode> getSysCode(String parentNo);
    
    /**
     * 创建作者:   张龙飞
     * 创建日期:   2017年5月3日 下午5:03:15
     * 方法介绍:   获取所有系统代码设置表主分类
     * 参数说明:   @return
     * @return     List<SysCode> 返回所有系统代码设置表主分类
     */
    public List<SysCode> getAllSysCode();
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 上午10:06:41
	 * 方法介绍:   更新系统代码设置表
	 * 参数说明:   @param sysCode 系统代码设置表
	 * @return     void 无
	 */
	public void update(SysCode sysCode);

    List<SysCode> getLogType(String parent_no);

    String getLogNameByNo(String codeNo);

    void delete(SysCode sysCode);

    void addSysMainCode(SysCode sysCode);

    List<SysCode> isSysCodeOrderExits(SysCode sysCode);

    List<SysCode> isChildCodeNoExits(SysCode sysCode);

    void addSysChildCode(SysCode sysCode);

    List<SysCode> isSysCodeNoExits(SysCode sysCode);

    List<SysCode> isChildCodeOrderExits(SysCode sysCode);
}