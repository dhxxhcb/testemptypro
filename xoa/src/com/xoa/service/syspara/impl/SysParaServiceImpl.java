package com.xoa.service.syspara.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.xoa.dao.common.SysParaMapper;
import com.xoa.model.common.SysPara;
import com.xoa.service.syspara.SysParaService;



@Service
public class SysParaServiceImpl  implements SysParaService{
	
	@Resource
	private SysParaMapper sysParaMapper;
    /**
     * 
     * <p>Title: getIeTitle</p>
     * <p>Description: </p>
     * @return
     * @author(作者):  张丽军
     * @see com.xoa.service.syspara.SysParaService#getIeTitle()
     */
	@Override
	public List<SysPara> getIeTitle() {
		
		return sysParaMapper.getIeTitle();
	}
	/**
	 * 
	 * <p>Title: getIeTitle1</p>
	 * <p>Description: </p>
	 * @return
	 * @author(作者):  张丽军
	 * @see com.xoa.service.syspara.SysParaService#getIeTitle1()
	 */
	@Override
	public List<SysPara> getIeTitle1() {
		
		return sysParaMapper.getIeTitle1();
	}


    /**
     * 
     * <p>Title: updateSysPara</p>
     * <p>Description: </p>
     * @param sysPara
     * @author(作者):  张丽军
     * @see com.xoa.service.syspara.SysParaService#updateSysPara(com.xoa.model.common.SysPara)
     */
	@Override
	public void updateSysPara(SysPara sysPara) {
		
		sysParaMapper.updateSysPara(sysPara);
		
	}
	/**
	 * 
	 * <p>Title: updateSysPara1</p>
	 * <p>Description: </p>
	 * @param sysPara
	 * @author(作者):  张丽军
	 * @see com.xoa.service.syspara.SysParaService#updateSysPara1(com.xoa.model.common.SysPara)
	 */
	@Override
	public void updateSysPara1(SysPara sysPara) {
		
		sysParaMapper.updateSysPara1(sysPara);
		
	}

    /**
     *
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/23 11:41
     * @函数介绍: 获取sys_para, 前端传入key, 获取对应value
     * @参数说明: @param paraName
     * @return: List<SysPara>
     */
    @Override
    public List<SysPara> getTheSysParam(String paraName) {

        return sysParaMapper.getTheSysParam(paraName);
    }

}
