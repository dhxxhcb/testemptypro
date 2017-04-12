package com.xoa.service.notify.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoa.dao.notify.NotifyMapper;
import com.xoa.model.notify.Notify;
import com.xoa.model.users.Users;
import com.xoa.model.worldnews.News;
import com.xoa.service.notify.NotifyService;
import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;

@Service
public class NotifyServiceImpl implements  NotifyService{
	
	@Resource
	private NotifyMapper notifyMapper;
 
	public List<Notify> selectNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) {
		PageParams pageParams = new PageParams();  
        pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        pageParams.setCheckFlag(true);
        maps.put("page", pageParams);  
        List<Notify> list = notifyMapper.selectNotify(maps);
            for (Notify notify1 : list) {
           notify1.setName(notify1.getUsers().getUserName());
           notify1.setUsers(null);
        }
        System.out.println("公告查询条数："+list.size());
		return list;
	}

	@Override
	@Transactional
	public void addNotify(Notify notify) {
		if(notify.getNotifyId()!=-1){
			notifyMapper.updateNotify(notify);
		}else{
			notifyMapper.addNotify(notify);
		}
	}

	@Override
	public List<Notify> getNotifyById(String id) {
		return notifyMapper.getNotifyById(id);
	}

	@Override
	public void delete(String id) {
		notifyMapper.deleteById(id);
	}

}
