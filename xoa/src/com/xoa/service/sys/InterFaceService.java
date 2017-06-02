package com.xoa.service.sys;

import com.xoa.model.sys.InterfaceModel;

import java.util.List;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/6/2 18:09
 * @类介绍: 软件界面设置处理类
 * @构造参数: 无
 **/
public interface InterFaceService {
    List<InterfaceModel> getStaTusText();

    void editStatusText(InterfaceModel interfaceModel);

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/2 18:08
     * @函数介绍: 系统界面设置
     * @参数说明: @param void
     * @return: List<InterfaceModel></InterfaceModel>
     **/
    List<InterfaceModel> getInterfaceInfo();

    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/6/2 19:04
     * @函数介绍: 修改界面设置
     * @参数说明: @param InterfaceModel 界面设置信息的实体类
     * @return: void
     **/
    void updateInterfaceInfo(InterfaceModel interfaceModel);
}
