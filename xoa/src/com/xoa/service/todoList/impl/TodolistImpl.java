package com.xoa.service.todoList.impl;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.email.EmailBodyMapper;
import com.xoa.dao.notify.NotifyMapper;
import com.xoa.model.daiban.Daiban;
import com.xoa.model.daiban.TodoList;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.notify.Notify;
import com.xoa.service.todoList.TodolistService;

@Service
public class TodolistImpl implements TodolistService{

	@Resource
	private EmailBodyMapper email;
	
	@Resource
	private NotifyMapper notify;
	
	@Override
	public Daiban list(Map<String, Object> maps){
		List<TodoList> list =new ArrayList<TodoList>();
		List<TodoList> list1 =new ArrayList<TodoList>();
		Daiban db=new Daiban();
		InetAddress address = this.getCurrentIp();
		List<EmailBodyModel> le=email.selectIsRead(maps);
		SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for(EmailBodyModel em:le){
			TodoList td=new TodoList();
			td.setAvater(0);
			td.setContent(em.getContent());
			td.setFromName(em.getSubject());
			td.setImg(address.toString()+"/img/workflow/youjian.png");
			td.setQid(em.getBodyId());
			td.setReadflag(em.getSendFlag());
			td.setType("email");
			Long e=(long) (em.getSendTime()*1000L);
			String s=f.format(e);
			td.setTime(s);
			list.add(td);
		}
		List<Notify> ln = notify.unreadNotify(maps);
		for(Notify no:ln){
			TodoList td=new TodoList();
			td.setAvater(0);
			td.setContent(no.getContent());
			td.setFromName(no.getName());
			td.setImg(address.toString()+"/img/workflow/daibanliucheng.png");
			td.setQid(no.getNotifyId());
			td.setReadflag(no.getPublish());
			td.setType("notify");		
			String s=f.format(no.getSendTime());
			td.setTime(s);
			list1.add(td);
		}
		db.setEmail(list);
		db.setNotify(list1);	
		return db;
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
