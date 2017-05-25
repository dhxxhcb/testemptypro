package com.xoa.service.sys.impl;

import com.xoa.dao.sys.SysInterfaceMapper;
import com.xoa.model.sys.InterfaceModel;
import com.xoa.service.sys.InterFaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
