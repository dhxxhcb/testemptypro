package com.xoa.service.daiban.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.email.EmailBodyMapper;
import com.xoa.dao.email.EmailBoxMapper;
import com.xoa.dao.notify.NotifyMapper;
import com.xoa.model.daiban.Daiban;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.notify.Notify;
import com.xoa.service.daiban.DaibanService;

@Service
public class DaibanServiceImpl implements DaibanService{

	@Resource
	private EmailBodyMapper email;
	
	@Resource
	private NotifyMapper notify;
	
	@Override
	public Daiban list(Map<String, Object> maps) {		
		Daiban d=new Daiban();
		List<EmailBodyModel> le=email.selectIsRead(maps);	
		List<Notify> ln = notify.unreadNotify(maps);
		d.setEmail(le);
		d.setNotify(ln);
		return d;
	}

}
