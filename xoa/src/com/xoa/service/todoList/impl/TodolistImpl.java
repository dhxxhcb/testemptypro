package com.xoa.service.todoList.impl;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.email.EmailBodyMapper;
import com.xoa.dao.notify.NotifyMapper;
import com.xoa.model.daiban.Daiban;
import com.xoa.model.daiban.TodoList;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.email.EmailModel;
import com.xoa.model.notify.Notify;
import com.xoa.service.todoList.TodolistService;
import com.xoa.util.page.PageParams;

@Service
public class TodolistImpl implements TodolistService{

	@Resource
	private EmailBodyMapper email;
	
	@Resource
	private NotifyMapper notify;
	
	@Override
	public Daiban list(String userId){
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("fromId", userId);
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(true);
		pageParams.setPage(1);
		pageParams.setPageSize(10);
		maps.put("page", pageParams);
		List<TodoList> list =new ArrayList<TodoList>();
		List<TodoList> list1 =new ArrayList<TodoList>();
		Daiban db=new Daiban();
		InetAddress address = this.getCurrentIp();
		List<EmailBodyModel> le=email.selectIsRead(maps);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for(EmailBodyModel em:le){
			TodoList td=new TodoList();
			td.setAvater(0);
			td.setContent(em.getContent());
			td.setFromName(em.getSubject());
			td.setImg(address.toString()+"/img/workflow/youjian.png");
			List<EmailModel> lemail=em.getEmailList();
			for(EmailModel e:lemail){
				if(e.getToId().equals(userId)){
					td.setQid(e.getEmailId());
					td.setDeleteFlag(e.getDeleteFlag());
				}
			}				
			td.setReadflag(em.getSendFlag());
			td.setType("email");
			Long e=(long) (em.getSendTime()*1000L);
			String s=f.format(e);
			td.setTime(s);
			td.setUserName(em.getUsers().getUserName());
			td.setIsAttach(em.getAttachment()==null?"0":"1");
			list.add(td);
		}
		List<Notify> ln = notify.unreadNotify(maps);
		for(Notify no:ln){
			TodoList td=new TodoList();
			td.setAvater(0);
			td.setContent(no.getContent());
			td.setFromName(no.getSubject());
			td.setImg(address.toString()+"/img/workflow/daibanliucheng.png");
			td.setQid(no.getNotifyId());
			td.setReadflag(no.getPublish());
			td.setType("notify");		
			String s=f.format(no.getSendTime());
			td.setTime(s);
			td.setDeleteFlag("");
			td.setUserName(no.getUsers().getUserName());
			td.setIsAttach(no.getAttachment()==null?"0":"1");
			list1.add(td);
		}
		db.setEmail(list);
		db.setNotify(list1);	
		return db;
	}
	
	@Override
	public Daiban delete(Integer qid, String type) {
		if(type.equals("email")){
			
		}
		if(type.equals("notify")){
			
		}
		return null;
	}
	
	
	public static InetAddress getCurrentIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration<InetAddress> nias = ni.getInetAddresses();
                while (nias.hasMoreElements()) {
                    InetAddress ia = (InetAddress) nias.nextElement();
                    if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
                        return ia;
                    }
                }
            }
        } catch (SocketException e) {
        }
        return null;
    }

	

}
