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

}
