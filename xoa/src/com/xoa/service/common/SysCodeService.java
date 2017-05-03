package com.xoa.service.common;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xoa.model.common.SysCode;
import com.xoa.util.ToJson;

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

}
