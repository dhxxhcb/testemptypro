package com.xoa.service.users;

import com.xoa.model.users.OrgManage;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.DynDatasource;

public interface OrgManageService {
	
	public ToJson<OrgManage> queryId();
	
	@DynDatasource
	public void editOrgManage(OrgManage orgManage);

}
