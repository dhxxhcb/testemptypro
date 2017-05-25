package com.xoa.service.sys;

import com.xoa.model.sys.InterfaceModel;

import java.util.List;

/**
 *
 */
public interface InterFaceService {
    List<InterfaceModel> getStaTusText();

    void editStatusText(InterfaceModel interfaceModel);
}
