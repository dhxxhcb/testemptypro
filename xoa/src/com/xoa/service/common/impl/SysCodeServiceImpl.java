package com.xoa.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.common.SysCodeMapper;
import com.xoa.model.common.SysCode;
import com.xoa.service.common.SysCodeService;
import com.xoa.util.ToJson;
/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-5-2 下午2:40:05
 * 类介绍  :    系统代码日志表
 * 构造参数:   
 *
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {
	@Resource
	private SysCodeMapper sysCodeMapper;
	 /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-2 下午2:40:40
     * 方法介绍:   根据代码主分类查找信息
     * 参数说明:   @param parentNo
     * 参数说明:   @return
     * @return     SysCode
     */
	@Override
	public ToJson<SysCode> getSysCode(String parentNo) {
		List<SysCode> code=sysCodeMapper.getSysCode(parentNo);
		ToJson<SysCode> codeJson=new ToJson<SysCode>();
		if (code.size()>0) {
			codeJson.setObj(code);
			codeJson.setFlag(0);
			codeJson.setMsg("ok");
		}
		codeJson.setFlag(1);
		codeJson.setMsg("err");
		return codeJson;
	}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月3日 下午4:50:09
	 * 方法介绍:   获取所有系统代码
	 * 参数说明:   @return
	 * @return     List<SysCode>
	 */
	@Override
	public List<SysCode> getAllSysCode() {
		List<SysCode> list=sysCodeMapper.getAllSysCode();
		return list;
}
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年5月4日 上午10:06:41
	 * 方法介绍:   更新系统代码设置表
	 * 参数说明:   @param sysCode 系统代码设置表
	 * @return     void 无
	 */
	@Override
	public void update(SysCode sysCode) {
		sysCodeMapper.update(sysCode);
		
	}
   

}