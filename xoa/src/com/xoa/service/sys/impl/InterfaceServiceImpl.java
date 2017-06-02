package com.xoa.service.sys.impl;

import com.xoa.dao.sys.SysInterfaceMapper;
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
        sysInterfaceMapper.updateInterfaceInfo(interfaceModel);
    }
}
