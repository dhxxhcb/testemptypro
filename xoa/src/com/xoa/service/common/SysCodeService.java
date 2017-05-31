package com.xoa.service.common;

import com.xoa.model.common.SysCode;
import com.xoa.util.ToJson;

import java.util.List;

/**
* 创建作者:   王曰岐
* 创建日期:   2017年5月02日 上午9:36:46
* 类介绍  :    系统代码表
* 构造参数:    无
*
*/

public interface SysCodeService {
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-5-2 下午2:38:16
	 * 方法介绍:   根据代码主分类查找信息
	 * 参数说明:   @param parentNo
	 * 参数说明:   @return
	 * @return     List<SysCode>
	 */
	 public ToJson<SysCode> getSysCode(String parentNo);
	 
	 /**
	  * 创建作者:   张龙飞
	  * 创建日期:   2017年5月3日 下午4:50:09
	  * 方法介绍:   获取所有系统代码
	  * 参数说明:   @return
	  * @return     List<SysCode>
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

    List<SysCode> getLogType();
}
