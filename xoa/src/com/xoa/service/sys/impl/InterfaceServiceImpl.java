package com.xoa.service.sys.impl;

import com.xoa.dao.common.SysParaMapper;
import com.xoa.dao.sys.SysInterfaceMapper;
import com.xoa.model.common.SysPara;
import com.xoa.model.sys.InterfaceModel;
import com.xoa.service.sys.InterFaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/6/2 18:09
 * @类介绍: 软件界面设置处理类
 * @构造参数: 无
 **/
@Service
public class InterfaceServiceImpl implements InterFaceService {

    @Resource
    private SysInterfaceMapper sysInterfaceMapper;

    @Resource
    private SysParaMapper sysParaMapper;

    @Override
    public List<InterfaceModel> getStaTusText() {

        List<InterfaceModel> list = sysInterfaceMapper.getStatusText();

        return list;

    }

    @Override
    public void editStatusText(InterfaceModel interfaceModel) {
        sysInterfaceMapper.editStatusText(interfaceModel.getStatusText());
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/2 18:08
     * @函数介绍: 系统界面设置
     * @参数说明: @param void
     * @return: List<InterfaceModel></InterfaceModel>
     **/
    @Override
    public List<InterfaceModel> getInterfaceInfo() {

        List<InterfaceModel> interfaceModelList = sysInterfaceMapper.getInterfaceInfo();
        List<SysPara> sysParatList = sysParaMapper.getTheSysParam("LOG_OUT_TEXT");
        if (interfaceModelList != null && interfaceModelList.size() == 1) {
            if (sysParatList != null && sysParatList.size() == 1) {
                interfaceModelList.get(0).setLogOutText(sysParatList.get(0).getParaValue());
            }
        }
        return interfaceModelList;
    }

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/2 19:04
     * @函数介绍: 修改界面设置
     * @参数说明: @param InterfaceModel 界面设置信息的实体类
     * @return: void
     */
    @Override
    public void updateInterfaceInfo(InterfaceModel interfaceModel) {

        //如果interfaceModel的所有属性都是null,sysInterfaceMapper.updateInterfaceInfo
        //会报错，所有先判断其中一个属性，如果为null，就是不修改，就从数据库查下来，在添加回数据库，
        //解决sql问题。
        List<InterfaceModel> statusTextList = sysInterfaceMapper.getStatusText();
        if (statusTextList != null && statusTextList.size() == 1) {
            String statusText = statusTextList.get(0).getStatusText();

            if (interfaceModel.getStatusText() == null) {
                interfaceModel.setStatusText(statusText);
            }

        }
        sysInterfaceMapper.updateInterfaceInfo(interfaceModel);

        //sysParaMapper.updateSysPara(sysPara) 如果sysPara的paraValue为null就会报错，所有先判断
        if (interfaceModel != null && interfaceModel.getLogOutText() != null) {
            SysPara sysPara = new SysPara();
            sysPara.setParaValue(interfaceModel.getLogOutText());
            sysPara.setParaName("LOG_OUT_TEXT");
            sysParaMapper.updateSysPara(sysPara);
        }
    }
}
