package com.xoa.service.syspara;

import com.xoa.model.common.SysPara;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/23 11:41
     * @函数介绍: 获取sys_para, 前端传入key, 获取对应value
     * @参数说明: @param sysPara 封装sys_para表对应的实体类
     * @return: List<SysPara>
     * @param paraName
     * */
    List<SysPara> getTheSysParam(String paraName);




}
