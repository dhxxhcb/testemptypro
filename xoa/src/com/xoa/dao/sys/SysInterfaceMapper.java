package com.xoa.dao.sys;

import com.xoa.model.sys.InterfaceModel;

import java.util.List;

/**
 *
 */

public interface SysInterfaceMapper {


    List<InterfaceModel> getStatusText();

    void editStatusText(String statusText);

    List<InterfaceModel> getInterfaceInfo();

    void updateInterfaceInfo(InterfaceModel interfaceModel);
}

