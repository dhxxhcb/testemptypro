package com.xoa.service.todoList;

import com.xoa.model.daiban.Daiban;
import com.xoa.util.dataSource.DynDatasource;

public interface TodolistService {
	@DynDatasource
	public Daiban list(String userId);
	
	@DynDatasource
	public Daiban delete(Integer qid,String type);

}
