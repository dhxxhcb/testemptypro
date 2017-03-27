package com.xoa.service.unitmanagement.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.unitmanagement.UnitManageMapper;
import com.xoa.model.unitmanagement.UnitManage;
import com.xoa.service.unitmanagement.UnitManageService;

@Service
public class UnitManageServiceImpl implements UnitManageService{

	@Resource
	private UnitManageMapper unitManageMapper;
	
	@Override
	public UnitManage showUnitManage() {
		return unitManageMapper.showUnitManage();
	}


	@Override
	public void addUnitManage(UnitManage unitManage) {
		unitManageMapper.addUnitManage(unitManage);
	}

}
