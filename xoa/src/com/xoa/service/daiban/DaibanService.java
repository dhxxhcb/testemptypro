package com.xoa.service.daiban;

import java.util.Map;

import com.xoa.model.daiban.Daiban;
import com.xoa.util.dataSource.DynDatasource;

public interface DaibanService {
	@DynDatasource
	public Daiban list(Map<String, Object> maps);

}
