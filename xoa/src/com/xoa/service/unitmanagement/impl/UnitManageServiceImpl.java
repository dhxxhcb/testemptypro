package com.xoa.service.unitmanagement.impl;

import javax.annotation.Resource;

import com.xoa.util.GetAttachmentListUtil;
import org.springframework.stereotype.Service;

import com.xoa.dao.unitmanagement.UnitManageMapper;
import com.xoa.model.unitmanagement.UnitManage;
import com.xoa.service.unitmanagement.UnitManageService;

@Service
public class UnitManageServiceImpl implements UnitManageService{

	@Resource
	private UnitManageMapper unitManageMapper;
	
	@Override
	public UnitManage showUnitManage(String sqlType) {
		UnitManage UnitManage=unitManageMapper.showUnitManage();
		if (UnitManage.getAttachmentName()!=null&&UnitManage.getAttachmentId()!=null) {
			UnitManage.setAttachment(GetAttachmentListUtil.returnAttachment(UnitManage.getAttachmentName(), UnitManage.getAttachmentId(), sqlType,GetAttachmentListUtil.MODULE_NEWS));
		}

		return UnitManage;
	}


	@Override
	public void addUnitManage(UnitManage unitManage) {
		unitManageMapper.addUnitManage(unitManage);
	}


	@Override
	public void update(UnitManage unitManage) {
		unitManageMapper.update(unitManage);
		
	}

}
