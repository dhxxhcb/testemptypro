package com.xoa.service.syspara;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xoa.model.common.SysPara;

/**
    * 
    * @ClassName (类名):  SysParaService
    * @Description(简述): 接口
    * @author(作者):      张丽军
    * @date(日期):        2017-5-5 下午4:28:49
    *
    */
@Service
public interface SysParaService {
    /**
     * 
     * @Title: getIeTitle
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: List<SysPara>   
     * @throws
     */
    List<SysPara> getIeTitle();
	
	List<SysPara> getIeTitle1();
    /**
     * 
     * @Title: updateSysPara
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param sysPara   
     * @return: void   
     * @throws
     */
    void updateSysPara(SysPara sysPara);
	
	void updateSysPara1(SysPara sysPara);
	

}
