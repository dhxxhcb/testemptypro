package com.xoa.controller.todoList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.daiban.Daiban;
import com.xoa.model.daiban.TodoList;
import com.xoa.service.todoList.TodolistService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

@Controller
@Scope(value="prototype")
public class TodolistController {
	
	private Logger loger = Logger.getLogger(TodolistController.class);
	
	@Resource
	private TodolistService todolistService;
	
	@ResponseBody
	@RequestMapping(value = "/todoList/list",produces = {"application/json;charset=UTF-8"})
    public ToJson<Daiban> list(HttpServletRequest request,String userId) {
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<Daiban> json=new ToJson<Daiban>(0, null);
		try {
			Daiban db=todolistService.list(userId);
            json.setObject(db);
            json.setMsg("OK");
            json.setFlag(0);
		} catch (Exception e) {
			json.setMsg(e.getMessage());
		}
        return json;
    }

}
