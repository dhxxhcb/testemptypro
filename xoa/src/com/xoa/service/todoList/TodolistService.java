package com.xoa.service.todoList;

import java.util.List;
import java.util.Map;

import com.xoa.model.daiban.Daiban;
import com.xoa.model.daiban.TodoList;
import com.xoa.util.dataSource.DynDatasource;

public interface TodolistService {
	@DynDatasource
	public Daiban list(Map<String, Object> maps);

}
