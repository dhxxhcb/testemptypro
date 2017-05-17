package com.xoa.service.daiban.impl;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
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
	public Daiban list(Map<String, Object> maps){		
		Daiban d=new Daiban();
		d.setEmainContent("邮件");
		d.setNotifyContent("公告");
		InetAddress address = this.getCurrentIp();
		d.setEmailUrl(address.toString()+"/img/workflow/daibanliucheng.png");
		d.setNotifyUrl(address.toString()+"/img/workflow/youjian.png");
		List<EmailBodyModel> le=email.selectIsRead(maps);	
		List<Notify> ln = notify.unreadNotify(maps);
		d.setEmail(le);
		d.setNotify(ln);
		return d;
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
