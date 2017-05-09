package com.xoa.service.users.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.users.OrgManageMapper;
import com.xoa.model.users.OrgManage;
import com.xoa.service.users.OrgManageService;
import com.xoa.util.ToJson;
@Service
public class OrgManageServiceImpl implements OrgManageService {

	@Resource
	private OrgManageMapper orgManageMapper;
	@Override
	public ToJson<OrgManage> queryId(Integer oid) {
		ToJson<OrgManage>  toJson=new ToJson<OrgManage>(0, "");
		 OrgManage org=orgManageMapper.queryId(oid);
		 if (org!=null) {
			 toJson.setMsg("ok");
			 toJson.setObject(org);
		}else {
			 toJson.setMsg("err");
		}
		 
		return toJson;
	}

}
