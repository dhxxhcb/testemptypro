package com.xoa.service.todoList;

import com.xoa.model.daiban.Daiban;

public interface TodolistService {
	public Daiban list(String userId,String sqlType)throws Exception;
	
	public Daiban delete(Integer qid,String type);

}
